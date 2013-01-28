package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaddleTest {

    @Test
    public void testPaddleConstructor_SetInitialPosition() {
        Paddle paddle = new Paddle(0.0, 0.0);
        assertEquals(0.0, paddle.getY(), 1E-6);
    }
    
    @Test
    public void testPaddleSetter_SetterY() {
        Paddle paddle = new Paddle(0.0, 0.0);
        paddle.setY(4.0);
        assertEquals(4.0, paddle.getY(), 1E-6); 
    }
    
    @Test
    public void testPaddleMovement_ValidMoveUp_ShouldMove() {
        Paddle paddle = new Paddle(0.0, 0.0);
        paddle.moveUp(10);
        assertEquals(-1.0, paddle.getY(), 1E-6);
    }
    
    @Test
    public void testPaddleMovement_ValidMoveDown_ShouldMove() {
        Paddle paddle = new Paddle(0.0, 0.0);
        paddle.moveDown(10);
        assertEquals(1.0, paddle.getY(), 1E-6);
    }
    
    @Test
    public void testPaddleMovement_ValidMoveUp_IsFramerateIndependent() {
        Paddle paddle = new Paddle(0.0, 0.0);
        paddle.moveUp(30);
        assertEquals(-3.0, paddle.getY(), 1E-6);
    }
    
}
