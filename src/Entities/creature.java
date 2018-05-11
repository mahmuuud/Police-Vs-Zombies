package Entities;

import Essentials.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class creature {
    protected float x,y;
    protected BufferedImage image;
    protected int health;
    public abstract void render(Graphics g);
    public abstract void tick();

    public creature(Game game,float x, float y){
        this.x=x;
        this.y=y;
        health=100;
    }

    public void move(){

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
