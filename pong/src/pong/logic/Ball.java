package pong.logic;

public class Ball extends Entity {

    private int vx;
    private int vy;
    
    public Ball(int x, int y) {
        super(new BoundingBox(x, y, 4, 4));
    }

    public int getX() {
        return getBoundingBox().getX();
    }
    
    public int getY() {
        return getBoundingBox().getY();
    }
    
    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    public int[] getVelocity() {
        int[] vel = {vx, vy};
        return vel;
    }
    
    public void update() {
        getBoundingBox().setX(getX() + vx);
        getBoundingBox().setY(getY() + vy);
    }
}
