import java.util.*;

public class Dijkstra {
    public int cost[]; // total cost for the path taken
    private Set<Integer> processed; // set of integers that have a defined cost
    private PriorityQueue<Node> pq;
    private int N; // Number of nodes
    List<List<Node> > adj; // adjacent nodes
    HashMap<Integer, List<Node>> adjmap;

    public Dijkstra(int N)
    {
        this.N = N;
        cost = new int[2*N];
        processed = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(N, new Node());
    }

    public void calculateDijkstra(HashMap<Integer,List<Node> > adjmap, int src)
    {
        this.adjmap = adjmap;

        //initiallize cost to MAX_VALUE instead of Dijkstras use of infinity
        for(int i = 0; i < 2*N; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        cost[src] = 0;
        while(true) {
            if(pq.size() == 0) {
                break;
            }
            // remove the minimum total cost node from the priority queue
            Node u = pq.remove();

            // adding the node whose total cost is finalized
            processed.add(u.node);

            findNeighbours(u);
        }
    }

    // processes all the neighbours of the passed node
    private void findNeighbours(Node u)
    {
        int edgeCost = -1;
        int newCost = -1;

        // All the neighbors of v
        for(int i = 0; i < adjmap.get(u.node).size(); i++) {
            Node v = adjmap.get(u.node).get(i);

            // if current node hasn't already been processed
            if(!processed.contains(v.node)) {
                edgeCost = v.cost;
                // if new cost is higher than old cost, updates cost
                if(u.cost < edgeCost){
                    newCost = edgeCost;
                } else {
                    newCost = u.cost;
                }

                // if new total cost is cheaper in cost
                if(newCost < cost[v.node]) {
                    cost[v.node] = newCost;
                }

                // add the current node to the queue
                pq.add(new Node(v.node, cost[v.node]));
            }
        }
    }
}