package pong.logic;

/**
 * The Paddle class representing the paddle
 * @author veepee
 */
public class Paddle extends Entity {
    
    /**
     * The movement speed of the paddle
     */
    public static final double PADDLE_SPEED = 2.0;
    
    /**
     * Creates a new paddle
     * @param x X coordinate of the upper-left corner of the paddle
     * @param y Y coordinate of the upper-left corner of the paddle
     */
    public Paddle(double x, double y) {
        super(new BoundingBox(x, y, 16, 64));
    }

    /**
     * Returns the X coordinate of the upper-left corner of the paddle
     * @return X coordinate of the upper-left corner of the paddle
     */
    public double getX() {
        return getBoundingBox().getX();
    }
    
    /**
     * Returns the Y coordinate of the upper-left corner of the paddle
     * @return Y coordinate of the upper-left corner of the paddle
     */
    public double getY() {
        return getBoundingBox().getY();
    }
    
    /**
     * Sets the X coordinate of the upper-left corner of the paddle
     * @param x X coordinate of the upper-left corner of the paddle
     */
    public void setX(double x)  {
        getBoundingBox().setY(x);
    }
    
    /**
     * Sets the Y coordinate of the upper-left corner of the paddle
     * @param y Y coordinate of the upper-left corner of the paddle
     */
    public void setY(double y) {
        getBoundingBox().setY(y);
    }
    
    /**
     * Resets the paddle movement
     */
    public void resetMovement() {
        setVelocityY(0);
    }
    
    /**
     * Sets the paddle moving up
     */
    public void moveUp() {
        setVelocityY(-PADDLE_SPEED);
    }

    /**
     * Sets the paddle moving down
     */
    public void moveDown() {
        setVelocityY(PADDLE_SPEED);
    }
    
    /**
     * Resets the paddle velocity
     */
    public void resetVelocity() {
        setVelocityY(0);
    }
    
    /**
     * Updates the paddle movement
     * @param delta Time passed since last update in milliseconds
     */
    public void update(int delta) {
        getBoundingBox().setX(getX() + getVelocityX() * (delta/10.0));
        getBoundingBox().setY(getY() + getVelocityY() * (delta/10.0));
    }
}
