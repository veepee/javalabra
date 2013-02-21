package pong.logic;

/**
 * The AI class providing the bot's AI
 * @author veepee
 */
public class AI {
    
    /**
     * The game in progress
     */
    private Game game;
    
    /**
     * Creates a new AI object
     * @param game The game in progress
     */
    public AI(Game game) {
        this.game = game;
    }
    
    /**
     * Executes the AI code for the current frame
     */
    public void process() {
        game.getAIPaddle().resetMovement();
        
        if(game.getBall().getVelocityX() > 0) {
            handleBallMovingAway();
        } else {
            handleBallMovingCloser();
        }

    }

    /**
     * Handles the case where the ball is moving away from the AI paddle
     */
    private void handleBallMovingAway() {
        if(game.getAIPaddle().getY() < 210) {
            game.getAIPaddle().moveDown();
        } else if(game.getAIPaddle().getY() > 220) {
            game.getAIPaddle().moveUp();
        }
    }

    /**
     * Handles the case where the ball is moving towards the the AI paddle
     */
    private void handleBallMovingCloser() {
        double frames = -((game.getBall().getX() - 38.0) / game.getBall().getVelocityX());
        double dist = frames * Math.abs(game.getBall().getVelocityY());
        
        double x = 0;
        if(game.getBall().getVelocityY() < 0) {
            if(dist < (game.getBall().getY() - 63.0)) {
                x = game.getBall().getY() - dist;
            } else {
                x = (dist - ((game.getBall().getY() - 63.0)) % 357.0) + 63.0;
            }
        } else {
            if(dist < (357.0 - game.getBall().getY())) {
                x = game.getBall().getY() + dist;
            } else {
                x = 420.0 - (dist - ((357.0 - game.getBall().getY())) % 357.0) + 63.0;
            }
        }

        if(game.getAIPaddle().getY() > x + 5) {
            game.getAIPaddle().moveUp();
        } else if(game.getAIPaddle().getY() < x - 5) {
            game.getAIPaddle().moveDown();
        }
    }

}