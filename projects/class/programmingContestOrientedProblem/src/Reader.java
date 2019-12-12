import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class Reader {
    public String fileLoc; // path of file
    public int[] integers;
    public DecimalFormat df = new DecimalFormat("0.000");

    public void processInput() {
        fileLoc = locateFile();
        System.out.println("Solutions:");
        readFile();
    }

    public String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window and leave no trailing spaces");
        Scanner location = new Scanner(System.in);
        return location.nextLine(); // records file location
    }

    public void readFile() { // records the file in an ArrayList called input
        countLines();
    }

    public void countLines() {
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            integers = new int[Integer.parseInt(scanner.nextLine()) + 1];
            integers[0] = 0;
            for(int i = 1; i<integers.length; i++) {
                integers[i] = integers[i-1] + Integer.parseInt(scanner.nextLine());
            }
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                computeQuery(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void computeQuery(String query) {
        String[] currentQuerry = query.split(" "); // splits querry into 2 strings (split at space)
        int a = Integer.parseInt(currentQuerry[0]); // first number of query
        int b = Integer.parseInt(currentQuerry[1]); // second number of querry
        average(a, b); // calculates the average between the two terms
    }

    public void average(int a, int b) {
        double sol = 0; // starts solution value at 0
        sol = (double) (integers[b] - integers[a - 1])/(b - a + 1);
        System.out.println(df.format(sol)); // prints solution
    }
}