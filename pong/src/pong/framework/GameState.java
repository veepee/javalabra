package pong.framework;

/**
 * The GameState interface all game states must implement
 * @author veepee
 */
public interface GameState {
    
    /**
     * Is called on entering the game state
     */
    public void onEnter();
    /**
     * Is called on exiting the game state
     */
    public void onExit();
    /**
     * Is called once each frame
     * @param delta Time passed since last update in milliseconds
     */
    public void update(long delta);
    
}
