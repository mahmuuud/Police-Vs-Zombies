package Entities;

import Essentials.Game;

import java.awt.*;

public class Bullet {
    private int x;

    public Bullet(int x, Game game){
        this.x=x;
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x+(182/2),  840, 15, 5);
    }

    public void tick(){
        x+=30;
    }

    public int getX() {
        return x;
    }
}
