package pong.logic;

public class Area extends Entity {

    public Area(double x, double y, double w, double h) {
        super(new BoundingBox(x, y, w, h));
    }

}