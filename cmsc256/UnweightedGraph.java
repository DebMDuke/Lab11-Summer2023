package cmsc256;

import java.io.FileNotFoundException;
import java.util.*;

public class UnweightedGraph<V> implements Graph<V> {
	private List<V> vertices = new ArrayList<>(); // Store vertices
	private List<List<Edge>> neighbors = new ArrayList<>(); // Adjacency lists

	/** Construct an empty graph */
	public UnweightedGraph() {
	}

	/** Construct a graph from vertices and edges stored in arrays */
	public UnweightedGraph(V[] vertices, int[][] edges) {
		for (int i = 0; i < vertices.length; i++)
			addVertex(vertices[i]);

		createAdjacencyLists(edges, vertices.length);
	}

	/** Construct a graph from vertices and edges stored in List */
	public UnweightedGraph(List<V> vertices, List<Edge> edges) {
		for (int i = 0; i < vertices.size(); i++)
			addVertex(vertices.get(i));

		createAdjacencyLists(edges, vertices.size());
	}

	/** Construct a graph for integer vertices 0, 1, 2 and edge list */
	public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
		for (int i = 0; i < numberOfVertices; i++) 
			addVertex((V)(Integer.valueOf(i))); // vertices is {0, 1, ...}

		createAdjacencyLists(edges, numberOfVertices);
	}

	/** Construct a graph from integer vertices 0, 1, and edge array */
	public UnweightedGraph(int[][] edges, int numberOfVertices) {
		for (int i = 0; i < numberOfVertices; i++) 
			addVertex((V)(Integer.valueOf(i))); // vertices is {0, 1, ...}

		createAdjacencyLists(edges, numberOfVertices);
	}

	/** Create adjacency lists for each vertex */
	private void createAdjacencyLists(
			int[][] edges, int numberOfVertices) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(edges[i][0], edges[i][1]);
		}
	}

	/** Create adjacency lists for each vertex */
	private void createAdjacencyLists(
			List<Edge> edges, int numberOfVertices) {
		for (Edge edge: edges) {
			addEdge(edge.getOriginVertex(), edge.getDestinationVertex());
		}
	}

	@Override /** Return the number of vertices in the graph */
	public int getSize() {
		return vertices.size();
	}

	@Override /** Return the vertices in the graph */
	public List<V> getVertices() {
		return vertices;
	}

	@Override /** Return the object for the specified vertex */
	public V getVertex(int index) {
		return vertices.get(index);
	}

	@Override /** Return the index for the specified vertex object */
	public int getIndex(V v) {
		return vertices.indexOf(v);
	}

	@Override /** Return the neighbors of the specified vertex */
	public List<Integer> getNeighbors(int index) {
		List<Integer> result = new ArrayList<>();
		for (Edge e: neighbors.get(index))
			result.add(e.getDestinationVertex());

		return result;
	}

	@Override /** Return the degree for a specified vertex */
	public int getDegree(int v) {
		return neighbors.get(v).size();
	}

	@Override /** Print the edges */
	public void printEdges() {
		for (int u = 0; u < neighbors.size(); u++) {
			System.out.print(getVertex(u) + " (" + u + "): ");
			for (Edge e: neighbors.get(u)) {
				System.out.print("(" + getVertex(e.getOriginVertex()) + ", " +
						getVertex(e.getDestinationVertex()) + ") ");
			}
			System.out.println();
		}
	}

	@Override /** Clear the graph */
	public void clear() {
		vertices.clear();
		neighbors.clear();
	}

	@Override /** Add a vertex to the graph */  
	public boolean addVertex(V vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			neighbors.add(new ArrayList<Edge>());
			return true;
		}
		else {
			return false;
		}
	}

	@Override /** Add an edge to the graph */  
	public boolean addEdge(Edge e) {
		if (e.getOriginVertex() < 0 || e.getOriginVertex() > getSize() - 1)
			throw new IllegalArgumentException("No such index: " + e.getOriginVertex());

		if (e.getDestinationVertex() < 0 || e.getDestinationVertex() > getSize() - 1)
			throw new IllegalArgumentException("No such index: " + e.getDestinationVertex());

		if (!neighbors.get(e.getOriginVertex()).contains(e)) {
			neighbors.get(e.getOriginVertex()).add(e);
			return true;
		}
		else {
			return false;
		}
	}

	@Override /** Add an edge to the graph */  
	public boolean addEdge(int u, int v) {
		return addEdge(new Edge(u, v));
	}

	@Override /** Obtain a DFS tree starting from vertex v */
	public SearchTree getDepthFirstSearchTree(int startingVertex) {
		// create a List to hold the search order of the vertices as they are visited

		// create an array to store the parent vertex during search

		// initially parent vertex is unknown, so initialize the array to -1
		

		// create an array to store visited status for each vertex (marked true when visited)

		// Recursively search beginning with this startingVertex, passing in arrays & searchList

		// Return a search tree created with the startingVertex, parent array, search order list, and isVisited array
		return null;
	}

	 @SuppressWarnings("unused")
	private void dfs(int vertex, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
		 // Add the visited vertex to the searchOrder list
		 
		 // Mark vertex as visited 
		 
		 // Get the list of neighbors for this vertex
		// For each edge in the neighbors list
			// if the destination vertex for this edge is not visited
				// set the destination vertex's parent vertex to the method argument vertex
				// recursively call dfs passing in the destination vertex, parent array, search order list and isVisited array
	 }
	
	
	 
	@Override /** Obtain a BFS search tree starting from vertex v */
	public SearchTree getBreadthFirstSearchTree(int vertex) {
		// create a List to hold the search order of the vertices as they are visited

		// create an array to store the parent vertex during search

		// initially parent vertex is unknown, so initialize the array to -1
		

		// create an array to store visited status for each vertex (marked true when visited)
		
		// create an empty queue for storing vertices to be visited
		
//		  add vertex into the queue;
//		  mark vertex visited;
		
//		  while the queue is not empty 
//		    dequeue a vertex, say u, from the queue
//		    mark u visited and add to the search order List
		
//		    for each neighbor, called w, of u
//		      if w has not been visited 
//		        add w into the queue;
//		        set u as the parent for w; 
//		        mark w visited;

		// return the SearchTree created from the argument vertex, parent array, and search order List
		return null;
	}



	/** SearchTree inner class inside the UnweightedGraph class */
	public class SearchTree {
		private int root; // The root of the tree
		private int[] parent; // Store the parent of each vertex
		private List<Integer> searchOrder; // Store the search order

		/** Construct a tree with root, parent, and searchOrder */
		public SearchTree(int root, int[] parent, 
				List<Integer> searchOrder) {
			this.root = root;
			this.parent = parent;
			this.searchOrder = searchOrder;
		}

		/** Return the root of the tree */
		public int getRoot() {
			return root;
		}

		/** Return the parent of vertex v */
		public int getParent(int v) {
			return parent[v];
		}

		/** Return an array representing search order */
		public List<Integer> getSearchOrder() {
			return searchOrder;
		}

		/** Return number of vertices found */
		public int getNumberOfVerticesFound() {
			return searchOrder.size();
		}

		/** Return the path of vertices from a vertex to the root */
		public List<V> getPath(int index) {
			ArrayList<V> path = new ArrayList<>();

			do {
				path.add(vertices.get(index));
				index = parent[index];
			}
			while (index != -1);

			return path;
		}

		/** Print a path from the root to vertex v */
		public void printPath(int index) {
			List<V> path = getPath(index);
			System.out.print("A path from " + vertices.get(root) + " to " +
					vertices.get(index) + ": ");
			for (int i = path.size() - 1; i >= 0; i--)
				System.out.print(path.get(i) + " ");
		}

		/** Print the whole tree */
		public void printTree() {
			System.out.println("Root is: " + vertices.get(root));
			System.out.print("Edges: ");
			for (int i = 0; i < parent.length; i++) {
				if (parent[i] != -1) {
					// Display an edge
					System.out.print("(" + vertices.get(parent[i]) + ", " +
							vertices.get(i) + ") ");
				}
			}
			System.out.println();
		}
	}
	/*  End implementation of inner SearchTree class */

/*  Lab methods to be implemented	*/
	public static UnweightedGraph<Integer> graphFromFile(String fileName) throws FileNotFoundException{
		return null;
	}

	public boolean isComplete() {
		return true;
	}
	
	public boolean areAdjacent(V origin, V destination) {
		return true;
	}
	
	@Override /** Obtain a DFS tree starting from vertex v */
	public SearchTree getDepthFirstSearchTree(int startingVertex) {
		// create a List to hold the search order of the vertices as they are visited

		// create an array to store the parent vertex during search

		// initially parent vertex is unknown, so initialize the array to -1
		

		// create an array to store visited status for each vertex (marked true when visited)

		// Recursively search beginning with this startingVertex, passing in arrays & searchList

		// Return a search tree created with the startingVertex, parent array, search order list, and isVisited array
		return null;
	}

	 @SuppressWarnings("unused")
	private void dfs(int vertex, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
		 // Add the visited vertex to the searchOrder list
		 
		 // Mark vertex as visited 
		 
		 // Get the list of neighbors for this vertex
		// For each edge in the neighbors list
			// if the destination vertex for this edge is not visited
				// set the destination vertex's parent vertex to the method argument vertex
				// recursively call dfs passing in the destination vertex, parent array, search order list and isVisited array
	 }
	
	
	 
	@Override /** Obtain a BFS search tree starting from vertex v */
	public SearchTree getBreadthFirstSearchTree(int vertex) {
		// create a List to hold the search order of the vertices as they are visited

		// create an array to store the parent vertex during search

		// initially parent vertex is unknown, so initialize the array to -1
		

		// create an array to store visited status for each vertex (marked true when visited)
		
		// create an empty queue for storing vertices to be visited
		
//		  add vertex into the queue;
//		  mark vertex visited;
		
//		  while the queue is not empty 
//		    dequeue a vertex, say u, from the queue
//		    mark u visited and add to the search order List
		
//		    for each neighbor, called w, of u
//		      if w has not been visited 
//		        add w into the queue;
//		        set u as the parent for w; 
//		        mark w visited;

		// return the SearchTree created from the argument vertex, parent array, and search order List
		return null;
	}
	
	public boolean isConnected() {
		return true;
	}
	
	public List<Integer> getSortestPath(int u, int v){
		return null;
	}
	
	public boolean hasCycle() {
		return true;
	}

}

