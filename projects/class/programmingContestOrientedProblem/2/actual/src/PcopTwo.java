import java.util.*;
import java.io.*;

public class PcopTwo implements Runnable {

    public static String fileLoc; // path of file
    public static float startTime; // time at start of execution
    public static float endTime; // time at end of execution
    public static int n = 0; // number of elements of output array; initialized to 0
    public static int k = 0; // number of sorted input arrays; initialized to 0

    public static ArrayList<ArrayList<Integer>> input = new ArrayList<>(); // to store input arrays
    public static ArrayList<Integer> output = new ArrayList<>(); // output array

    public static void main(String[] args) {
        fileLoc = locateFile();
        startTime = System.nanoTime();
        collectArrays();
        killUnnecessary();
        output = sortArrays(input);
        returnOutput();
        displayTimeTaken();
    }

    public static String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window and leave no trailing spaces");
        Scanner location = new Scanner(System.in);
        return location.nextLine(); // records file location
    }

    public static void collectArrays() { // parses input to find the k sorted arrays
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

    public static void killUnnecessary() { // removes values that arent needed
        n = input.get(0).get(0);
        k = input.get(0).get(1);
        input.remove(0);
        for(ArrayList<Integer> e: input) {
            e.remove(0);
        }
    }

    public static ArrayList<Integer> sortArrays(ArrayList<ArrayList<Integer>> list) { // main calculations occur here
        ArrayList<ArrayList<Integer>> retval = new ArrayList<>();
        if(list.size() == 1){
            return list.get(0);
        } else {
            for(int i = 0; i < list.size()/2; i++) {
                retval.add(merge(list.get(2*i), list.get(2*i+1)));
            }
            if(list.size()%2 == 1) {
                retval.add(list.get(list.size()-1));
            }
            return sortArrays(retval);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> one, ArrayList<Integer> two) {
        //Merges two sorted arrays in linear time
        ArrayList<Integer> retval = new ArrayList<>();
        int counterOne = 0;
        int counterTwo = 0;
        //While arraylists have remaining integers
        while (counterOne < one.size() && counterTwo < two.size()) {
            //Adds smaller value to arraylist then adds to counter for that list
            if (one.get(counterOne) < two.get(counterTwo)) {
                retval.add(one.get(counterOne));
                counterOne++;
            } else {
                retval.add(two.get(counterTwo));
                counterTwo++;
            }
        }
        //Once one list is exhausted, adds remaining elements from other list
        if (counterOne == one.size()){
            for(int i = counterTwo; i < two.size(); i++){
                retval.add(two.get(i));
            }
        } else if (counterTwo == two.size()){
            for(int i = counterOne; i < one.size(); i++){
                retval.add(one.get(i));
            }
        }

        return retval;
    }

    public static void returnOutput() { // returns the output with human readable formatting
        System.out.println("Output:");
        for(int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
        System.out.println("N: " + n);
        System.out.println("K: " + k);
        System.out.println("output length: " + output.size());
    }

    public static void displayTimeTaken() { // displays timestamp
        endTime = System.nanoTime();
        System.out.println("Time taken = " + (endTime - startTime)*Math.pow(10,(-9)));
    }

    @Override
    public void run(){}
}