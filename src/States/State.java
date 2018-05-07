package States;

import Essentials.Game;

import java.awt.*;

public abstract class State {
    private static State state=null;
    private Game game;

    public State(Game game){
        this.game=game;
    }

    public abstract void render(Graphics g);

    public abstract void tick();

    public static State getState(){
        return state;
    }

    public void setState(State s){
        state=s;
    }
}
