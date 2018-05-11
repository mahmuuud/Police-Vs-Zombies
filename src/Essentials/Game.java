package Essentials;

import Entities.*;
import States.GameState;
import States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Game implements Runnable {
    private Thread thread;
    private Display display;
    private boolean running;
    private Gun gun;
    private  zombieGenerator zombieGenerator;
    private  player player;
    private Graphics g;
    private keyInputs keyInputs=new keyInputs();//to avoid null pointer exception in thread run method
    public Game(){
        display=new Display();
        screen s=new screen();
        State gameState = new GameState(this);
        gameState.setState(gameState);
        //keyInputs=new keyInputs();
        display.addKeyListener(keyInputs);
        player=new player(Display.screenSize.width/4,
                Display.screenSize.height-((Display.screenSize.height/3)+Display.screenSize.height/14),this);
        zombieGenerator=new zombieGenerator(player,this,gun);
        zombieGenerator.addZombie();
        gun=new Gun(this);
        start();

    }

    public void render(){
        BufferStrategy bs=display.getCanvas().getBufferStrategy();
        if(bs==null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
         g=bs.getDrawGraphics();
        g.clearRect(0,0,display.getWidth(),display.getHeight());
        //draw
        if(State.getState()!=null){
            State.getState().render(g);
        }
        gun.render(g);
        player.render(g);
        zombieGenerator.render(g);
        //end drawing
        bs.show();
        g.dispose();
    }

    public void tick(){
        System.out.println(player.getLevel());
        levelUp();
       keyInputs.tick();
        if(State.getState() != null)
            State.getState().tick();
        gun.tick();
        player.tick();
        zombieGenerator.tick();

    }

    public void run(){
        while (running){
            render(); //paint objects
            tick(); //update variables coordinates and states

        }
        stop();

    }

    public keyInputs getKeyInputs() {
        return keyInputs;
    }

    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Display getDisplay(){
        return this.display;
    }

    public Gun getGun() {
        return gun;
    }

    public void levelUp(){
        if(zombieGenerator.getZombies().isEmpty()){
            player.setLevel();
            zombieGenerator.addZombie();
        }
    }
}
