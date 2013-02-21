package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.swing.KeyState;

public class HighscoresInputHandler implements InputHandler {

    private HighscoresState highscoresState;
    
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