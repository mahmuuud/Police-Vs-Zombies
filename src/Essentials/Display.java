package Essentials;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private Canvas canvas;
    public static Dimension screenSize;
    public Display(){
        canvas=new Canvas();
         screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize);
        this.setState(Frame.NORMAL);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        canvas.setMaximumSize(new Dimension(getWidth(),getHeight()));
        canvas.setPreferredSize(new Dimension(getWidth(),getHeight()));
        canvas.setMinimumSize(new Dimension(getWidth(),getHeight()));
        canvas.setFocusable(false);
        System.out.println(screenSize);
        this.setVisible(true);
        this.add(canvas);
        this.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame(){return this;}
}
