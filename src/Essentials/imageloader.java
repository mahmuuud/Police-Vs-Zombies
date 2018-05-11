package Essentials;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class imageloader {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(imageloader.class.getResourceAsStream(path));
        } catch (IOException e) {
            System.exit(1);
        }
        return null;
    }
}
