import java.util.*;
import java.io.*;

public class Reader {

    public static ArrayList<String> input = new ArrayList<>(); // to store input arrays

    public Reader() {
    }

    public ArrayList<String> read() {
        collectArrays(locateFile());
        return this.input;
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
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                input.add(trailspace(scanner.nextLine()).toLowerCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public String trailspace(String s) {
        if(s.charAt(s.length()-1) == ' ') {
            return s.substring(0,s.length()-1);
        } else {
            return s;
        }
    }
}