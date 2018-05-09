package Entities;

import Essentials.Display;
import Essentials.Game;
import Essentials.ImageLoader;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;

    public Bullet(int x,int y, Game game){
        this.x=x;
        this.y=y;
    }

    public void render(Graphics g){
        g.drawImage(ImageLoader.loadImage("/animation/bullet3.png"),x+(182/2),
                y,Display.screenSize.width/96,
                Display.screenSize.height/96,null);
    }

    public void tick(){
        x+=30;
    }

    public int getX() {
        return x;
    }
}
