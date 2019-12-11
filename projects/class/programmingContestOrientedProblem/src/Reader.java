import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class Reader {
    public String fileLoc; // path of file
    public int lineNum; // number of lines (starts at -1 for reasons)
    public String[] input;
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

    public void computeQueries() {
        int qStart = Integer.parseInt(input[0])+1; // to skip first n+1 ints
        for(int i = 0; i < Integer.parseInt(input[qStart]); i++){ // to process all queries
            String[] currentQuerry = input[qStart + i + 1].split(" "); // splits querry into 2 strings (split at space)
            int a = Integer.parseInt(currentQuerry[0]); // first number of query
            int b = Integer.parseInt(currentQuerry[1]); // second number of querry
            average(i, a, b); // calculates the average between the two terms
        }
    }

    public void average(int i, int a, int b) {
        double sol = 0; // starts solution value at 0
        for(int j = 0; j < (b - a + 1); j++) {
            sol += Integer.parseInt(input[a + j]); // adds the numbers between query values
        }
        System.out.println(df.format(sol/(b - a + 1))); // prints solution
    }
}