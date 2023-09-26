import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class RealImage implements Image {
    private BufferedImage image;
    private int x;
    private int y;

    public RealImage(String filename) {

        try {
            image = read(new File(filename));;
        } catch (IOException e) {
            image = null;
        }
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public Point getLocation() {
        return new Point(x, y);
    }
}
