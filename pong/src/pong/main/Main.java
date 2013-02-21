package pong.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import pong.framework.GameStateManager;
import pong.gamestates.MenuState;
import pong.swing.GUI;

/**
 * The Main class
 * @author veepee
 */
public class Main {
    
    /**
     * The entry point
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        
        GUI gui = new GUI("Pong", 640, 480);
        try {
            SwingUtilities.invokeAndWait(gui);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameStateManager manager = new GameStateManager();
        manager.enter(new MenuState(manager, gui));
        gui.dispose();
    }
    
}
