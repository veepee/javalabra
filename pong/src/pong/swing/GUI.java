package pong.swing;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * The main GUI class using Swing. Creates the GUI window (JFrame),
 * graphics panel (CanvasPanel) and keyboard listener (KeyEventListener).
 * @author veepee
 */
public class GUI implements Runnable {

    /**
     * Application window JFrame
     */
    private JFrame frame;
    
    /**
     * CanvasPanel for 2D graphics
     */
    private CanvasPanel canvas;
    
    /**
     * KeyEventListener for handling the keyboard input
     */
    private KeyEventListener listener;
  
    /**
     * The window title
     */
    private String windowTitle;
    
    /**
     * The window size
     */
    private Dimension windowSize;
    
    /**
     * Creates a new GUI window with the given properties
     * @param windowTitle Window title
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     */
    public GUI(String windowTitle, int windowWidth, int windowHeight) {
        this.windowTitle = windowTitle;
        this.windowSize = new Dimension(windowWidth, windowHeight);
    }
    
    @Override
    public void run() {
        frame = new JFrame(windowTitle);
        
        frame.setPreferredSize(windowSize);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        canvas = new CanvasPanel();
        frame.getContentPane().add(canvas);
        
        frame.pack();
        frame.setVisible(true);
        
        canvas.init();
                
        listener = new KeyEventListener();
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(listener);
    }

    /**
     * Returns the CanvasPanel of the GUI window
     * @return CanvasPanel used for 2D graphics
     */
    public CanvasPanel getCanvasPanel() {
        return canvas;
    }
    
    /**
     * Returns the KeyEventListener of the GUI window
     * @return KeyEventListener handling the keyboard input
     */
    public KeyEventListener getKeyEventListener() {
        return listener;
    }
    
    /**
     * Disposes the Swing JFrame cleanly
     */
    public synchronized void dispose() {
        frame.dispose();
    }
}
