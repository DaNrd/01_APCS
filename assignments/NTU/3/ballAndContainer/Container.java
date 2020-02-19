public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = x;
        this.x2 = x+width;
        this.y2 = y-height;
    }

    public int getX() {
        return (int)this.x1;
    }

    public int getY() {
        return (int)this.y1;
    }

    public int getWidth() {
        return (int)this.y1-this.y2;
    }

    public int getHeight() {
        return (int)this.x2-this.x1;
    }

    public boolean collides(Ball ball) {
        float ballx = ball.getX();
        float bally = ball.getY();
        float ballr = ball.getRadius();
        if((ballx-ballr)<this.x1 || (ballx+ballr)>this.x2) {
            ball.reflectHorizontal();
            return true;
        } else if((bally-ballr)<this.y2 || (bally+ballr)>this.y1) {
            ball.reflectVertical();
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Container[("+this.x1+","+this.y1+"),("+this.x2+","+this.y2+")]";
    }
}