package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.swing.KeyState;

/**
 * The input handler for the Highscores game state
 * @author veepee
 */
public class HighscoresInputHandler implements InputHandler {

    /**
     * The Highscores game state this input handler belongs to
     */
    private HighscoresState highscoresState;
    
    /**
     * Creates a new input handler for the Highscores game state
     * @param highscoresState The Highscores game state this input handler belongs to
     */
    public HighscoresInputHandler(HighscoresState highscoresState) {
        this.highscoresState = highscoresState;
    }
    
    @Override
    public void handle(long delta, KeyState keyState) {
        if(keyState.isDown(KeyEvent.VK_ESCAPE)) {
            highscoresState.exit();
        }
    }
}