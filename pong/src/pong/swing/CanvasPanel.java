package pong.swing;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * The CanvasPanel class providing a double buffered JPanel implementation for
 * drawing 2D graphics
 * @author veepee
 */
public class CanvasPanel extends JPanel {

    /**
     * The BufferedImage serving as the front buffer
     */
    private volatile BufferedImage front;
    /**
     * The BufferedImage serving as the back buffer
     */
    private volatile BufferedImage back;
    
    /**
     * Creates a new double buffered CanvasPanel for 2D graphics
     */
    public CanvasPanel() {
    }
    
    /**
     * Initializes the CanvasPanel's buffers
     */
    public void init() {
        front = (BufferedImage)createImage(this.getWidth(), this.getHeight());
        back = (BufferedImage)createImage(this.getWidth(), this.getHeight());
    }
    
    /**
     * Returns the back buffer ready to be drawn
     * @return The back buffer
     */
    public BufferedImage getBuffer() {
        return back;
    }
    
    /**
     * Swaps the front and back buffers updating the CanvasPanel
     */
    public void swapBuffers() {
        BufferedImage bi = front;
        front = back;
        back = bi;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D)graphics;
        g2.drawImage(front, 0, 0, null);
    }
}
