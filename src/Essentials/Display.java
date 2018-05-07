package Essentials;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private Canvas canvas;

    public Display(){
        canvas=new Canvas();
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screensize);
        this.setState(Frame.NORMAL);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        canvas.setMaximumSize(new Dimension(getWidth(),getHeight()));
        canvas.setPreferredSize(new Dimension(getWidth(),getHeight()));
        canvas.setMinimumSize(new Dimension(getWidth(),getHeight()));
        canvas.setFocusable(false);
        this.setVisible(true);
        this.add(canvas);
        this.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame(){return this;}
}
