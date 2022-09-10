package graphsTest;

import java.util.LinkedList;

public class Graph {

    private int vertices; // number of vertices
    private LinkedList<Integer> adjacencyList[]; // Adjacency Lists
    // Constructor

    public Graph(int vertices) {
	this.vertices = vertices;
	adjacencyList = new LinkedList[vertices];
	for (int i = 0; i < vertices; ++i)
	    adjacencyList[i] = new LinkedList();
    }

    void addEdge(int source, int destination) {
	adjacencyList[source].add(destination);
    }

    public int getVertices() {
	return this.vertices;
    }

    public LinkedList<Integer>[] getAdj() {
	return this.adjacencyList;
    }
}
