package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {
    
    @Test
    public void testEntityConstructor_SetBoundingBox() {
        BoundingBox bb = new BoundingBox(0.0, 0.0, 10.0, 10.0);
        Entity e = new Entity(bb);
        assertEquals(bb, e.getBoundingBox());
    }
    
    @Test
    public void testEntityCollision_OverlappingEntities_ShouldCollide() {
        Entity e1 = new Entity(new BoundingBox(3.0, 3.0, 6.0, 6.0));
        Entity e2 = new Entity(new BoundingBox(4.0, 5.0, 7.0, 7.0));
        assertEquals(true, e1.collides(e2));
    }
    
    @Test
    public void testEntityCollision_NonOverlappingEntities_ShouldNotCollide() {
        Entity e1 = new Entity(new BoundingBox(0.0, 0.0, 2.0, 2.0));
        Entity e2 = new Entity(new BoundingBox(0.0, 4.0, 7.0, 1.0));
        assertEquals(false, e1.collides(e2));
    }
    
    @Test
    public void testEntityCollision_AccountsForVelocity_ShouldNowCollide() {
        Entity e1 = new Entity(new BoundingBox(0.0, 0.0, 2.0, 2.0));
        e1.setVelocityY(4.0);
        Entity e2 = new Entity(new BoundingBox(0.0, 4.0, 7.0, 1.0));
        assertEquals(true, e1.collides(e2));
    }

    @Test
    public void testEntityCollision_AccountsForVelocity_ShouldntNowCollide() {
        Entity e1 = new Entity(new BoundingBox(3.0, 3.0, 6.0, 6.0));
        e1.setVelocityX(-8.0);
        Entity e2 = new Entity(new BoundingBox(4.0, 5.0, 7.0, 7.0));
        assertEquals(false, e1.collides(e2));
    }
}
