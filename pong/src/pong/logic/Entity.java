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
     * Checks if the entity collides with another entity
     * @param e Another entity against which collisions are checked for
     * @return Returns true if this entity collides with entity e, false otherwise
     */
    public boolean collides(Entity e) {
        return getBoundingBox().collidesWith(e.getBoundingBox());
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
