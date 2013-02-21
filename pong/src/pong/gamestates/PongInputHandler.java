package pong.gamestates;

import java.awt.event.KeyEvent;
import pong.framework.InputHandler;
import pong.logic.Game;
import pong.swing.KeyState;

public class PongInputHandler implements InputHandler {

    private PongState pongState;
    private Game game;
    
    private int delay;
    
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
