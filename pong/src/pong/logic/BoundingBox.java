package pong.logic;

public class BoundingBox {

    private double x, y, w, h;

    public BoundingBox(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getWidth() {
        return w;
    }
    
    public double getHeight() {
        return h;
    }
    
    public boolean collidesWith(BoundingBox another) {
        return !(this.x > another.x + another.w || this.x + this.w < another.x
                || this.y > another.y + another.h || this.y + this.h < another.y);
    }
    
}
