package pong.logic;

public class BoundingBox {

    private int x, y, w, h;

    public BoundingBox(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getWidth() {
        return w;
    }
    
    public int getHeight() {
        return h;
    }
    
    public boolean collidesWith(BoundingBox another) {
        return !(this.x > another.x + another.w || this.x + this.w < another.x
                || this.y > another.y + another.h || this.y + this.h < another.y);
    }
    
}
