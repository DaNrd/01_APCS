public class IsTriangle {

    public static void main(String[] args) {
        System.out.println(isTriangle(3, 4, 5));
        System.out.println(isTriangle(28, 4, 5));
    }

    public static boolean isTriangle(int a, int b, int c) {
        if(a+b > c) {
            if(a+c > b) {
                if(b+c > a) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}