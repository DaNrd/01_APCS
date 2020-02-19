public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle() {
        this.center = new MyPoint(0,0);
        this.radius = 1;
    }

    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x,y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getCenterX() {
        return this.center.getX();
    }

    public int getCenterY() {
        return this.center.getY();
    }

    public void setCenterX(int x) {
        this.center.setX(x);
    }

    public void setCenterY(int y) {
        this.center.setY(y);
    }

    public void setCenterXY(int x, int y) {
        this.center.setXY(x,y);
    }

    public int[] getCenterXY() {
        return this.center.getXY();
    }

    public double getArea() {
        return (double)(this.radius*this.radius*Math.PI);
    }

    public double getCircumference() {
        return (double)(2*this.radius*Math.PI);
    }

    public double distance(MyCircle e) {
        return this.center.distance(e.getCenter());
    }

    public String toString() {
        return "MyCircle[radius="+this.radius+",center="+this.center+"]";
    }
}