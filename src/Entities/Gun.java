package Entities;

import Essentials.Game;

import java.awt.*;
import java.util.ArrayList;

public class Gun {
    private ArrayList<Bullet> bullets;
    private Bullet b;
    Game game;

    public Gun(Game game){
        bullets=new ArrayList<>();
        this.game=game;
    }

    public void tick(){
        for(int i=0;i<bullets.size();i++){
            b=bullets.get(i);
            if(b.getX()>game.getDisplay().getWidth())
                removeBullet(b);
            b.tick();
        }
    }

    public void render(Graphics g){
        for(int i=0;i<bullets.size();i++){
            b=bullets.get(i);
            b.render(g);
        }
    }

    public ArrayList<Bullet> getBullets(){
        return this.bullets;
    }

    public void addBullet(Bullet b){
        this.bullets.add(b);
    }

    public void removeBullet(Bullet b){
        this.bullets.remove(b);
    }




}
