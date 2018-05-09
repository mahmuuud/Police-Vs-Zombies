package States;

import Entities.*;
import Essentials.Display;
import Essentials.Game;
import Essentials.ImageLoader;

import java.awt.*;

public class GameState extends State {
    private player player;

    private zombieGenerator zombieGenerator;


    public GameState(Game game){
        super(game);
        //(500,640)
        player=new player(Display.screenSize.width/4,
                Display.screenSize.height-((Display.screenSize.height/3)+Display.screenSize.height/14),game);
        zombieGenerator=new zombieGenerator(player,game);
        zombieGenerator.addZombie();
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(ImageLoader.loadImage("/animation/background.png"),0,0,Display.screenSize.width,
                Display.screenSize.height,null);
        player.render(g);
        zombieGenerator.render(g);

    }

    @Override
    public void tick() {
        player.tick();
        zombieGenerator.tick();


    }
}
