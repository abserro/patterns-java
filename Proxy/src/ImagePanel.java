import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel implements MouseListener {

    private final BufferedImage image;
    private final Point location;
    private boolean loadingImage;

    public ImagePanel(Image image) {
        this.image = image.getImage();
        loadingImage = false;
        location = new Point(0, 0);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (loadingImage) {
            g2d.drawImage(image, location.x, location.y, this);
        }
        g.drawRect(location.x, location.y, image.getWidth(), image.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            loadingImage = true;
        } else if (e.getClickCount() == 1) {
            location.x = e.getX();
            location.y = e.getY();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}