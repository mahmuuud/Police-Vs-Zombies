package Entities;

import Essentials.*;


import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private zombie zombie;

    public Bullet(int x,int y, Game game){
        this.x=x;
        this.y=y;
        this.zombie=zombie;
    }

    public void render(Graphics g){
        g.drawImage(imageloader.loadImage("/bullet3.png"),x+(182/2),
                y,Display.screenSize.width/96,
                Display.screenSize.height/96,null);
    }

    public void tick(){
        x+=30;
    }

    public  Rectangle getBounds(){
        return new Rectangle(x,y,Display.screenSize.width/96,Display.screenSize.height/96);
    }


    public int getX() {
        return x;
    }
}
