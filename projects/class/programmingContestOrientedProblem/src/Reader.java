import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class Reader {
    public String fileLoc; // path of file
    public int lineNum; // number of lines (starts at -1 for reasons)
    public int n; // number of integers
    public int q; // number of queries
    public String[] input;
    public int[] integers;
    public String[] queries;
    public double[] solutions;
    public DecimalFormat df = new DecimalFormat("0.000");

    public void processInput() {
        fileLoc = locateFile();
        readFile();
        setIntegers();
        setQueries();
        computeQueries();
        System.out.println("Solutions:");
        for(int i = 0; i < q; i++) {
            System.out.println(df.format(solutions[i])); // prints value rounded to fit 0.000 format (df)
        }
    }

    public String locateFile() {
        BufferedReader reader;
        System.out.println("Please drag your file to the terminal window and leave no trailing spaces");
        Scanner location = new Scanner(System.in);
        return location.nextLine(); // records file location
    }

    public void readFile() { // records the file in an ArrayList called input
        countLines();
        setInput();
    }

    public void countLines() {
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            while (scanner.hasNextLine()) {
                lineNum++;
                scanner.nextLine();
            }
            input = new String[lineNum];
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setInput() {
        try {
            Scanner scanner = new Scanner(new File(fileLoc));
            lineNum = 0;
            while (scanner.hasNextLine()) {
                input[lineNum] = scanner.nextLine();
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIntegers() {
        n = Integer.parseInt(input[0]); // sets n to first number
        integers = new int[n];
        for(int i = 0; i < n; i++) {
            integers[i] = Integer.parseInt(input[i + 1]); // sets values of ArrayList "integers" by adding next n values after n
        }
    }

    public void setQueries() {
        q = Integer.parseInt(input[n+1]); // sets q to first number after first n + 1 lines
        queries = new String[q];
        for(int i = 0; i < q; i++) {
            queries[i] = input[n + 2 + i];// sets string values of ArrayList "querries" by adding next q strings after q
        }
    }

    public void computeQueries() {
        solutions = new double[q];
        for(int i = 0; i < q; i++){ // to process all queries
            String[] currentQuerry = queries[i].split(" "); // splits querry into 2 strings (split at space)
            int a = Integer.parseInt(currentQuerry[0]); // first number of query
            int b = Integer.parseInt(currentQuerry[1]); // second number of querry
            average(i, a, b); // calculates the average between the two terms
        }
    }

    public void average(int i, int a, int b) {
        double sol = 0; // starts solution value at 0
        for(int j = 0; j < (b - a + 1); j++) {
            sol += integers[a + j - 1]; // adds the numbers between query values
        }
        solutions[i] = sol/(b - a + 1);; // adds to solution ArrayList
    }
}