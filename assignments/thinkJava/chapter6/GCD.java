public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(36,20));
    }

    public static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else if(a > b) {
            int multiplier = a/b;
            int r = a - b*multiplier;
            return gcd(b, r);
        } else {
            return gcd(b, a);
        }
    }
}