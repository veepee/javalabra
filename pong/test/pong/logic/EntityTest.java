package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {
    
    @Test
    public void testEntityConstructor_SetBoundingBox() {
        BoundingBox bb = new BoundingBox(0, 0, 10, 10);
        Entity e = new Entity(bb);
        assertEquals(bb, e.getBoundingBox());
    }
    
    @Test
    public void testEntityCollision_OverlappingEntities_ShouldCollide() {
        Entity e1 = new Entity(new BoundingBox(3, 3, 6, 6));
        Entity e2 = new Entity(new BoundingBox(4, 5, 7, 7));
        assertEquals(true, e1.collides(e2));
    }
    
    @Test
    public void testEntityCollision_NonOverlappingEntities_ShouldNotCollide() {
        Entity e1 = new Entity(new BoundingBox(0, 0, 2, 2));
        Entity e2 = new Entity(new BoundingBox(0, 4, 7, 1));
        assertEquals(false, e1.collides(e2));
    }

}
