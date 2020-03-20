public class exercise3 {
    public static void main(String[] args) {
        System.out.println(count("hello()()(there"));
    }

    public static int count(String s) {
        int retval = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                retval++;
            } else if (c == ')') {
                retval--;
            }
        }
        return retval;
    }
}