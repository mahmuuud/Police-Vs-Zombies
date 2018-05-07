package Entities;
import Essentials.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class player extends creature {

    private BufferedImage[] walk;
    private BufferedImage[] walk1;
    private BufferedImage[] attack;
    private BufferedImage[] hurt;
    private BufferedImage[] dead;
    private BufferedImage[] idle;
    private Game game;
    private Animation animationWalkRight;
    private Animation animationWalkLeft;
    private Animation animationAttack;
    private Animation animationIdle;
    private Animation currentAnimation;
    public player(float x,float y,Game game){
        super(game,x,y);
        this.game=game;
        walk=new BufferedImage[8];
        walk1=new BufferedImage[8];
        attack=new BufferedImage[1];
        dead=new BufferedImage[5];
        hurt=new BufferedImage[5];
        idle=new BufferedImage[8];

        //walk animation array
        walk[0]=ImageLoader.loadImage("/animation/policewalk1.png");
        walk[1]=ImageLoader.loadImage("/animation/policewalk2.png");
        walk[2]=ImageLoader.loadImage("/animation/policewalk3.png");
        walk[3]=ImageLoader.loadImage("/animation/policewalk4.png");
        walk[4]=ImageLoader.loadImage("/animation/policewalk5.png");
        walk[5]=ImageLoader.loadImage("/animation/policewalk6.png");
        walk[6]=ImageLoader.loadImage("/animation/policewalk7.png");
        walk[7]=ImageLoader.loadImage("/animation/policewalk8.png");

        //attack animation array
        attack[0]=ImageLoader.loadImage("/animation/policeattack1.png");

        //walk left direction animation
        walk1[0]=ImageLoader.loadImage("/animation/policewalk1.1.png");
        walk1[1]=ImageLoader.loadImage("/animation/policewalk2.1.png");
        walk1[2]=ImageLoader.loadImage("/animation/policewalk3.1.png");
        walk1[3]=ImageLoader.loadImage("/animation/policewalk4.1.png");
        walk1[4]=ImageLoader.loadImage("/animation/policewalk5.1.png");
        walk1[5]=ImageLoader.loadImage("/animation/policewalk6.1.png");
        walk1[6]=ImageLoader.loadImage("/animation/policewalk7.1.png");
        walk1[7]=ImageLoader.loadImage("/animation/policewalk8.1.png");

        //idle state animation
        idle[0]=ImageLoader.loadImage("/animation/policeidle1.png");
        idle[1]=ImageLoader.loadImage("/animation/policeidle2.png");
        idle[2]=ImageLoader.loadImage("/animation/policeidle3.png");
        idle[3]=ImageLoader.loadImage("/animation/policeidle4.png");
        idle[4]=ImageLoader.loadImage("/animation/policeidle5.png");
        idle[5]=ImageLoader.loadImage("/animation/policeidle6.png");
        idle[6]=ImageLoader.loadImage("/animation/policeidle7.png");
        idle[7]=ImageLoader.loadImage("/animation/policeidle8.png");

        //animation
        animationIdle=new Animation(idle,500);
        animationWalkRight=new Animation(walk,200);
        animationWalkLeft=new Animation(walk1,200);
        animationAttack=new Animation(attack,200);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(),(int)x,(int)y,182,377,null);

    }

    @Override
    public void tick() {
        animationWalkRight.tick();
        animationWalkLeft.tick();
        animationIdle.tick();
        animationAttack.tick();
        if(game.getKeyInputs().left)
            x -= 3;
        if(game.getKeyInputs().right)
            x += 3;

    }

    public BufferedImage getCurrentAnimation(){
        if(game.getKeyInputs().right)
            return animationWalkRight.getCurrentScene();
        if(game.getKeyInputs().attack)
            return animationAttack.getCurrentScene();
        if(game.getKeyInputs().left)
            return animationWalkLeft.getCurrentScene();
        else return animationIdle.getCurrentScene();
    }

    public void setAnimationAttack(){

    }
}
