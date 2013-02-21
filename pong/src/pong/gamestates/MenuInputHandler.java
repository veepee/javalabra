package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.swing.KeyState;

/**
 * The input handler for the Menu game state
 * @author veepee
 */
public class MenuInputHandler implements InputHandler {

    /**
     * The Menu game state this input handler belongs to
     */
    private MenuState menuState;
    
    /**
     * The keyReleased boolean for storing if any keys were pressed during the last frame
     */
    private boolean keyReleased = true;
    
    /**
     * Creates a new input handler for the Menu game state
     * @param menuState The Menu game state this input handler belongs to
     */
    public MenuInputHandler(MenuState menuState) {
        this.menuState = menuState;
    }
    
    @Override
    public void handle(long delta, KeyState keyState) {
        keyReleased = keyReleased 
                || (!keyState.isDown(KeyEvent.VK_UP) && !keyState.isDown(KeyEvent.VK_DOWN) && !keyState.isDown(KeyEvent.VK_ENTER));
        
        if(keyState.isDown(KeyEvent.VK_UP) && keyReleased) {
            menuState.setUserSelection((menuState.getUserSelection() + 2) % 3);
            keyReleased = false;
        }
        if(keyState.isDown(KeyEvent.VK_DOWN) && keyReleased) {
            menuState.setUserSelection((menuState.getUserSelection() + 1) % 3);
            keyReleased = false;
        }
        
        if(keyState.isDown(KeyEvent.VK_ENTER) && keyReleased) {
            keyReleased = false;
            if(menuState.getUserSelection() == 0) {
                menuState.startNewGame();
            }
            if(menuState.getUserSelection() == 1) {
                menuState.showHighscores();
            }
            if(menuState.getUserSelection() == 2) {
                menuState.quit();
            }
        }
    }
}
