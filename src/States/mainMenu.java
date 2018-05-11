package States;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import Essentials.*;
import java.io.File;

public class mainMenu extends JFrame {
   private BufferedImage icon;
    private Dimension screensize;
    private Animation animationMenu;
    private BufferedImage[] frames;

    public mainMenu(){
        screensize=Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0,0,screensize.width,screensize.height);
        frames=new BufferedImage[22];
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setVisible(true);


        //frames array
        frames[0]=imageloader.loadImage("/frame1.gif");
        frames[1]=imageloader.loadImage("/frame2.gif");
        frames[2]=imageloader.loadImage("/frame3.gif");
        frames[3]=imageloader.loadImage("/frame4.gif");
        frames[4]=imageloader.loadImage("/frame5.gif");
        frames[5]=imageloader.loadImage("/frame6.gif");
        frames[6]=imageloader.loadImage("/frame7.gif");
        frames[7]=imageloader.loadImage("/frame8.gif");
        frames[8]=imageloader.loadImage("/frame9.gif");
        frames[9]=imageloader.loadImage("/frame10.gif");
        frames[10]=imageloader.loadImage("/frame11.gif");
        frames[11]=imageloader.loadImage("/frame12.gif");
        frames[12]=imageloader.loadImage("/frame13.gif");
        frames[13]=imageloader.loadImage("/frame14.gif");
        frames[14]=imageloader.loadImage("/frame15.gif");
        frames[15]=imageloader.loadImage("/frame16.gif");
        frames[16]=imageloader.loadImage("/frame17.gif");
        frames[17]=imageloader.loadImage("/frame18.gif");
        frames[18]=imageloader.loadImage("/frame19.gif");
        frames[19]=imageloader.loadImage("/frame20.gif");
        frames[20]=imageloader.loadImage("/frame21.gif");
        frames[21]=imageloader.loadImage("/frame22.gif");
        animationMenu=new Animation(frames,200);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.getX()>=screensize.width/2-250 && e.getX()<=screensize.width/2+250 &&
                        e.getY()>=screensize.height/3+100 && e.getY()<=screensize.height/3+190){
                        Game game=new Game();
                        close();

                }

                else if (e.getX()>=(screensize.width/2-250) && e.getX()<=screensize.width/2+250 &&
                        e.getY()>=screensize.height/3+280 && e.getY()<=screensize.height/3+340){
                    close();
                }
            }
        });

        while (true){
            render(getGraphics());
            tick();
        }
    }

    public void render(Graphics g){
        g=getGraphics();
        g.drawImage(animationMenu.getCurrentScene(),0,0,screensize.width,screensize.height,null);

    }

    public void tick(){
        animationMenu.tick();
    }

    public void close(){
        this.dispose();
    }



}
