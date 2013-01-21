package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BallTest {
   
    @Test
    public void testBallConstructor_SetInitialPosition() {
        Ball ball = new Ball(1, -2);
        assertEquals(1, ball.getX());
        assertEquals(-2, ball.getY());
    }
    
    @Test
    public void testBallMovement_SetVelocity() {
        Ball ball = new Ball(0, 0);
        ball.setVelocity(1, 2);
        assertEquals(1, ball.getVelocity()[0]);
        assertEquals(2, ball.getVelocity()[1]);
    }
    
    @Test
    public void testBallMovement_UpdateBall_ShouldMoveBall() {
        Ball ball = new Ball(0, 0);
        ball.setVelocity(3, 2);
        ball.update();
        assertEquals(3, ball.getX());
        assertEquals(2, ball.getY());
    }
    
}
