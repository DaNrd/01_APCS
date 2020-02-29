public class Power {

    public static void main(String[] args) {
        System.out.println(power(4, 2));
        System.out.println(power(4, 1));
        System.out.println(power(4, 0));
        System.out.println(power(4, -2));
    }

    public static double power(double x, int n) {
        if(n > 0) {
            return x*power(x, n-1);
        } else if(n < 0) {
            return 1/x * power(x, n+1);
        } else {
            return 1;
        }
    }

}