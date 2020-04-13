import java.util.*;

public class Main {
    public static void main(String arg[])
    {
        Reader reader = new Reader();
        ArrayList<ArrayList<Integer>> input = reader.read();

        int N = input.get(0).get(1); // number of nodes in the graph (estimated to be number of lines)
        int source = 1; // start
        int target = input.get(0).get(0); // end

        // adjmap.get(a).get(b) will get a list of nodes adjacent to the node of value a
        HashMap<Integer, List<Node>> adjmap = new HashMap<>();

        // inputs for the graph
        for(int i = 1; i < input.size(); i++) {
            int a = input.get(i).get(0);
            int b = input.get(i).get(1);
            int c = input.get(i).get(2);

            // initialize adjmap if not done so already
            if(adjmap.get(a) == null) {
                adjmap.put(a, new ArrayList<Node>());
            }
            if(adjmap.get(b) == null) {
                adjmap.put(b, new ArrayList<Node>());
            }
            // adds the a->b path of cost c to both nodes a and b
            adjmap.get(a).add(new Node(b,c));
            adjmap.get(b).add(new Node(a,c)); // deals with going the other way
        }

        // calculates the shortest path from node 1 to any other node
        Dijkstra dij = new Dijkstra(N);
        dij.calculateDijkstra(adjmap, source);

        // prints the shortest path from node 1 to target node
        System.out.println(" ");
        System.out.print("The shortest path from node ");
        for (int i = 0; i < dij.cost.length; i++) {
            if(i == target) {
                System.out.print(source + " to node " + i + " is: " + dij.cost[i]);
            }
        }
        System.out.println(" ");
    }
}