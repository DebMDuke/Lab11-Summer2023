# Graph Implementation #

In this lab you will add additional methods to the UnweightedGraph class from lecture. This graph is directed and unweighted. In the IDE of your choice clone the repository to download the following starter files: Edge.java, Graph.java, and UnweightedGraph.java.

In order to create an UnweightedGraph object, write a method that reads in Integer graph data from a file and sets this UnweightedGraph instance according to the data in the file. The method signature must be

```public static UnweightedGraph<Integer> graphFromFile(String fileName) throws FileNotFoundException```

Your method will accept a file name including the file extension, for example, txt, as a String parameter to create and return an UnweightedGraph object.
If the file is unable to be opened, the method should throw a FileNotFoundException
The first line in the file contains a number that indicates the number of vertices (n).
The vertices are labeled as 0, 1, …, n−1.
Each subsequent line, with the format originVertex destVertex1 destVertex 2 …, describes edges (originVertex, destVertex 1), (originVertex, destVertex 2), and so on.

Here are examples of two files for their corresponding graphs:
![Image of sample file contents and corresponding graphs]
(Sample%20Input%20Files.png)

To the UnweightedGraph class, implement the following methods:

  ```public boolean isComplete()``` // returns true if this graph is complete
  * use the number of vertices and the calculation to determine
  
 ```public boolean areAdjacent(V v1, V v2)``` // returns true if v1 is adjacent to v2
 
 ```public boolean isConnected()```           // returns true if the graph is connected
  * Call the printEdges() to display all edges, and then call dfs() to obtain an instance tree of UnweightedGraph.SearchTree. If tree.getNumberOfVerticesFound() is the same as the number of vertices in the graph, the graph is connected.
  
 ```public List<Integer> getSortestPath(int u, int v)```
  * The method returns a List<Integer> that contains all the vertices in the shortest path from u to v in order.
  * Using the breadth-first search approach, you can obtain the shortest path from u to v.
  * If there isn’t a path from u to v, the method returns null.
  
 ```public boolean hasCycle()```
  * The method returns true if there is a cycle in this instance of UnweightedGraph.
