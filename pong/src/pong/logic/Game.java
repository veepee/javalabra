package pong.logic;

public class Game {

    private Ball ball;
    private Paddle aiPaddle;
    private Paddle playerPaddle;
    
    private Entity topBorderArea;
    private Entity bottomBorderArea;
    
    private Entity aiScoringArea;
    private Entity playerScoringArea;
    
    public Game() {
        ball = new Ball(387.0, 277.0);
        aiPaddle = new Paddle(50.0, 253.0);
        playerPaddle = new Paddle(740.0, 253.0);
        
        topBorderArea = new Area(0.0, 0.0, 790.0, 1.0);
        bottomBorderArea = new Area(0.0, 569.0, 790.0, 1.0);
        
        aiScoringArea = new Area(0.0, 0.0, 1.0, 570.0);
        playerScoringArea = new Area(789.0, 0.0, 1.0, 570.0);
    }
    
    public Ball getBall() {
        return ball;
    }

    public Paddle getAIPaddle() {
        return aiPaddle;
    }
    
    public Paddle getPlayerPaddle() {
        return playerPaddle;
    }
    
    public void updateLogic(int delta) {
    }
}