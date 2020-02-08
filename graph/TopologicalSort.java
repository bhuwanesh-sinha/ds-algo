package graph;


import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	static Stack<Integer> st = new Stack<Integer>();
	static Graph g ;
	static boolean[] visited ;
	
	public static void topologicalSort(int node) {
		
		for(int i=0; i<g.V; i++)
		{
			if(!visited[i])
			DFS(i);
		}
	}
	
	private static void DFS(int node) {
		
		visited[node]=true;
		
		Iterator<Integer> it = g.adj[node].listIterator();
		while(it.hasNext())
		{
			int i=it.next();
			if(!visited[i])
			DFS(i);
		}
		
		st.add(node);
	}

	public static void main(String[] args) {
		
		g = new Graph(6); 
		visited = new boolean[g.V];
		
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        topologicalSort(5);
        
        System.out.println("Topological sort - ");
        
        while(!st.empty())
        System.out.print(" "+st.pop());
	}

	

}
