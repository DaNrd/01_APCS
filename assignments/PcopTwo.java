import java.util.*;
import java.io.*;

public class PcopTwo {

    public static String fileLoc; // path of file
    public static float startTime; // time at start of execution
    public static float endTime; // time at end of execution

    public static ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    public static ArrayList<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        fileLoc = locateFile();
        startTime = System.nanoTime();
        collectArrays();
        sortArrays();
        returnOutput();
        displayTimeTaken();
    }

    public static void displayTimeTaken() {
        endTime = System.nanoTime();
        System.out.println("Time taken = " + (endTime - startTime)*Math.pow(10,(-9)));
    }

    public static void returnOutput() {
        System.out.println("Output:");
        for(int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
        System.out.println("N: " + input.get(0).get(0));
        System.out.println("K: " + input.get(0).get(1));
    }

    public static String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window and leave no trailing spaces");
        Scanner location = new Scanner(System.in);
        return location.nextLine(); // records file location
    }

    public static void collectArrays() {
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            while(scanner.hasNextLine()) {
                input.add(readLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sortArrays() {
        for(int i = 1; i < input.size(); i++) {
            output = merge(input.get(i), output);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> one, ArrayList<Integer> two) {
        ArrayList<Integer> retval = new ArrayList<>();

        while(one.size() > 1) {
            if(two.size() == 0 || one.get(1) < two.get(0)) {
                retval.add(one.get(1));
                one.remove(1);
            } else {
                retval.add(two.get(0));
                two.remove(0);
            }
        }
        while(two.size() > 0) {
            retval.add(two.get(0));
            two.remove(0);
        }
//        for(int i = 1; i < one.size(); i++) {
//            for(int j = 1; j < two.size(); j++) {
//                if(one.get(i) < two.get(j)) {
//                    retval.add(one.get(i));
//                } else {
//                    retval.add(two.get(j));
//                }
//            }
//        }
        return retval;
    }

    public static ArrayList<Integer> readLine(String line) {
        ArrayList<Integer> retval = new ArrayList<>();
        String value = "";
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ') {
                retval.add(Integer.parseInt(value));
                value = "";
            } else {
                value += line.charAt(i);
            }
        }
        retval.add(Integer.parseInt(value));
        return retval;
    }
}