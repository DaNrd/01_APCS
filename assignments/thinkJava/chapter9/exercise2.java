import java.util.*;

public class exercise2 {
    public static void main(String[] args) {
        String test = "write the test string here";
        System.out.println(Arrays.toString(letterHist(test)));
    }

    public static int[] letterHist(String a) {
        int[] retval = new int[26];
        a = a.toLowerCase();

        for(int i = 0; i < a.length(); i++) {
            int j = a.charAt(i);
            if(j>=97 && j<=122) {
                j-=97;
                retval[j]++;
            }
        }

        return retval;
    }
}