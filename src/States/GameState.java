package States;

import Entities.*;
import Essentials.Game;
import Essentials.ImageLoader;

import java.awt.*;

public class GameState extends State {
    private player player;
    private zombie zombie;


    public GameState(Game game){
        super(game);
        player=new player(500,640,game);
        zombie=new zombie(1000,640,game);
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(ImageLoader.loadImage("/animation/background.png"),0,0,null);
        player.render(g);
        zombie.render(g);

    }

    @Override
    public void tick() {
        player.tick();
        zombie.tick();


    }
}
