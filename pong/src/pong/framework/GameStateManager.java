package pong.framework;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GameStateManager handling the execution of all the game state instances
 * @author veepee
 */
public class GameStateManager {
    
    /**
     * Stack containing all the game states
     */
    private Stack<GameState> states;
    
    /**
     * Creates a new GameStateManager with empty game state stack
     */
    public GameStateManager() {
        states = new Stack<GameState>();
    }
    
    /**
     * Enters a new GameState
     * @param state GameState instance to be entered
     */
    public void enter(GameState state) {
        states.push(state);
        state.onEnter(); 
        run();
    }
    
    /**
     * Exits the currently executing GameState
     */
    public void exit() {
        states.peek().onExit();
        states.pop();
    }
    
    /**
     * Starts the GameStateManager and begins dispatching game states.
     * Method will exit when there are no more game states available on the stack.
     */
    public void run() {  
        
        while(!states.isEmpty()) {
            long t = System.nanoTime();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameStateManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            states.peek().update((System.nanoTime() - t)/1000000);
        }
    }

}