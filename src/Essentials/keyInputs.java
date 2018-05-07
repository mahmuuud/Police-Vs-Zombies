package Essentials;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInputs implements KeyListener {
    private boolean[] keys;
    public boolean attack,left,right;

    public keyInputs(){
        keys=new boolean[256];
    }

    public void tick(){
        right=keys[KeyEvent.VK_RIGHT];
        left=keys[KeyEvent.VK_LEFT];
        attack=keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
}
