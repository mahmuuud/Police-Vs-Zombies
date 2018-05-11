package States;

import Entities.*;
import Essentials.*;


import java.awt.*;

public class GameState extends State {



    public GameState(Game game){
        super(game);
        //(500,640)


    }
    @Override
    public void render(Graphics g) {
        if(player.getLevel()%2!=0)
            g.drawImage(imageloader.loadImage("/background.png"),0,0,Display.screenSize.width,
                    Display.screenSize.height,null);
        else    g.drawImage(imageloader.loadImage("/background1.png"),0,0,Display.screenSize.width,
                Display.screenSize.height,null);


    }

    @Override
    public void tick() {



    }
}
