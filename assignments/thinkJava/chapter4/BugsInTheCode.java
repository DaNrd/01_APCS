import java.lang.Math;
        
public class BugsInTheCode {

    public static void main(String[] args) {
        int maxLength = 99;
        sing(99, maxLength);
    }

    public static void sing(int number, int maxLength) {
        if (number == 0) {
            System.out.println("No more little bugs in the code, no more little bugs! The tired developer patched them around or told his boss they were features!");
        } else {
            int newNum = 0;
            if(maxLength > 2) {
                newNum = (int)(Math.random()*1001);
            }
            System.out.println(number + " little bugs in the code, " + number + " little bugs! Take one down and patch it around, " + newNum + " little bugs in the code.");
            System.out.println("");
            maxLength--;
            sing(newNum, maxLength);
        }
    }
}