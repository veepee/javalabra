package pong.logic;

/**
 * The entity base class all game entities are derived from
 * @author veepee
 */
public class Entity {
    
    /**
     * The entity's bounding box
     */
    private BoundingBox boundingbox;
    
    /**
     * The entity's horizontal velocity
     */
    private double velocityX;
    
    /**
     * The entity's vertical velocity
     */
    private double velocityY;
    
    /**
     * Creates a new Entity object with the given bounding box
     * @param boundingbox Bounding box to be used for entity collisions
     */
    public Entity(BoundingBox boundingbox) {
        this.boundingbox = boundingbox;
    }
    
    /**
     * Returns the Entity's bounding box
     * @return Bounding box of the entity
     */
    public BoundingBox getBoundingBox() {
        return boundingbox;
    }
    
    /**
     * Checks if the entity will collide with another entity within the next frame
     * @param e Another entity against which collisions are checked for
     * @return Returns true if this entity collides with entity e, false otherwise
     */
    public boolean collides(Entity e) {
        BoundingBox bb1 = new BoundingBox(boundingbox);
        BoundingBox bb2 = new BoundingBox(e.boundingbox);
        
        for(int i = 0; i < 10; i++) {
            bb1.move(velocityX/10, velocityY/10);
            bb2.move(e.velocityX/10, e.velocityY/10);
            if(bb1.collidesWith(bb2)) {
                return true;
            }
        }
    
        return false;
    }

    /**
     * Sets the horizontal velocity of the entity
     * @param vx Horizontal velocity of the entity
     */
    public void setVelocityX(double vx) {
        velocityX = vx;
    }
 
    /**
     * Sets the vertical velocity of the entity
     * @param vy Vertical velocity of the entity
     */
    public void setVelocityY(double vy) {
        velocityY = vy;
    }
    
    /**
     * Returns the horizontal velocity of the entity
     * @return Horizontal velocity of the entity
     */
    public double getVelocityX() {
        return velocityX;
    }
    
    /**
     * Returns the vertical velocity of the entity
     * @return Vertical velocity of the entity
     */
    public double getVelocityY() {
        return velocityY;
    }
}
