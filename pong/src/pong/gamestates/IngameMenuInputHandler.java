package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.swing.KeyState;

/**
 * The input handler for the IngameMenu game state
 * @author veepee
 */
public class IngameMenuInputHandler implements InputHandler {

    /**
     * The IngameMenu game state this input handler belongs to
     */
    private IngameMenuState ingameMenuState;
    
    /**
     * The keyReleased boolean for storing if any keys were pressed during the last frame
     */
    private boolean keyReleased = true;
    
    /**
     * Creates a new input handler for the IngameMenu game state
     * @param ingameMenuState The IngameMenu game state this input handler belongs to
     */
    public IngameMenuInputHandler(IngameMenuState ingameMenuState) {
        this.ingameMenuState = ingameMenuState;
    }
    
    @Override
    public void handle(long delta, KeyState keyState) {
        keyReleased = keyReleased 
                || (!keyState.isDown(KeyEvent.VK_UP) && !keyState.isDown(KeyEvent.VK_DOWN));
        
        if(keyState.isDown(KeyEvent.VK_UP) && keyReleased) {
            ingameMenuState.setUserSelection((ingameMenuState.getUserSelection() + 3) % 2);
            keyReleased = false;
        }
        if(keyState.isDown(KeyEvent.VK_DOWN) && keyReleased) {
            ingameMenuState.setUserSelection((ingameMenuState.getUserSelection() + 1) % 2);
            keyReleased = false;
        }
        if(keyState.isDown(KeyEvent.VK_ENTER)) {
            if(ingameMenuState.getUserSelection() == 0) {
                ingameMenuState.resume();
            }
            if(ingameMenuState.getUserSelection() == 1) {
                ingameMenuState.exit();
            }
        }
    }

}