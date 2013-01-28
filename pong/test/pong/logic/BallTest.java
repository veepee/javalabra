package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BallTest {
   
    @Test
    public void testBallConstructor_SetInitialPosition() {
        Ball ball = new Ball(1.0, -2.0);
        assertEquals(1, ball.getX(), 1E-6);
        assertEquals(-2, ball.getY(), 1E-6);
    }
    
    @Test
    public void testBallMovement_SetVelocity() {
        Ball ball = new Ball(0.0, 0.0);
        ball.setVelocity(1.0, 2.0);
        assertEquals(1.0, ball.getVelocity()[0], 1E-6);
        assertEquals(2.0, ball.getVelocity()[1], 1E-6);
    }
    
    @Test
    public void testBallMovement_UpdateBall_ShouldMoveBall() {
        Ball ball = new Ball(0.0, 0.0);
        ball.setVelocity(3.0, 2.0);
        ball.update(10);
        assertEquals(3.0, ball.getX(), 1E-6);
        assertEquals(2.0, ball.getY(), 1E-6);
    }
    
    @Test
    public void testBallMovement_UpdateBall_IsFramerateIndependent() {
        Ball ball = new Ball(0.0, 0.0);
        ball.setVelocity(3.0, 2.0);
        ball.update(40);
        assertEquals(12.0, ball.getX(), 1E-6);
        assertEquals(8.0, ball.getY(), 1E-6);  
    }
}
