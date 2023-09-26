import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        String testFile = "resources/Соник0.jpg";
        ProxyImage image = new ProxyImage(testFile);
        JFrame frame = new JFrame("Proxy Pattern");
        frame.setPreferredSize(new Dimension(1920, 1080));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ImagePanel(image));
        frame.pack();
        frame.setVisible(true);
    }
}