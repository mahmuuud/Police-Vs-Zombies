package Entities;

import Essentials.Display;
import Essentials.Game;

import java.awt.*;
import java.util.ArrayList;

public class zombieGenerator {
    ArrayList<zombie> zombies;
    player player;
    Game game;
    Gun gun;

    public zombieGenerator(player player,Game game,Gun gun){
        this.player=player;
        zombies=new ArrayList<>();
        this.game=game;
        this.gun=gun;


    }

    public void render(Graphics g){
        for(int i=0;i<zombies.size();i++){
            zombies.get(i).render(g);
        }
    }

    public void tick(){
        for(int i=0;i<zombies.size();i++){
            zombies.get(i).tick();
            }
    }

    public void addZombie(){
        for(int i=1;i<=player.getLevel();i++){
            //(2000,640)
            zombies.add(new zombie(Display.screenSize.width+80+120*i,
                    Display.screenSize.height-((Display.screenSize.height/3)+Display.screenSize.height/14),
                    game,this.player,this));
            zombies.add(new zombie(Display.screenSize.width+280+120*i,
                    Display.screenSize.height-((Display.screenSize.height/3)+Display.screenSize.height/14),
                    game,this.player,this));
        }

    }

    public void removeZombie(zombie zombie){
        zombies.remove(zombie);
    }

    public ArrayList<zombie> getZombies() {
        return zombies;
    }
}
