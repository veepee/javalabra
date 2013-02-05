package pong.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class AreaTest {
    
    @Test
    public void testAreaConstructor_ConstructsBoundingBoxWithGivenValues() {
        Area area = new Area(13.0, 26.0, 44.0, 77.0);
        assertEquals(13.0, area.getBoundingBox().getX(), 1E-6);
        assertEquals(26.0, area.getBoundingBox().getY(), 1E-6);
        assertEquals(44.0, area.getBoundingBox().getWidth(), 1E-6);
        assertEquals(77.0, area.getBoundingBox().getHeight(), 1E-6);
    }

}