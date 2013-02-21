package pong.logic;

import pong.highscores.HighscoresDAO;

/**
 * The Game class representing a single Pong game instance
 * @author veepee
 */
public class Game {

    /**
     * The amount of the lives given to the player at the beginning of the game
     */
    private static final int PLAYER_LIVES = 3;
    
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
     * The PlayerScore holding the current score of the player
     */
    private PlayerScore playerScore;
    
    /**
     * The AI
     */
    private AI ai;
    
    /**
     * The HighscoresDAO for reading the highscores data
     */
    private HighscoresDAO highscores;
    
    /**
     * The player's lives left
     */
    private int playerLives;
    
    /**
     * Is the game frozen
     */
    private boolean isFrozen = false;
    
    /**
     * Is the game over
     */
    private boolean isGameOver = false;
    
    /**
     * Is the ball sticky (sticks to the player's paddle)
     */
    private boolean isBallSticky;
    
    /**
     * Is the ball already launched (i.e. the game is live)
     */
    private boolean ballLaunched;
    
    /**
     * Creates a new Pong game
     */
    public Game() {
        ball = new Ball(350.0 - 8.0, 215.0 - 8.0);
        aiPaddle = new Paddle(38.0, 215.0 - 32.0);
        playerPaddle = new Paddle(575.0, 215.0 - 32.0);
        
        topBorderArea = new Area(0.0, 0.0, 630.0, 63.0);
        bottomBorderArea = new Area(0.0, 420.0, 630.0, 30.0);
        
        aiScoringArea = new Area(0.0, 0.0, 30.0, 450.0);
        playerScoringArea = new Area(600.0, 0.0, 30.0, 450.0);
        
        playerScore = new PlayerScore();

        resetGame();
        
        ai = new AI(this);
        playerLives = PLAYER_LIVES;

        highscores = new HighscoresDAO("highscores.dat");
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
     * Returns the remaining lives of the player
     * @return the remaining lives of the player 
    */
    public int getPlayerLives() {
        return playerLives;
    }
    
    /**
     * Returns the current player score
     * @return The current player score
     */
    public int getPlayerScore() {
        return playerScore.getScore();
    }
    
    /**
     * Returns the current top score
     * @return The current top score
     */
    public int getHighScore() {
        return highscores.getHighestScore();
    }
    
    /**
     * Sets the ball launched
     */
    public void launchBall() {
        ballLaunched = true;
    }
    
    /**
     * Returns if the game is frozen
     * @return True, if the game is frozen, false otherwise
     */
    public boolean isGameFrozen() {
        return isFrozen;
    }
    
    /**
     * Returns if the game is over
     * @return True, if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return isGameOver;
    }
        
    /**
     * Updates the game logic
     * @param delta Time passed since last game logic update in milliseconds
     */
    public void updateLogic(long delta) {
        if(isBallSticky) {
            handleStickyBall();
        }
        
        checkPaddleCollisions();
        checkBallCollisions();
        updateEntities(delta);
        updateScore(delta);
    }
    
    /**
     * Game logic related to the handling of the sticky ball
     */
    private void handleStickyBall() {
        ball.setVelocityX(0.0);
        ball.setVelocityY(0.0);
        
        ball.setX(558.0);
        ball.setY(playerPaddle.getY() + 24.0);
        
        if(ballLaunched) {
            ball.setVelocityX(-3.0);
            ball.applySpin(playerPaddle.getVelocityY());
            
            isBallSticky = false;
            ballLaunched = false;
        }
    }

    /**
     * Check the paddle-border collisions
     */
    private void checkPaddleCollisions() {
        if (aiPaddle.collides(topBorderArea)) {
            aiPaddle.setY(64);
        }
        if (aiPaddle.collides(bottomBorderArea)) {
            aiPaddle.setY(353);
        }

        if (playerPaddle.collides(topBorderArea)) {
            playerPaddle.setY(64);
        }
        if (playerPaddle.collides(bottomBorderArea)) {
            playerPaddle.setY(353);
        }
    }

    /**
     * Check the ball-paddle collisions
     */
    private void checkBallCollisions() {
        if(ball.collides(topBorderArea) || ball.collides(bottomBorderArea)) {
            ball.invertVelocityY();
        }
        
        if(ball.collides(aiScoringArea)) {
            resetGame();
        }
        
        if(ball.collides(playerScoringArea) && !isFrozen) {
            playerLives--;
            
            if(playerLives > 0) {
                freezeGame();
            } else {
                isGameOver = true;
            }
        }
        
        if(ball.collides(playerPaddle) && ball.getVelocityX() > 0) {
            ball.invertVelocityX();
            ball.setVelocityX(ball.getVelocityX() - 0.1);
            ball.applySpin(playerPaddle.getVelocityY() / 4);  
        }
        if(ball.collides(aiPaddle) && ball.getVelocityX() < 0) {
            ball.invertVelocityX();
            ball.setVelocityX(ball.getVelocityX() + 0.1);
            ball.applySpin(aiPaddle.getVelocityY() / 4); 
        }
    }
    
    /**
     * Update the AI, paddles and the ball
     * @param delta Time passed since the last update, in milliseconds
     */
    private void updateEntities(long delta) {
        ai.process();
        aiPaddle.update((int)delta);
        playerPaddle.update((int)delta);
        ball.update((int)delta);
    }
    
    /**
     * Update the player score
     * @param delta Time passed since the last update, in milliseconds
     */
    private void updateScore(long delta) {
        if(!isFrozen && !isBallSticky) {
            playerScore.update(delta);
        }
    }
    
    /**
     * Resets the game
     */
    private void resetGame() {
        isBallSticky = true;
        ballLaunched = false;
        
        aiPaddle.setX(38.0);
        aiPaddle.setY(215.0 - 32.0);
        aiPaddle.setVelocityX(0.0);
        aiPaddle.setVelocityY(0.0);
        
        playerPaddle.setY(575.0);
        playerPaddle.setY(215.0 - 32.0);
        playerPaddle.setVelocityX(0.0);
        playerPaddle.setVelocityY(0.0);
        
        ball.setX(350.0 - 8.0);
        ball.setY(215.0 - 8.0);
        ball.setVelocity(0.0, 0.0);
    }

    /**
     * Freezes the game
     */
    private void freezeGame() {
        isFrozen = true;
        ball.setVelocityX(0.0);
        ball.setVelocityY(0.0);
        aiPaddle.setVelocityY(0.0);
        playerPaddle.setVelocityY(0.0);
    }
    
    /**
     * Unfreezes the game
     */
    public void unfreezeGame() {
        isFrozen = false;
        resetGame();
    }

}