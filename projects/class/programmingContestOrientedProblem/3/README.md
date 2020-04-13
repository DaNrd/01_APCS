# Programming Contest Oriented Problem #3

## Prompt:

You are given N (1 <= N <= 2￿￿￿￿￿￿•￿10<sup>5</sup>) and M bidirectional edges (1 <= M <= 2￿￿￿•10<sup>5</sup>). Each edge has a cost, c. A path U --> V is defined as a sequence of distinct edges from node U to node V. The cost of a path is defined as the maximum cost over all edges in the path.

Your task is to find a path from node 1 to node N with minimum cost.

####Input Format:
The first line will consist of integers N and M.
The next M lines will consist of 3 integers, u, v, and c, which represents an edge connecting u and v of cost c.

Sample Input:\
`4 6`\
`1 2 1`\
`2 3 1`\
`3 4 1`\
`1 2 3`\
`3 4 2`\
`1 4 3`

####Output format: 
One integer that is the minimum cost of a path from node 1 to node N

Sample Output:\
`1`

####Test Cases:
Test cases and their solutions can be found [here](https://github.com/DaNrd/01_APCSprojects/class/programmingContestOrientedProblem/3/testCases).

## Project Description:

I read the input with a scanner, processed it into an HashMap of Node Lists called input. I then added them to a priority queue and chose the shortest path.

### Errors

No errors that I could find. Worked for the 5 given test cases.

### Code Overview

Reader.Java

    - reads the file and gives input as ArrayList<ArrayList<>>
Main.java

    -controls code flow and prints the result

Node.java
    
    - java class to represent a node path; stores end node and cost
    
Dijkstra.java
    
    - implements dijkstras algorithm using priority queue to find shortest path from start node to all other nodes

### Major Challenges

One major challenge I came across was the implementation of priority queues and hash maps as I had never used them before now.