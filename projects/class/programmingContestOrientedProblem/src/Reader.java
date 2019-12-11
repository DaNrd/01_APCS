import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class Reader {
    public String fileLoc; // path of file
    public int[] integers;
    public String[] queries;
    public DecimalFormat df = new DecimalFormat("0.000");

    public void processInput() {
        fileLoc = locateFile();
        readFile();
        System.out.println("Solutions:");
        computeQueries();
    }

    public String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window and leave no trailing spaces");
        Scanner location = new Scanner(System.in);
        return location.nextLine(); // records file location
    }

    public void readFile() { // records the file in an ArrayList called input
        countLines();
//        setInput();
    }

    public void countLines() {
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            integers = new int[Integer.parseInt(scanner.nextLine())];
            for(int i = 0; i<integers.length; i++) {
                integers[i] = Integer.parseInt(scanner.nextLine());
            }
            queries = new String[Integer.parseInt(scanner.nextLine())];
            for(int i = 0; i<queries.length; i++) {
                queries[i] = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void computeQueries() {
        for(int i = 0; i < queries.length; i++){ // to process all queries
            String[] currentQuerry = queries[i].split(" "); // splits querry into 2 strings (split at space)
            int a = Integer.parseInt(currentQuerry[0]); // first number of query
            int b = Integer.parseInt(currentQuerry[1]); // second number of querry
            average(i, a, b); // calculates the average between the two terms
        }
    }

    public void average(int i, int a, int b) {
        double sol = 0; // starts solution value at 0
        for(int j = 0; j < (b - a + 1); j++) {
            sol += integers[a + j - 1];
        }
        System.out.println(df.format(sol/(b - a + 1))); // prints solution
    }
}