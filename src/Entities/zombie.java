package Entities;

import Essentials.Animation;
import Essentials.Game;
import Essentials.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class zombie extends creature {
    private Game game;
    private BufferedImage[] walk;
    private BufferedImage[] attack;
    private BufferedImage[] hurt;
    private BufferedImage[] dead;
    private Animation animationWalk;
    private Animation animationAttack;

    public zombie(float x,float y,Game game){
        super(game,x,y);
        this.game=game;
        walk=new BufferedImage[5];
        attack=new BufferedImage[6];


        //walk animation array
        walk[0]=ImageLoader.loadImage("/animation/walk1.png");
        walk[1]=ImageLoader.loadImage("/animation/walk2.png");
        walk[2]=ImageLoader.loadImage("/animation/walk3.png");
        walk[3]=ImageLoader.loadImage("/animation/walk4.png");
        walk[4]=ImageLoader.loadImage("/animation/walk6.png");

        //attack animation array
        attack[0]=ImageLoader.loadImage("/animation/attack1.png");
        attack[1]=ImageLoader.loadImage("/animation/attack2.png");
        attack[2]=ImageLoader.loadImage("/animation/attack3.png");
        attack[3]=ImageLoader.loadImage("/animation/attack4.png");
        attack[4]=ImageLoader.loadImage("/animation/attack5.png");
        attack[5]=ImageLoader.loadImage("/animation/attack6.png");


        //animations
        animationWalk=new Animation(walk,500);

    }


    @Override
    public void render(Graphics g) {
       g.drawImage(animationWalk.getCurrentScene(),(int)x,(int)y,182,377,null);
    }

    @Override
    public void tick() {
        animationWalk.tick();
            x-=2;
    }
}
