package pong.logic;

/**
 * Bounding box for entity collisions
 * @author veepee
 */
public class BoundingBox {

    /**
     * X coordinate of the left-upper corner of the bounding box
     */
    private double x;
    
    /**
     * Y coordinate of the left-upper corner of the bounding box
     */
    private double y;
    
    /**
     * Width of the bounding box
     */
    private double w;
    
    /**
     * Height of the bounding box
     */
    private double h;

    /**
     * Creates a new BoundingBox with the given parameters
     * @param x X coordinate of the left-upper corner of the bounding box
     * @param y Y coordinate of the left-upper corner of the bounding box
     * @param w Width of the bounding box
     * @param h Height of the bounding box
     */
    public BoundingBox(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    /**
     * Copy constructor for BoundingBox
     * @param bb The BoundingBox instance to clone
     */
     public BoundingBox(BoundingBox bb) {
        this.x = bb.x;
        this.y = bb.y;
        this.w = bb.w;
        this.h = bb.h;
    }

    /**
     * Returns the X coordinate of the bounding box
     * @return X coordinate of the bounding box
     */
    public double getX() {
        return x;
    }
    
    /**
     * Returns the Y coordinate of the bounding box
     * @return Y coordinate of the bounding box
     */
    public double getY() {
        return y;
    }
    
    /**
     * Sets the X coordinate of the bounding box
     * @param x X coordinate of the bounding box
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Sets the Y coordinate of the bounding box
     * @param y Y coordinate of the bounding box
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Returns the width of the bounding box
     * @return Width of the bounding box
     */
    public double getWidth() {
        return w;
    }
    
    /**
     * Returns the height of the bounding box
     * @return Height of the bounding box
     */
    public double getHeight() {
        return h;
    }
    
    /**
     * Moves the bounding box with the given offsets
     * @param x Movement offset by X axis
     * @param y Movement offset by Y axis
     */
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }
    
    /**
     * Checks if the this bounding box collides with another
     * @param another Bounding box to check collisions against
     * @return True, if the bounding boxes overlap or touch, false otherwise
     */
    public boolean collidesWith(BoundingBox another) {
        return !(this.x > another.x + another.w || this.x + this.w < another.x
                || this.y > another.y + another.h || this.y + this.h < another.y);
    }
    
}
