import java.util.ArrayList;

public class PcopTwo {

    public String fileLoc; // path of file
    public float startTime; // time at start of execution
    public float endTime; // time at end of execution

    public ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    public ArrayList<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        fileLoc = locateFile();
        collectArrays();
        sortArrays();
        returnOutput();
        displayTimeTaken();
    }

    public static void displayTimeTaken() {
        System.out.println("Time taken = " + startTime - endTime);
    }

    public static void returnOutput() {
        System.out.println("Output:");
        for(int i = 0; i < n; i++) {
            System.out.println(output.get(i));
        }
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
        for(int i = 1; i < (input.size() - 1); i++) {
            output = merge(input.get(i), output);
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> one, ArrayList<Integer> two) {
        ArrayList<Integer> retval = new ArrayList<>();
        for(int i = 1; i < one.size(); i++) {
            for(int j = 1; j < two.size(); j++) {
                if(one.get(i) < two.get(j)) {
                    retval.add(one.get(i));
                } else {
                    retval.add(two.get(j));
                }
            }
        }
        return retval;
    }

    public static ArrayList<Integer> readLine(String line) {
        ArrayList<Integer> retval = new ArrayList<>();
        String value;
        for(int i = 0; i < firstLine.length; i++) {
            if(line.charAt(i).equals(' ')) {
                retval.add(Integer.parseInt(value));
                value = "";
            } else {
                value += firstLine.charAt(i);
            }
        }
        return retval;
    }
}