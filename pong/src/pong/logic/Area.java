package pong.logic;

/**
 * Area class representing the game area's bounds
 * @author veepee
 */
public class Area extends Entity {

    /**
     * Creates a new Area with the given parameters
     * @param x X coordinate of the upper-left corner of the area
     * @param y Y coordinate of the upper-left corner of the area
     * @param w Width of the area
     * @param h Height of the area
     */
    public Area(double x, double y, double w, double h) {
        super(new BoundingBox(x, y, w, h));
    }

}