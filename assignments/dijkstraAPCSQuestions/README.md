#Question 1

The Node class contains 2 fields; a boolean representing whether or not the node has been visited, and a map of adjacent nodes with costs.

```java
import java.util;import java.util.*;

java class Node {
    public int cost;
    public boolean visited;
    public HashMap<Node, int> adjacent;

    public Node(boolean visited, HashMap<Node, int> adjacent) {
        this.cost = /* to be completed in part a */;
        this.visited = visited;
        this.adjacent = adjacent;
    }

    public void setCost(int cost) {
        /* implementation not shown */
    }   

    public void setVisited(boolean visited) {
        /* implementation not shown */
    }
    
    public void setAdjacent(HashMap<Node,int> adjacent) {
        /* implementation not shown */
    }   

    public int getCost() {
        /* implementation not shown */
    }   
    
    public boolean getVisited() {
        /* implementation not shown */
    }
    
    public void addAdjacent(/* to be implemented in part b */) {
        /* to be implemented in part b */
    }

    public void removeAdjacent(/* to be implemented in part b */) {
        /* to be implemented in part b */
    }

    public void clearAdjacent() {
        /* to be implemented in part b */
    }

    public HashMap<Node, int> listUnvisitedConnections() {
        /* to be implemented in part c */
    }
}
```

####Part a)
In Dijkstra's algorithm, all nodes are initially assumed to have a cost of infinite value. Choose a sensible initial value for the cost in accordance to dijkstra's algorithm.
```java
    this.cost =                        ;
```
####Part b)
The Node class contains methods allowing other classes to interact with and modify its HashMap field. Complete the designated methods in order to allow these interactions.
```java
    public void addAdjacent(                        ) {






    }

    public void removeAdjacent(                        ) {






    }

    public void clearAdjacent(                        ) {






    }
```
####Part c)
The Node class contains a method which returns a map of unvisited nodes and their costs. Please write the implementation of this class.
```java
    public HashMap<Node, int> listUnvisitedConnections(                        ) {












    }
```
#Question 2

The Dijk class contains many methods and a main method that collectively preform Dijkstra's algorithm on a given map of nodes. The class can be seen below:

```java
import java.util.*;

public class Dijk {
    public ArrayList<Node> graph;
    public HashMap<Node, int> pathCosts;
    public Node start;

    public Dijk( /* to be implemented in part a */ ) {
        /* to be implemented in part a */
    }
   
    public HashMap<Node, int> dijkstra() {
        /* implementation not shown */
        /* returns the solved pathCosts map */
    }

    public Node findShortestPath(HashMap<Node, int> args) {
        /* implementation not shown */
        /* returns the node with the cheapest cost*/
    }

    public Node checkUnvisited() {
        /* implementation not shown */
        /* returns the first node in */
    }
    
    public void updateCost(Node n, int cost) {
        /* to be implemented in part b */
    }

}
```

####Part a)
Complete the constructor for the Dijk class to accept the following call:
```java
ArrayList<Node> param1; // the graph
Node param2; // the origin node
Dijk dijkstra = new Dijk(param1, param2);
HashMap<Node, int> completedCosts = Dijk.dijkstra();
```
Do so below:
```java
    public Dijk(                        ) {












    }
```

####Part b)
Complete the updateCost method:
```java
    public void updateCost(Node n, int cost) {












    }
```

#Example Answers
###Question 1
####a)
```java
    this.cost = Integer.MAX_VALUE;
```
####b)
```java
    public void addAdjacent(int i, Node n) {
        this.adjacent.put(i,n);
    }

    public void removeAdjacent(int i, Node n) {
        this.adjacent.remove(i,n);
    }
    
    public void clearAdjacent() {
        this.adjacent.clear();
    }
```
####c)
```java
    public HashMap<Node, int> listUnvisitedConnections() {
        HashMap<int, Node> unvisited = new HashMap<Node, int>();
        for(Node e: this.adjacent) {
            if(!e.getVisited()) {
                unvisited.put(adjacent.get(e), e);
            }
        }
        return unvisited;
    }
```
###Question 2
####a)
```java
    public Dijk(ArrayList<Node> graph, Node start) {
        this.graph = graph;
        this.start = start;
        this.pathCosts = new HashMap<Node, int>();
    }
```
####b)
```java
public void updateCost(Node n, int cost) {
    if(n.getCost() < cost) {
        if(pathCosts.containsKey(n)) {
            pathCosts.remove(n, pathCosts.get(n));
        }
        pathCosts.put(n, cost);
    }
}
```