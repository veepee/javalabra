package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGameConstructor_CreatesABall() {
        Game game = new Game();
        assertEquals(true, game.getBall() instanceof Ball);
    }
    
    @Test
    public void testGameConstructor_CreatesTwoPaddles_PaddlesAreDifferent() {
        Game game = new Game();
        assertEquals(true, game.getAIPaddle() instanceof Paddle);
        assertEquals(true, game.getPlayerPaddle() instanceof Paddle);
        assertEquals(false, game.getAIPaddle() == game.getPlayerPaddle());
    }
    
    @Test
    public void testGameConstructor_BallAndPaddles_DoNotCollide() {
        Game game = new Game();
        assertEquals(false, game.getBall().collides(game.getAIPaddle()));
        assertEquals(false, game.getBall().collides(game.getPlayerPaddle()));
        assertEquals(false, game.getAIPaddle().collides(game.getPlayerPaddle()));
    }
    
}