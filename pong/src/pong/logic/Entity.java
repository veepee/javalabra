package pong.logic;

public class Entity {
    
    private BoundingBox boundingbox;
    
    public Entity(BoundingBox boundingbox) {
        this.boundingbox = boundingbox;
    }
    
    public BoundingBox getBoundingBox() {
        return boundingbox;
    }
    
    public boolean collides(Entity e) {
        return getBoundingBox().collidesWith(e.getBoundingBox());
    }

}
