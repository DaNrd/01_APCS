public class TestMyCircle {
    public static void main(String args[]) {
        MyCircle c1 = new MyCircle();
        MyCircle c2 = new MyCircle(3,4,5);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.distance(c2));
        System.out.println(c2.getArea());
    }
}