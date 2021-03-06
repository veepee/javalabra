package pong.logic;

/**
 * The Ball class for representing the pong ball
 * @author veepee
 */
public class Ball extends Entity {

    /**
     * Creates a new Ball with the given coordinates
     * @param x X coordinate of the upper-left corner of the ball
     * @param y Y coordinate of the upper-left corner of the ball
     */
    public Ball(double x, double y) {
        super(new BoundingBox(x, y, 16.0, 16.0));
    }

    /**
     * Returns X coordinate of the upper-left corner of the ball
     * @return X coordinate of the upper-left corner of the ball
     */
    public double getX() {
        return getBoundingBox().getX();
    }
    
    /**
     * Sets the X coordinate of the upper-left corner of the ball
     * @param x X coordinate of the upper-left corner of the ball
     */
    public void setX(double x) {
        getBoundingBox().setX(x);
    }
    
    /**
     * Returns Y coordinate of the upper-left corner of the ball
     * @return Y coordinate of the upper-left corner of the ball
     */
    public double getY() {
        return getBoundingBox().getY();
    }
    
    /**
     * Sets the Y coordinate of the upper-left corner of the ball
     * @param y Y coordinate of the upper-left corner of the ball
     */
    public void setY(double y) {
        getBoundingBox().setY(y);
    }
    
    /**
     * Sets horizontal and vertical velocity of the ball
     * @param vx Horizontal velocity of the ball
     * @param vy Vertical velocity of the ball
     */
    public void setVelocity(double vx, double vy) {
        setVelocityX(vx);
        setVelocityY(vy);
    }
    
    /**
     * Returns the horizontal and vertical velocity of the ball
     * @return An array of 2 doubles containing the horizontal and vertical velocity of the ball respectively 
     */
    public double[] getVelocity() {
        double[] vel = {getVelocityX(), getVelocityY()};
        return vel;
    }
    
    /**
     * Updates the ball
     * @param delta Time passed since last update in milliseconds
     */
    public void update(int delta) {
        getBoundingBox().setX(getX() + getVelocityX() * (delta/10.0));
        getBoundingBox().setY(getY() + getVelocityY() * (delta/10.0));
    }
    
    /**
     * Inverts the horizontal velocity of the ball (i.e. the ball bounces)
     */
    public void invertVelocityX() {
        setVelocityX(-getVelocityX());
    }
    
    /**
     * Inverts the vertical velocity of the ball (i.e. the ball bounces)
     */
    public void invertVelocityY() {
        setVelocityY(-getVelocityY());
    }
    
    /**
     * Apply spin to the ball
     * @param d Amount of spin to be applied
     */
    public void applySpin(double d) {
        setVelocityY(getVelocityY() + d);
        if(Math.abs(getVelocityY()) < 0.5) {
            setVelocityY(getVelocityY() + (Math.random()*4) - 2);
        }
    }
}
