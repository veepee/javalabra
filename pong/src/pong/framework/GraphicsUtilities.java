package pong.framework;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * The GraphicsUtilities class providing static helper functions for setting font rendering style
 * and drawing aligned strings
 * @author veepee
 */
public class GraphicsUtilities {
    
    /**
     * Sets the default font and anti-aliasing for the given Graphics2D object
     * @param g The Graphics2D object changes are applied to
     */
    public static void setDefaultFont(Graphics2D g) {
        g.setFont(new Font("Terminal", Font.PLAIN, 16));
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    
    /**
     * Draws a centered string
     * @param g The Graphics2D object used for drawing the string
     * @param s String to be drawn
     * @param x X-coordinate, center of the string
     * @param y Y-coordinate, center of the string
     */
    public static void printCenteredString(Graphics2D g, String s, int x, int y) {
        g.drawString(s, x - (int)(g.getFontMetrics().getStringBounds(s, g).getWidth())/2, y);
    }

}