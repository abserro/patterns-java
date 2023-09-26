import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ProxyImage implements Image {

    private RealImage realImage;
    private final String filename;
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public BufferedImage getImage() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        return realImage.getImage();
    }

    @Override
    public Point getLocation() {
        return realImage.getLocation();
    }
}