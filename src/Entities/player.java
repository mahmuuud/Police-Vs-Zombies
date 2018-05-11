package Entities;
import Essentials.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class player extends creature {

    private static BufferedImage[] walk;
    private static BufferedImage[] walk1;
    private static BufferedImage[] attack;
    private static BufferedImage[] hurt;
    private static BufferedImage[] dead;
    private static BufferedImage[] idle;
    private static int level;
    private Game game;
    private zombie zombie;
    protected boolean isAttacked;
    private static Animation animationWalkRight;
    private static Animation animationWalkLeft;
    private static Animation animationAttack;
    private static Animation animationIdle;
    private static Animation animationDead;
    private static Animation animationHurt;
    public player(float x,float y,Game game){
        super(game,x,y);
        this.game=game;
        this.level=1;
        walk=new BufferedImage[8];
        walk1=new BufferedImage[8];
        attack=new BufferedImage[1];
        dead=new BufferedImage[5];
        hurt=new BufferedImage[5];
        idle=new BufferedImage[8];
        dead=new BufferedImage[5];

        //walk animation array
        walk[0]=imageloader.loadImage("/policewalk1.png");
        walk[1]=imageloader.loadImage("/policewalk2.png");
        walk[2]=imageloader.loadImage("/policewalk3.png");
        walk[3]=imageloader.loadImage("/policewalk4.png");
        walk[4]=imageloader.loadImage("/policewalk5.png");
        walk[5]=imageloader.loadImage("/policewalk6.png");
        walk[6]=imageloader.loadImage("/policewalk7.png");
        walk[7]=imageloader.loadImage("/policewalk8.png");

        //attack animation array
        attack[0]=imageloader.loadImage("/policeattack1.png");

        //walk left direction animation
        walk1[0]=imageloader.loadImage("/policewalk1.1.png");
        walk1[1]=imageloader.loadImage("/policewalk2.1.png");
        walk1[2]=imageloader.loadImage("/policewalk3.1.png");
        walk1[3]=imageloader.loadImage("/policewalk4.1.png");
        walk1[4]=imageloader.loadImage("/policewalk5.1.png");
        walk1[5]=imageloader.loadImage("/policewalk6.1.png");
        walk1[6]=imageloader.loadImage("/policewalk7.1.png");
        walk1[7]=imageloader.loadImage("/policewalk8.1.png");

        //idle state animation
        idle[0]=imageloader.loadImage("/policeidle1.png");
        idle[1]=imageloader.loadImage("/policeidle2.png");
        idle[2]=imageloader.loadImage("/policeidle3.png");
        idle[3]=imageloader.loadImage("/policeidle4.png");
        idle[4]=imageloader.loadImage("/policeidle5.png");
        idle[5]=imageloader.loadImage("/policeidle6.png");
        idle[6]=imageloader.loadImage("/policeidle7.png");
        idle[7]=imageloader.loadImage("/policeidle8.png");

        //dead animation array
        dead[0]=imageloader.loadImage("/pdead1.png");
        dead[1]=imageloader.loadImage("/pdead2.png");
        dead[2]=imageloader.loadImage("/pdead3.png");
        dead[3]=imageloader.loadImage("/pdead4.png");
        dead[4]=imageloader.loadImage("/pdead5.png");

        //hurt animation array
        hurt[0]=imageloader.loadImage("/phurt1.png");
        hurt[1]=imageloader.loadImage("/phurt2.png");
        hurt[2]=imageloader.loadImage("/phurt3.png");
        hurt[3]=imageloader.loadImage("/phurt4.png");
        hurt[4]=imageloader.loadImage("/phurt5.png");


        //animation
        animationIdle=new Animation(idle,500);
        animationWalkRight=new Animation(walk,200);
        animationWalkLeft=new Animation(walk1,200);
        animationAttack=new Animation(attack,200);
        animationDead=new Animation(dead,190);
        animationHurt=new Animation(hurt,150);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(),(int)x,(int)y,Display.screenSize.width/10,
                Display.screenSize.height/3,null);
        //182x377
    }

    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,Display.screenSize.width/10,Display.screenSize.height/3);
    }



    @Override
    public void tick() {
        if (isDead())
            System.exit(3);
        animationWalkRight.tick();
        animationWalkLeft.tick();
        animationIdle.tick();
        animationAttack.tick();
        animationHurt.tick();
        animationDead.tick();
        if(isAttacked) {
            health-=3;
            System.out.println("attacked");
        }
        if(game.getKeyInputs().left)
            x -= 3;
        if(game.getKeyInputs().right)
            x += 3;
        if(game.getKeyInputs().attack){
            game.getGun().addBullet(new Bullet((int)x,(int)y+(Display.screenSize.height/6)+(
                    Display.screenSize.height/75),game));
        }




    }

    public boolean isDead(){
        if(this.health<=0)
            return true;
        else return false;
    }



    public BufferedImage getCurrentAnimation(){
        if(game.getKeyInputs().right)
            return animationWalkRight.getCurrentScene();
        if(game.getKeyInputs().attack)
            return animationAttack.getCurrentScene();
        if(game.getKeyInputs().left)
            return animationWalkLeft.getCurrentScene();
        if(isDead())
            return animationDead.getCurrentScene();
        if (isAttacked)
            return animationHurt.getCurrentScene();

        else return animationIdle.getCurrentScene();
    }

    public static int getLevel() {
        return level;
    }

    public void setLevel(){
        ++level;
    }
}
