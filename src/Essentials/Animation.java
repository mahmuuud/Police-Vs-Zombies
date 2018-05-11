package Essentials;

import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage[] movie;
    private int index;
    private int timePerScene;
    private long timer;
    private long callTime;
    public boolean deadSceneEnd;

    public Animation(BufferedImage[] movie,int timePerScene) {
        this.movie = movie;
        this.timePerScene=timePerScene;
        callTime = System.currentTimeMillis();
        timer = 0;
        index = 0;
    }

    public void tick() {
        timer += System.currentTimeMillis() - callTime;
        callTime = System.currentTimeMillis();
        if (timer > timePerScene) { //check timer to play the next scene
            index++;
            timer = 0;

            if(index>=movie.length&&timePerScene==190)
                endScene();

            if (index >= movie.length) {
                 index = 0;
            }


        }
    }

    public void endScene(){
        return;
    }



    public BufferedImage getCurrentScene(){
        return movie[index];
    }
}

