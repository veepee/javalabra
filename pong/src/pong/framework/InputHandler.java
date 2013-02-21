package pong.framework;

import pong.swing.KeyState;

/**
 * The InputHandler interface all game state input handlers must implement
 * @author veepee
 */
public interface InputHandler {
    
    /**
     * Handles the game state's user input for the current frame
     * @param delta
     * @param keyState 
     */
    public void handle(long delta, KeyState keyState);
}
