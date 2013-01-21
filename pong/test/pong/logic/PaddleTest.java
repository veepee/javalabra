package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaddleTest {

    @Test
    public void testPaddleConstructor_SetInitialPosition() {
        Paddle paddle = new Paddle(0, 0);
        assertEquals(0, paddle.getY());
    }
    
    @Test
    public void testPaddleSetter_SetterY() {
        Paddle paddle = new Paddle(0, 0);
        paddle.setY(4);
        assertEquals(4, paddle.getY()); 
    }
    
    @Test
    public void testPaddleMovement_ValidMoveUp_ShouldMove() {
        Paddle paddle = new Paddle(0, 0);
        paddle.moveUp();
        assertEquals(-1, paddle.getY());
    }
    
    @Test
    public void testPaddleMovement_ValidMoveDown_ShouldMove() {
        Paddle paddle = new Paddle(0, 0);
        paddle.moveDown();
        assertEquals(1, paddle.getY());
    }
    
}
