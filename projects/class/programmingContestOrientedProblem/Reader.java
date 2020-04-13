import java.util.*;
import java.io.*;

public class Reader {

    public static ArrayList<ArrayList<Integer>> collected = new ArrayList<>(); // to store input arrays

    public Reader() {
    }

    public ArrayList<ArrayList<Integer>> read() {
        collectArrays(locateFile());
        return this.collected;
    }

    public String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window below:");
        Scanner location = new Scanner(System.in);
        String s = location.nextLine();
        String retval = trailspace(s);
        return retval; // records file location
    }

    public void collectArrays(String fileLoc) { // parses input to find the k sorted arrays
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            while(scanner.hasNextLine()) {
                collected.add(readLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> readLine(String line) {
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
        if(value != "") {
            retval.add(Integer.parseInt(value));
        }
        return retval;
    }

    public String trailspace(String s) {
        if(s.charAt(s.length()-1) == ' ') {
            return s.substring(0,s.length()-1);
        } else {
            return s;
        }
    }
}