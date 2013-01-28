package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoundingBoxTest {

    @Test
    public void testBoundingBoxConstructor_CreatesBoundingBox() {
        BoundingBox bb = new BoundingBox(1.0, 2.0, 3.0, 4.0);
        assertEquals(1.0, bb.getX(), 1E-6);
        assertEquals(2.0, bb.getY(), 1E-6);
        assertEquals(3.0, bb.getWidth(), 1E-6);
        assertEquals(4.0, bb.getHeight(), 1E-6);
    }
    
    @Test
    public void testBoundingBox_SetterX() {
        BoundingBox bb = new BoundingBox(0.0, 0.0, 2.0, 2.0);
        bb.setX(3.0);
        assertEquals(3.0, bb.getX(), 1E-6);
    }
    
    @Test
    public void testBoundingBox_SetterY() {
        BoundingBox bb = new BoundingBox(0.0, 0.0, 2.0, 2.0);
        bb.setY(3.0);
        assertEquals(3.0, bb.getY(), 1E-6);
    }
    
    @Test
    public void testCollision_OneBox_ShouldCollideWithItself() {
        BoundingBox bb = new BoundingBox(1.0, 2.0, 3.0, 4.0);
        assertEquals(true, bb.collidesWith(bb));
    }
    
    @Test
    public void testCollision_TwoOverlappingBoxes_ShouldCollide() {
        BoundingBox bb1 = new BoundingBox(0.0, 5.0, 10.0, 2.0);
        BoundingBox bb2 = new BoundingBox(5.0, 0.0, 2.0, 10.0);
        assertEquals(true, bb1.collidesWith(bb2));
    }

    @Test
    public void testCollision_TwoNonOverlappingBoxes_ShouldNotCollide() {
        BoundingBox bb1 = new BoundingBox(0.0, 0.0, 4.0, 4.0);
        BoundingBox bb2 = new BoundingBox(5.0, 5.0, 8.0, 8.0);
        assertEquals(false, bb1.collidesWith(bb2));
    }
    
    @Test
    public void testCollision_TouchingBoxes_ShouldCollide() {
        BoundingBox bb1 = new BoundingBox(0.0, 0.0, 2.0, 2.0);
        BoundingBox bb2 = new BoundingBox(2.0, 2.0, 2.0, 2.0);
        assertEquals(true, bb1.collidesWith(bb2));
    }
    
}
