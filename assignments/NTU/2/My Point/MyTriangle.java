public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1,int x2,int x3,int y1,int y2,int y3) {
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
        this.v3 = new MyPoint(x3,y3);
    }

    public MyTriangle(MyPoint v1,MyPoint v2,MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public double getPerimeter() {
        double retval = 0.0;
        retval += this.v1.distance(this.v2);
        retval += this.v2.distance(this.v3);
        retval += this.v3.distance(this.v1);
        return retval;
    }

    public String getType() {
        double dist1 = this.v1.distance(this.v2);
        double dist2 = this.v2.distance(this.v3);
        double dist3 = this.v3.distance(this.v1);

        if(dist1 == dist2) {
            if(dist2 == dist3) {
                return "Equilateral";
            } else {
                return "Isosceles";
            }
        } else if (dist2 == dist3) {
            if(dist2 == dist1) {
                return "Equilateral";
            } else {
                return "Isosceles";
            }
        } else if (dist3 == dist1) {
            if(dist2 == dist3) {
                return "Equilateral";
            } else {
                return "Isosceles";
            }
        } else {
            return "Scalene";
        }
    }

    public String toString() {
        return "MyTriangle[v1="+this.v1+",v2="+this.v2+",v3="+this.v3+"]";
    }
}