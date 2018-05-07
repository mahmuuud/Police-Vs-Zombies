import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class test extends JFrame {
    Image icon;
    public test(){
        this.setSize(new Dimension(500,500));
        this.setLayout(new BorderLayout());
        {
            try {
                icon = new ImageIcon("/animation/g.gif").getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.drawImage(icon,0,0,this.getWidth(),this.getHeight(),this);
    }
}
