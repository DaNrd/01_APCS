public class MyRectangle {
    private MyPoint v1;
    private MyPoint v2;

    public MyRectangle(int x1,int x2,int y1,int y2) {
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
    }

    public MyRectangle(MyPoint v1,MyPoint v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public double getDiagonal() {
        return this.v1.distance(this.v2);
    }

    public String getType() {
        double width = Math.abs(this.v1.getX() - this.v2.getX());
        double height = Math.abs(this.v1.getY() - this.v2.getY());

        if(width == height) {
            return "Square";
        } else {
            return "Rectangle";
        }
    }

    public String toString() {
        return "MyRectangle[v1="+this.v1+",v2="+this.v2+"]";
    }
}