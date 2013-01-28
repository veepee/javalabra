package pong.logic;

public class Paddle extends Entity {
    
    public Paddle(double x, double y) {
        super(new BoundingBox(x, y, 4, 16));
    }

    public double getY() {
        return getBoundingBox().getY();
    }
    
    public void setY(double y) {
        getBoundingBox().setY(y);
    }
    
    public void moveUp(int delta) {
        getBoundingBox().setY(getY() - 1.0 * (delta/10.0));
    }

    public void moveDown(int delta) {
        getBoundingBox().setY(getY() + 1.0 * (delta/10.0));
    }
    
}
