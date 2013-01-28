package pong.logic;

public class Ball extends Entity {

    private double vx;
    private double vy;

    public Ball(double x, double y) {
        super(new BoundingBox(x, y, 4.0, 4.0));
    }

    public double getX() {
        return getBoundingBox().getX();
    }
    
    public double getY() {
        return getBoundingBox().getY();
    }
    
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    public double[] getVelocity() {
        double[] vel = {vx, vy};
        return vel;
    }
    
    public void update(int delta) {
        getBoundingBox().setX(getX() + vx * (delta/10.0));
        getBoundingBox().setY(getY() + vy * (delta/10.0));
    }
}
