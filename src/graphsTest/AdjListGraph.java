package graphsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class AdjListGraph {

    private LinkedList<Integer>[] adj;
    private int V; // number of vertices
    private int E; // number of edges

    public AdjListGraph(int nodes) {
	this.V = nodes;
	this.E = 0;
	this.adj = new LinkedList[nodes];
	for (int v = 0; v < V; v++) {
	    adj[v] = new LinkedList<>();
	}
    }

    public void addEdge(int u, int v) {
	adj[u].add(v);
	adj[v].add(u);
	E++;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(V + " vertices, " + E + " edges " + "\n");
	for (int v = 0; v < V; v++) {
	    sb.append(v + ": ");
	    for (int w : adj[v]) {
		sb.append(w + " ");
	    }
	    sb.append("\n");
	}
	return sb.toString();
    }

    public void BFSIterative(int s) {
	boolean visited[] = new boolean[V];
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.offer(s);
	visited[s]= true;
	while(!queue.isEmpty()) {
	    Integer u = queue.poll();
	    System.out.print(u + " ");
	    for(int v : adj[u]) {
		if(!visited[v]) {
		    visited[s]= true;
		    queue.offer(v);
		}
	    }
	}
	
    }
   
    public List<List<Integer>> bfs2(int s) {
   	List<List<Integer>> res = new ArrayList<List<Integer>>(); 
   	boolean[] visited = new boolean[V];

   	Queue<Integer> q = new LinkedList<>();
   	visited[s] = true;
   	q.offer(s);

   	while (!q.isEmpty()) {
   	    int u = q.poll();
   	 List<Integer> level = new ArrayList<>();
   	 for(int i = 0; i<q.size();i++)
   	  level.add(u);
   	    //System.out.print(u + " ");
   	    for (int v : adj[u]) {
   		if (!visited[v]) {
   		    visited[v] = true;
   		    q.offer(v);
   		}
   	    }
   	    res.add(level);
   	}
   	return res;
       }

    public void bfs(int s) {
   	boolean[] visited = new boolean[V];
   	Queue<Integer> q = new LinkedList<>();
   	//Stack<Integer> q = new Stack<>();
   	visited[s] = true;
   	q.offer(s);
   	//q.push(s);
   	while (!q.isEmpty()) {
   	  int u = q.poll();
   	 //int u = q.pop();
   	    System.out.print(u + " ");

   	    for (int v : adj[u]) {
   		if (!visited[v]) {
   		    visited[v] = true;
   		     q.offer(v);
   		 //q.push(v);
   		}
   	    }
   	}
   	System.out.println();
       }
    public void dfs(int s) {
	boolean[] visited = new boolean[V];
	Stack<Integer> stack = new Stack<>();
	stack.push(s);

	while (!stack.isEmpty()) {
	    int u = stack.pop();
	    if (!visited[u]) {
		visited[u] = true;
		System.out.print(u + " ");

		for (int v : adj[u]) {
		    if (!visited[v]) {
			stack.push(v);
		    }
		}
	    }
	}
	System.out.println();
    }

    public void dfs() {
	boolean[] visited = new boolean[V];
	for (int v = 0; v < V; v++) {
	    if (!visited[v]) {
		dfs(v, visited);
	    }
	}
    }

    private void dfs(int v, boolean[] visited) {
	visited[v] = true;
	System.out.print(v + " ");
	for (int w : adj[v]) {
	    if (!visited[w]) {
		dfs(w, visited);
	    }
	}
    }
    
    private void dfsRecursiveUtils() {
	boolean visited[]= new boolean[V];
	for(int v = 0; v<V; v++) {
	    if(!visited[v]) {
		dfsRecursive(v, visited);
	    }
	}
	System.out.println();
    }
    private void dfsRecursive(int v, boolean[] visited) {
	visited[v]=true;
	//System.out.print(v + " ");
	for(int  w : adj[v]) {
	    if(!visited[w]) {
	     dfsRecursive(w, visited);
	   }
	}
	System.out.print(v + " ");
    }
    private void dfstopologicalRecursiveUtils() {
	boolean visited[]= new boolean[V];
	for(int v = 0; v<V; v++) {
	    if(!visited[v]) {
		dfsRecursive(v, visited);
	    }
	}
	System.out.println();
    }
    public void test() {
	LinkedList<Integer>[] ll = null;
	List<Integer> list = new ArrayList<>();
	for(int x : list) {
	    
	}
	
	    
    }
public GraphNode cloneGraph(GraphNode node) {
        
        if(node==null){
            return node;
        }
       
        Map<Integer, GraphNode> map = new HashMap<>();
        GraphNode res = cloneGraphDfsUtil(node,map);
        
        return res;
        
    }
    /*https://leetcode.com/problems/clone-graph/*/
    public GraphNode cloneGraphDfsUtil(GraphNode node, Map<Integer, GraphNode> map){
	    
        GraphNode temp = new GraphNode(node.val);
    
        map.put(temp.val, temp); 
    
        for(GraphNode side : node.neighbors){
              if(!map.containsKey(side.val)){ 
                 temp.neighbors.add(cloneGraphDfsUtil(side,map));

              }else{
                temp.neighbors.add(map.get(side.val));
            }
    
         }
        return temp;
    }
    
    public GraphNode cloneGrphUtil( GraphNode node, Map<Integer,GraphNode> map) {
	 GraphNode temp = new  GraphNode(node.val);
	 map.put(temp.val, temp);
	 for(GraphNode sides : node.neighbors) {
	     if(!map.containsKey(sides.val))
		 temp.neighbors.add(cloneGrphUtil(sides, map));
	     else {
		 temp.neighbors.add(map.get(sides.val));
	     }
	 }
	return temp;
    }
    
    public static void main(String[] args) {
	
    	for(int i = 0; true; i++) {
    	    System.out.println("ee");
    	    break;
    	}

	AdjListGraph g = new AdjListGraph(5);
	g.addEdge(0, 3);
	g.addEdge(0, 1);
	g.addEdge(2, 4);
	g.addEdge(1, 2);
	g.addEdge(2, 3);
	
	
	System.out.println(Arrays.asList(g.adj));
	System.out.println(g);
	System.out.println("bfs: ");
	g.bfs(0);
	System.out.println("dfs: ");
	g.dfs(0);
	System.out.println("dfs recursive: ");
	g.dfsRecursiveUtils();
	System.out.println("level order : "+g.bfs2(0));
    }
}