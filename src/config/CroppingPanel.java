
package config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class CroppingPanel extends JPanel {
     private BufferedImage image;
    private Rectangle cropRect = new Rectangle();
    private Point startPoint;

    public CroppingPanel(BufferedImage image) {
        this.image = image;

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                cropRect.setBounds(0, 0, 0, 0);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = Math.min(startPoint.x, e.getX());
                int y = Math.min(startPoint.y, e.getY());
                int width = Math.abs(startPoint.x - e.getX());
                int height = Math.abs(startPoint.y - e.getY());
                cropRect.setBounds(x, y, width, height);
                repaint();
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
    }

    public Rectangle getCropRectangle() {
        return cropRect;
    }

    public BufferedImage getCroppedImage() {
        if (cropRect.width <= 0 || cropRect.height <= 0) return null;
        return image.getSubimage(cropRect.x, cropRect.y, cropRect.width, cropRect.height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
            g.setColor(Color.RED);
            ((Graphics2D) g).setStroke(new BasicStroke(2));
            g.drawRect(cropRect.x, cropRect.y, cropRect.width, cropRect.height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

    
}
