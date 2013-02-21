package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.logic.Game;
import pong.swing.KeyState;

/**
 * The input handler for the Pong game state
 * @author veepee
 */
public class PongInputHandler implements InputHandler {

    /**
     * The Pong game state this input handler belongs to
     */
    private PongState pongState;
    /**
     * The Game instance this input handler is attached onto
     */
    private Game game;
    
    /**
     * Delay for avoiding a single key press being registered twice
     */
    private int delay;
    
    /**
     * Creates a new input handler for the Pong game state
     * @param pongState
     * @param game 
     */
    public PongInputHandler(PongState pongState, Game game) {
        this.pongState = pongState;
        this.game = game;
    }
    
    @Override
    public void handle(long delta, KeyState keyState) {
        game.getPlayerPaddle().resetVelocity();

        if(keyState.isDown(KeyEvent.VK_ESCAPE)) {
            pongState.enterIngameMenu();
        }
        
        if(!game.isGameFrozen() && delay == 0) {
            if(keyState.isDown(KeyEvent.VK_UP)) {
                game.getPlayerPaddle().moveUp();
            }
            if(keyState.isDown(KeyEvent.VK_DOWN)) {
                game.getPlayerPaddle().moveDown();
            }
        
            if(keyState.isDown(KeyEvent.VK_SPACE)) {
                game.launchBall();
            }
        } else {
            if(keyState.isDown(KeyEvent.VK_SPACE)) {
                game.unfreezeGame();
                delay = 5;
            }
            delay--;
        }
    }

}
