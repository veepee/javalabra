package pong.logic;

/**
 * The PlayerScore class for storing the player score
 * @author veepee
 */
public class PlayerScore {

    /**
     * The current player score (points)
     */
    private double playerScore;
    
    /**
     * Creates a new PlayerScore object with zero points
     */
    public PlayerScore() {
        this.playerScore = 0.0;
    }
    
    /**
     * Returns the current player score
     * @return The current player score
     */
    public int getScore() {
        return (int)Math.round(playerScore);
    }
    
    /**
     * Resets the player score
     */
    public void reset() {
        playerScore = 0.0;
    }
    
    /**
     * Updates the player score
     * @param delta Time passed since the last update, in milliseconds
     */
    public void update(long delta) {
        playerScore += delta/50.0;
    }
}