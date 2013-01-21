package pong.logic;

public class Paddle extends Entity {
    
    public Paddle(int x, int y) {
        super(new BoundingBox(x, y, 4, 16));
    }

    public int getY() {
        return getBoundingBox().getY();
    }
    
    public void setY(int y) {
        getBoundingBox().setY(y);
    }
    
    public void moveUp() {
        getBoundingBox().setY(getY() - 1);
    }

    public void moveDown() {
        getBoundingBox().setY(getY() + 1);
    }
    
}
