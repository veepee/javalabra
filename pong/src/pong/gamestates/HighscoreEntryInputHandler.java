package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.swing.KeyState;

/**
 * The input handler for the HighscoreEntry game state
 * @author veepee
 */
public class HighscoreEntryInputHandler implements InputHandler {

    /**
     * The HighscoreEntry game state this input handler belongs to
     */
    private HighscoreEntryState highscoreEntryState;
    
    /**
     * Keys that were pressed during the last frame
     */
    private boolean[] keysPressed;
    
    /**
     * Creates a new input handler for the HighscoreEntry game state
     * @param highscoreEntryState The HighscoreEntry game state this input handler belongs to
     */
    public HighscoreEntryInputHandler(HighscoreEntryState highscoreEntryState) {
        this.highscoreEntryState = highscoreEntryState;
        
        keysPressed = new boolean[255];
    }
    
    @Override
    public void handle(long delta, KeyState keyState) {
        handleAlphanumeric(keyState);
        
        if(keyState.isDown(KeyEvent.VK_BACK_SPACE)) {
            String input = highscoreEntryState.getUserInput();
            if(input.length() > 0 && !keysPressed[KeyEvent.VK_BACK_SPACE]) {
                highscoreEntryState.setUserInput(input.substring(0, input.length() - 1));
                keysPressed[KeyEvent.VK_BACK_SPACE] = true;
            }
        } else {
            keysPressed[KeyEvent.VK_BACK_SPACE] = false;
        }
        
        if(keyState.isDown(KeyEvent.VK_ENTER)) {
            highscoreEntryState.submit();
        }

    }

    /**
     * Handles the alphanumeric keys
     * @param keyState The KeyState to be read
     */
    private void handleAlphanumeric(KeyState keyState) {
        for(int i = 48; i <= 90; i++) {
            if(keyState.isDown(i)) {
                if(!keysPressed[i]) {
                    highscoreEntryState.setUserInput(highscoreEntryState.getUserInput() + (char)i);
                    keysPressed[i] = true;
                }
            } else {
                keysPressed[i] = false;
            }
        }
    }
}