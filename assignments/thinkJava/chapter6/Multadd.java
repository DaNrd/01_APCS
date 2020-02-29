public class Multadd {

    public static void main(String[] args) {
        System.out.println(multadd(1.0, 2.0, 3.0));
        System.out.println(multadd(Math.cos(Math.PI/4),2,Math.sin(Math.PI)));
        System.out.println(multadd(Math.log(20), Math.log(10), 1));
        System.out.println(yikes(4));
    }

    public static double multadd(double a, double b, double c) {
        return a*b+c;
    }

    public static double yikes(double a) {
        return multadd(a, Math.exp(-a), Math.sqrt(1-Math.exp(-a)));
    }

}