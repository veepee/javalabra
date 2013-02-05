package pong.logic;

/**
 * The Game class representing a single Pong game instance
 * @author veepee
 */
public class Game {

    /**
     * The pong ball
     */
    private Ball ball;
    /**
     * The AI player's paddle
     */
    private Paddle aiPaddle;
    /**
     * The human player's paddle
     */
    private Paddle playerPaddle;
    
    /**
     * The area bordering the upper bounds of the game area
     */
    private Entity topBorderArea;
    /**
     * The area bordering the lower bounds of the game area
     */
    private Entity bottomBorderArea;
    
    /**
     * The AI player's end area at the left side of the game area
     */
    private Entity aiScoringArea;
    /**
     * The human player's end area at the right side of the game area
     */
    private Entity playerScoringArea;
    
    /**
     * Creates a new Pong game
     */
    public Game() {
        ball = new Ball(387.0, 277.0);
        aiPaddle = new Paddle(50.0, 253.0);
        playerPaddle = new Paddle(740.0, 253.0);
        
        topBorderArea = new Area(0.0, 0.0, 790.0, 1.0);
        bottomBorderArea = new Area(0.0, 569.0, 790.0, 1.0);
        
        aiScoringArea = new Area(0.0, 0.0, 1.0, 570.0);
        playerScoringArea = new Area(789.0, 0.0, 1.0, 570.0);
    }
    
    /**
     * Returns the pong ball 
     * @return The pong ball
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Returns the AI player's paddle
     * @return The AI player's paddle
     */
    public Paddle getAIPaddle() {
        return aiPaddle;
    }
    
    /**
     * Returns the human player's paddle
     * @return The human player's paddle
     */
    public Paddle getPlayerPaddle() {
        return playerPaddle;
    }
    
    /**
     * Updates the game logic
     * @param delta Time passed since last game logic update in milliseconds
     */
    public void updateLogic(int delta) {
    }
}