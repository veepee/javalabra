package pong.framework;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pong.swing.CanvasPanel;

/**
 * The Renderer base class all renderers will extend
 * @author veepee
 */
public abstract class Renderer {
    
    /**
     * The CanvasPanel this renderer will draw to
     */
    private CanvasPanel canvas;
    
    /**
     * Creates a new Renderer
     * @param canvas CanvasPanel to be used for drawing
     */
    public Renderer(CanvasPanel canvas) {
        this.canvas = canvas;
    }
    
    /**
     * Renders the frame
     */
    public void render() {
        BufferedImage buf = canvas.getBuffer();
        Graphics2D g = buf.createGraphics();

        g.setBackground(Color.BLACK);
        g.clearRect(0, 0, buf.getWidth(), buf.getHeight());
        
        onRender(g);
        
        canvas.swapBuffers();
    }
    
    /**
     * Is called once on each new frame to be renderer
     * @param g Graphics2D object for drawing onto the current buffer
     */
    public abstract void onRender(Graphics2D g);   
}