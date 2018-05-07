package Essentials;

import Entities.Gun;
import States.GameState;
import States.State;

import java.awt.*;
import java.awt.image.*;

public class Game implements Runnable {
    private Thread thread;
    private Display display;
    private boolean running;
    private State menuState;
    private Gun gun=new Gun(this);
    private Graphics g;
    private keyInputs keyInputs=new keyInputs();//to avoid null pointer exception in thread run method
    public Game(){
        display=new Display();
        screen s=new screen();
        start();
        State gameState = new GameState(this);
        gameState.setState(gameState);
        //keyInputs=new keyInputs();
        display.addKeyListener(keyInputs);
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
        //end drawing
        bs.show();
        g.dispose();
    }

    public void tick(){
       keyInputs.tick();
        if(State.getState() != null)
            State.getState().tick();
        gun.tick();

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
}
