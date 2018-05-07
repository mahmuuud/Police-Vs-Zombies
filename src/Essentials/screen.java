package Essentials;

import javax.swing.*;
import java.awt.*;

public class screen {
    GraphicsDevice vc;
    public screen()

    {

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();


    }

    public void setFullScreenWindow(DisplayMode dm, JFrame window){
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);

        if(dm!=null&&vc.isDisplayChangeSupported()){
            try {
                vc.setDisplayMode(dm);

            }catch (Exception e){}
        }

    }

    public Window getFullScreenWindow(){
        return vc.getFullScreenWindow();
    }

    public void restoreScreenSize(){
        Window w=vc.getFullScreenWindow();
        if (w!=null)
            w.dispose();
        vc.setFullScreenWindow(null);
    }






}
