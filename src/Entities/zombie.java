package Entities;

import Essentials.*;

import java.awt.*;
import java.awt.image.BufferedImage;


public class zombie extends creature {
    private Game game;
    private player player;
    private zombieGenerator zombieGenerator;

    private BufferedImage[] walk;
    private BufferedImage[] walkk;
    private BufferedImage[] attack;
    private BufferedImage[] attackk;
    private BufferedImage[] hurt;
    private BufferedImage[] hurtt;
    private BufferedImage[] dead;
    private BufferedImage[] deadd;
    private Animation animationWalk;
    private Animation animationAttack;
    private Animation animationHurt;
    private Animation animationDead;

    public zombie(float x,float y,Game game,player player,zombieGenerator zombieGenerator){
        super(game,x,y);
        this.game=game;
        walk=new BufferedImage[5];
        walkk=new BufferedImage[5];
        attack=new BufferedImage[6];
        attackk=new BufferedImage[6];
        hurt=new BufferedImage[4];
        hurtt=new BufferedImage[4];
        dead=new BufferedImage[8];
        deadd=new BufferedImage[6];
        this.player=player;
        this.zombieGenerator=zombieGenerator;




        //walk animation array
        walk[0]=imageloader.loadImage("/walk1.png");
        walk[1]=imageloader.loadImage("/walk2.png");
        walk[2]=imageloader.loadImage("/walk3.png");
        walk[3]=imageloader.loadImage("/walk4.png");
        walk[4]=imageloader.loadImage("/walk6.png");

        //zombie 2 walk animation array
        walkk[0]=imageloader.loadImage("/walkk1.png");
        walkk[1]=imageloader.loadImage("/walkk2.png");
        walkk[2]=imageloader.loadImage("/walkk3.png");
        walkk[3]=imageloader.loadImage("/walkk4.png");
        walkk[4]=imageloader.loadImage("/walkk5.png");


        //attack animation array
        attack[0]=imageloader.loadImage("/attack1.png");
        attack[1]=imageloader.loadImage("/attack2.png");
        attack[2]=imageloader.loadImage("/attack3.png");
        attack[3]=imageloader.loadImage("/attack4.png");
        attack[4]=imageloader.loadImage("/attack5.png");
        attack[5]=imageloader.loadImage("/attack6.png");

        //zombie 2 attack animation array
        attackk[0]=imageloader.loadImage("/attackk1.png");
        attackk[1]=imageloader.loadImage("/attackk2.png");
        attackk[2]=imageloader.loadImage("/attackk3.png");
        attackk[3]=imageloader.loadImage("/attackk4.png");
        attackk[4]=imageloader.loadImage("/attackk5.png");
        attackk[5]=imageloader.loadImage("/attackk6.png");

        //hurt animation array
        hurt[0]=imageloader.loadImage("/hurt1.png");
        hurt[1]=imageloader.loadImage("/hurt2.png");
        hurt[2]=imageloader.loadImage("/hurt3.png");
        hurt[3]=imageloader.loadImage("/hurt4.png");

        //zombie 2 hurt animation array
        hurtt[0]=imageloader.loadImage("/hurtt1.png");
        hurtt[1]=imageloader.loadImage("/hurtt2.png");
        hurtt[2]=imageloader.loadImage("/hurtt3.png");
        hurtt[3]=imageloader.loadImage("/hurtt4.png");

        //dead animation array
        dead[0]=imageloader.loadImage("/dead1.png");
        dead[1]=imageloader.loadImage("/dead2.png");
        dead[2]=imageloader.loadImage("/dead3.png");
        dead[3]=imageloader.loadImage("/dead4.png");
        dead[4]=imageloader.loadImage("/dead5.png");
        dead[5]=imageloader.loadImage("/dead6.png");
        dead[6]=imageloader.loadImage("/dead7.png");
        dead[7]=imageloader.loadImage("/dead8.png");

        //zombie 2 dead animation array
        deadd[0]=imageloader.loadImage("/deadd1.png");
        deadd[1]=imageloader.loadImage("/deadd2.png");
        deadd[2]=imageloader.loadImage("/deadd3.png");
        deadd[3]=imageloader.loadImage("/deadd4.png");
        deadd[4]=imageloader.loadImage("/deadd5.png");
        deadd[5]=imageloader.loadImage("/deadd6.png");


        //animations
        if(Entities.player.getLevel()%2!=0){
            animationWalk=new Animation(walk,450);
        }
        else animationWalk=new Animation(walkk,450);
        if(Entities.player.getLevel()%2!=0)
            animationAttack=new Animation(attack,450);
        else animationAttack=new Animation(attackk,450);
        if(Entities.player.getLevel()%2!=0)
            animationHurt=new Animation(hurt,250);
        else animationHurt=new Animation(hurtt,250);
        if (Entities.player.getLevel()%2!=0)
            animationDead=new Animation(dead,190);
        else animationDead=new Animation(deadd,190);

    }


    @Override
    public void render(Graphics g) {
        if (this.isAllDead())
            zombieGenerator.render(g);
            g.drawImage(getCurrentAnimation(), (int) x, (int) y, Display.screenSize.width / 10,
                    Display.screenSize.height / 3, null);
    }

    @Override
    public void tick() {
        animationWalk.tick();
        animationAttack.tick();
        animationHurt.tick();
        animationDead.tick();
        removeDead();
        if(playerCollision()||isDead())
            x+=0;
        else x-=2;

    }

    public boolean playerCollision(){
       if(this.getBounds().intersects(player.getBounds())) {
           System.out.println("collision detected");
           return true;
       }
       return false;
    }



    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,Display.screenSize.width/10,Display.screenSize.height/3);
    }



    public boolean isAttacked(){
            for(int i=0;i<game.getGun().getBullets().size();i++){
                if(game.getGun().getBullets().get(i).getBounds().intersects(this.getBounds())){
                    this.health-=10;
                    System.out.println("zombie attacked");
                    game.getGun().removeBullet(game.getGun().getBullets().get(i));
                    return true;
                }
            }
            return false;

    }

    public boolean isDead(){
        if(health<=0) {
            return true;
        }
        return false;
    }

    public boolean isAllDead(){
       if (zombieGenerator.zombies.isEmpty()) {
           player.setLevel();
           return true;
       }
           else return false;

        }



    public void removeDead(){
        if(this.isDead())
            zombieGenerator.removeZombie(this);
    }

    public BufferedImage getCurrentAnimation(){
      if(playerCollision()){
          player.isAttacked=true;
          return animationAttack.getCurrentScene();}

      if (isAttacked()){

          return animationHurt.getCurrentScene();}

          if(isDead()){
            player.isAttacked=false;
            return animationDead.getCurrentScene();
          }

      else {

          return animationWalk.getCurrentScene();
      }
    }

    public Entities.zombieGenerator getZombieGenerator() {
        return zombieGenerator;
    }
}
