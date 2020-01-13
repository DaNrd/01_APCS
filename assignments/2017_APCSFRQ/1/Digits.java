import java.util.*;
public class Digits {
    // The list of digits from the number used to construct this object
    // The digits appear in the list in the same order in which they apprea in the original number.
    private ArrayList<Integer> digitList;

    public static void main(String[] args) {
        Digits dl = new Digits(65310);
        System.out.println("Is strictly Increasing: " + dl.isStrictlyIncreasing());
    }

    // Constructs a Digits objec that represents num (precondition num >= 0)
    public Digits(int num) {
        String temp = Integer.toString(num);
        this.digitList = new ArrayList<Integer>();
        for(int i = 0; i < temp.length(); i++){
            this.digitList.add(Integer.parseInt(Character.toString(temp.charAt(i))));
        }
    }

    // returns true if the digits in this Digits object are in strictly increasing order
    public boolean isStrictlyIncreasing() {
        for(int i = 1; i<this.digitList.size(); i++) {
            if(digitList.get(i) <= digitList.get(i-1)) {
                return false;
            } else {
            }
        }
        return true;
    }
}