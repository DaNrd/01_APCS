public class Recurse {

    public static void main(String[] args) {
        System.out.println("first string of \"hello\" is " + first("hello"));
        System.out.println("the rest is " + rest("hello"));
        System.out.println("the length is " + length("hello"));
        backwards("hello");
    }

    public static char first(String s) {
        return s.charAt(0);
    }

    public static String rest(String s) {
        return s.substring(1,s.length());
    }

    public static int length(String s) {
        return s.length();
    }

    public static void printString(String s) {
        System.out.println(s);
    }

    public static String reverseString(String s) {
        String retval = "";
        for(int i = s.length(); i > 0; i--) {
            retval += s.charAt(i-1);
        }
        return retval;
    }

    public static void backwards(String s) {
        System.out.println(reverseString(s));
    }

}