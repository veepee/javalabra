package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoundingBoxTest {

    @Test
    public void testBoundingBoxConstructor_CreatesBoundingBox() {
        BoundingBox bb = new BoundingBox(1, 2, 3, 4);
        assertEquals(1, bb.getX());
        assertEquals(2, bb.getY());
        assertEquals(3, bb.getWidth());
        assertEquals(4, bb.getHeight());
    }
    
    @Test
    public void testBoundingBox_SetterX() {
        BoundingBox bb = new BoundingBox(0, 0, 2, 2);
        bb.setX(3);
        assertEquals(3, bb.getX());
    }
    
    @Test
    public void testBoundingBox_SetterY() {
        BoundingBox bb = new BoundingBox(0, 0, 2, 2);
        bb.setY(3);
        assertEquals(3, bb.getY());
    }
    
    @Test
    public void testCollision_OneBox_ShouldCollideWithItself() {
        BoundingBox bb = new BoundingBox(1, 2, 3, 4);
        assertEquals(true, bb.collidesWith(bb));
    }
    
    @Test
    public void testCollision_TwoOverlappingBoxes_ShouldCollide() {
        BoundingBox bb1 = new BoundingBox(0, 5, 10, 2);
        BoundingBox bb2 = new BoundingBox(5, 0, 2, 10);
        assertEquals(true, bb1.collidesWith(bb2));
    }

    @Test
    public void testCollision_TwoNonOverlappingBoxes_ShouldNotCollide() {
        BoundingBox bb1 = new BoundingBox(0, 0, 4, 4);
        BoundingBox bb2 = new BoundingBox(5, 5, 8, 8);
        assertEquals(false, bb1.collidesWith(bb2));
    }
    
    @Test
    public void testCollision_TouchingBoxes_ShouldCollide() {
        BoundingBox bb1 = new BoundingBox(0, 0, 2, 2);
        BoundingBox bb2 = new BoundingBox(2, 2, 2, 2);
        assertEquals(true, bb1.collidesWith(bb2));
    }
    
}
