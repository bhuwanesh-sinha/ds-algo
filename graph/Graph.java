package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph{
	
	static int V; // no. of nodes..
	static List<Integer>[] adj;
	
	Graph(int V)
	{
		this.V=V;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++){ adj[i] = new LinkedList<Integer>(); }
	}

	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	void DFSTravel(int node)
	{
		boolean[] visited = new boolean[V];
		
		//***** uncomment to travel for all nodes in case if disconnected graphs..
		/*for(int i=0; i<V; i++){
			if(!visited[i])
			DFS(i, visited); // print others recursively..
		}*/
		
		DFS(node, visited);
		
	}
	
	void DFS(int node, boolean[] visited) {
		System.out.print(" "+node);
		visited[node]=true;
		List<Integer> list = adj[node];
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
			int data = it.next();
			if(!visited[data])
			{
				DFS(data, visited);
			}
		}
	}
	
	private void BFSTravel(int node)
	{
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		
		while(!q.isEmpty())
		{
			int data = q.poll();
			System.out.print(" "+data);
			visited[data]=true;
			List<Integer> list = adj[data];
			
			Iterator<Integer> it = list.iterator();
			
			while(it.hasNext())
			{
				int i = it.next(); 
				if(!visited[i])
				q.add(i);
			}
		}
		
	}


	public static void main(String[] args) {
		
		Graph g = createGraph();

		System.out.print("DFS - "); 
        g.DFSTravel(2);
        System.out.println();
        System.out.print("BFS - "); 
        g.BFSTravel(2);
	}


	private static Graph createGraph() {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		return g;
	}

}
