public class Recurse {
    public static void main(String[] args) {

    }

    public static char first(String s) {
        return s.charAt(0);
    }

    public static String rest(String s) {
        return s.substring(1);
    }

    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    public static int length(String s) {
        return s.length();
    }

    public static void printString(String s) {
        if(length(s) == 1) {
            System.out.println(first(s));
        } else if(length(s) <= 0) {
        } else if (length(s) > 1) {
            System.out.println(first(s));
            printString(rest(s));
        }
    }

    public static void printBackward(String s) {
        printString(reverseString(s));
    }

    public static String reverseString(String s) {
        String retval = "";
        for(int i = length(s) - 1; i >=0; i--) {
            retval += s.charAt(i);
        }
        return retval;
    }

    public static boolean isPalindrome(String s) {
        if(s.equals(reverseString(s))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAbecedarian(String s) {
        int current = 0;
        for(int i = 0; i < length(s); i++) {
            if(current<s.charAt(i)) {
                current = s.charAt(i);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isDoubloon(String s) {
        for(int e: abcInt(s)) {
            if(e != 2 && e != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] abcInt(String s) {
        String str = s.toLowerCase();
        int[] abc = new int[26];

        for(int i = 0; i < length(str); i++) {
            int j = str.charAt(i);
            if(j>=97 && j<=122) {
                j-=97;
                abc[j]++;
            }
        }

        return abc;
    }

    public static boolean isAnagram(String s, String a) {
        int[] sint = abcInt(s);
        int[] aint = abcInt(a);

        for(int i = 0; i < sint.length; i++) {
            if(sint[i] != aint[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean canSpell(String s, String a) {
        int[] sint = abcInt(s);
        int[] aint = abcInt(a);

        for(int i=0; i<aint.length; i++) {
            if(aint[i] > sint[i]){
                return false;
            }
        }
        return true;
    }
}