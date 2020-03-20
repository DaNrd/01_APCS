import java.util.*;
import java.io.*;
public class PCOP3 {

    public static String fileLoc; // path of file
    public static float startTime; // time at start of execution
    public static float endTime; // time at end of execution
//    public static int n = 0;
    public static ArrayList<Integer> cost = new ArrayList<Integer>();

    public static HashMap<Integer, int[]> edges = new HashMap<Integer, int[]>();
    public static ArrayList<ArrayList<Integer>> input = new ArrayList<>(); // to store input arrays
    public static ArrayList<Integer> output = new ArrayList<>(); // output array

    public static void main(String[] args) {
        cost.add(Integer.MAX_VALUE);
        fileLoc = locateFile();
        startTime = System.nanoTime();
        collectArrays();
        System.out.println(input);
        System.out.println(findShortest());
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
//        n = input.get(0).get(0);
    }

    public static int findShortest() {

        // set retval to rediculously large number
        int retval = Integer.MAX_VALUE;
        // new integer array list to store cost of all possible paths
        ArrayList<Integer> paths = new ArrayList<>();

        //begin looking for paths
        for(int i = 1; i < input.size(); i++) {

            // new variables where the edge is stored as (a,b) with a cost of c
            int a = input.get(i).get(0);
            int b = input.get(i).get(1);

            // check if path contains current value
            if(a == input.get(0).get(0) || b == input.get(0).get(0)) {

                // print shit
                System.out.print(a + " -> " + b);
                System.out.print("; m = " + input.get(i).get(2));
                System.out.println("; i = " + i);

                // keeps track of the previously visited nodes
                ArrayList<Integer> steps = new ArrayList<>();
                // adds the start node
                steps.add(input.get(0).get(0));


                // determines where to look next
                if(a == input.get(0).get(0)) {
//                    System.out.println("thing 1, c=" + 0);
                    paths.add(calculatePaths(b, input.get(i).get(2), 0, steps));
                    paths.add(-1);
                } else {
//                    System.out.println("thing 2, c=" + 0);
                    paths.add(calculatePaths(a, input.get(i).get(2), 0, steps));
                    paths.add(-1);
                }

            }
        }

        // shortest in cost
        System.out.println("cost: " + cost);
        for(int e: cost) {
            if(e < retval) {
                retval = e;
            }
        }

        // shortest in paths
        System.out.println("paths: " + paths);
        return retval;
    }

    public static int calculatePaths(int n, int m, int c, ArrayList<Integer> steps) {

        c++;

        // to prevent stack overflow
        if(c>1000) {
            return -1;
        }

        System.out.println("steps = " + steps + " cost= " + m);

        ArrayList<ArrayList<Integer>> indecies = new ArrayList<>();

        for(int i = 1; i < input.size(); i++) {

            int a = input.get(i).get(0);
            int b = input.get(i).get(1);

            if(a == n || b == n) {
                if(steps.contains(a) || steps.contains(b)) {
//                    System.out.println("skipped index " + i);
                    continue;
                }
                ArrayList<Integer> added = new ArrayList<>();
                added.add(i);
                added.add(input.get(i).get(2));
                indecies.add(added);
            }
        }

        if(indecies.size() == 0) {
            int q = steps.get(steps.size() - 2);
            steps.remove(steps.size() - 2);
            steps.add(n);
            return calculatePaths(q, m, c, steps);
        }

        System.out.println(indecies);

        ArrayList<Integer> costs = new ArrayList<>();

        for(int j = 0; j < indecies.size(); j++) {

            int i = indecies.get(j).get(0);

            int a = input.get(i).get(0);
            int b = input.get(i).get(1);

            System.out.print(a + " -> " + b);
            System.out.print("; m = " + m);
            System.out.println("; i = " + i);

            System.out.println(input.get(i));
            if (m <= input.get(i).get(2)) {
                m = input.get(i).get(2);
            }

            if (a == 1 || b == 1) {
                steps.add(n);
                steps.add(1);
                System.out.println("steps = " + steps);
                System.out.println("NODE 1 REACHED. cost=" + m);
                cost.add(m);
                return m;
            } else {

                if (a == n) {
                    steps.add(n);
//                    System.out.println("thing 1.1, c=" + c);
                    m = calculatePaths(b, m, c, steps);
                } else {
                    steps.add(n);
//                    System.out.println("thing 2.2, c=" + c);
                    m = calculatePaths(a, m, c, steps);
                }
            }
            costs.add(m);
//            return m;
        }

        int retval = Integer.MAX_VALUE;

        for(int e: costs) {
            if(e<retval) {
                retval = e;
            }
        }


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
        if(value != "") {
            retval.add(Integer.parseInt(value));
        }
        return retval;
    }

    public static void displayTimeTaken() { // displays timestamp
        endTime = System.nanoTime();
        System.out.println("Time taken = " + (endTime - startTime)*Math.pow(10,(-9)));
    }

}