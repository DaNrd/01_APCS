import java.util.*;
import java.io.*;

public class test {

    public static String fileLoc; // path of file
    public static float startTime; // time at start of execution
    public static float endTime; // time at end of execution

    public static ArrayList<ArrayList<Integer>> input = new ArrayList<>(); // to store input arrays
    public static ArrayList<Integer> cost = new ArrayList<>(); // output array

    public static void main(String[] args) {

        // initial cost
        cost.add(Integer.MAX_VALUE);
        // locate filepath from terminal
        fileLoc = locateFile();
        // start timer
        startTime = System.nanoTime();
        // process file into input
        collectArrays();
//        // print input
//        System.out.println(input);
        // print solution
        System.out.println(findShortest());
        // print tie taken
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

        // initiallizes the return value to really big number
        int retval = Integer.MAX_VALUE;

        int n = input.get(0).get(0); // the current node

        ArrayList<Integer> visited = new ArrayList<>(); // list of visited nodes

        visited.add(n); // adds the current node to the visited list

        retval = calculatePaths(n,0,visited);

        // return
        return retval;
    }

    public static int calculatePaths(int n, int c, ArrayList<Integer> visited) {

        if(n == 1) {
            System.out.println("NODE 1 REACHED! " + " cost=" + c);
            return c;
        }

        int retval = Integer.MAX_VALUE;

        visited.add(n); // adds the current node to the visited list

        ArrayList<Integer[]> possible = new ArrayList<>();
        ArrayList<Integer> costs = new ArrayList<>();

        for(int i = 1; i < input.size(); i++) {

            // each path is stored as a b m
            // a and b are the nodes the path connects and m is the cost
            int a = input.get(i).get(0);
            int b = input.get(i).get(1);
            int m = input.get(i).get(2);

            if(a == n && !visited.contains(b)) { // if the path contains the current node
                possible.add(new Integer[]{b,m});
            } else if(b == n && !visited.contains(a)) {
                possible.add(new Integer[]{a,m});
            }
        }

        if(possible.size() == 0) {
            return Integer.MAX_VALUE;
        }

//        for(Integer[] e: possible) {
//            System.out.print(Arrays.toString(e));
//        }
//
//        System.out.println("");

        for(Integer[] e: possible) {

            int m = c;
            if(m<e[1]) {
                m=e[1];
            }

            System.out.println(n + " -> " + e[0] + " cost of move " + e[1] + " cost of path " + m);

            costs.add(calculatePaths(e[0],m,visited));

        }

        for(int value: costs) {
            if(value<retval) {
                retval = value;
            }
        }











//
//
//        System.out.println("steps = " + steps + " cost= " + m);
//
//        ArrayList<ArrayList<Integer>> indecies = new ArrayList<>();
//
//        for(int i = 1; i < input.size(); i++) {
//
//            int a = input.get(i).get(0);
//            int b = input.get(i).get(1);
//
//            if(a == n || b == n) {
//                if(steps.contains(a) || steps.contains(b)) {
////                    System.out.println("skipped index " + i);
//                    continue;
//                }
//                ArrayList<Integer> added = new ArrayList<>();
//                added.add(i);
//                added.add(input.get(i).get(2));
//                indecies.add(added);
//            }
//        }
//
//        if(indecies.size() == 0) {
//            int q = steps.get(steps.size() - 2);
//            steps.remove(steps.size() - 2);
//            steps.add(n);
//            return calculatePaths(q, m, c, steps);
//        }
//
//        System.out.println(indecies);
//
//        ArrayList<Integer> costs = new ArrayList<>();
//
//        for(int j = 0; j < indecies.size(); j++) {
//
//            int i = indecies.get(j).get(0);
//
//            int a = input.get(i).get(0);
//            int b = input.get(i).get(1);
//
//            System.out.print(a + " -> " + b);
//            System.out.print("; m = " + m);
//            System.out.println("; i = " + i);
//
//            System.out.println(input.get(i));
//            if (m <= input.get(i).get(2)) {
//                m = input.get(i).get(2);
//            }
//
//            if (a == 1 || b == 1) {
//                steps.add(n);
//                steps.add(1);
//                System.out.println("steps = " + steps);
//                System.out.println("NODE 1 REACHED. cost=" + m);
//                cost.add(m);
//                return m;
//            } else {
//
//                if (a == n) {
//                    steps.add(n);
////                    System.out.println("thing 1.1, c=" + c);
//                    m = calculatePaths(b, m, c, steps);
//                } else {
//                    steps.add(n);
////                    System.out.println("thing 2.2, c=" + c);
//                    m = calculatePaths(a, m, c, steps);
//                }
//            }
//            costs.add(m);
////            return m;
//        }
//
//        int retval = Integer.MAX_VALUE;
//
//        for(int e: costs) {
//            if(e<retval) {
//                retval = e;
//            }
//        }
//

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