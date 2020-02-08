package graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphCycleDetection {
	static boolean flag=false;
	static class Graph{
		 
		static int V; 
		static int WHITE=0; //unvisited
		static int GRAY=1;  //under process in BFS
		static int BLACK=2; //completed
		 
		static LinkedList<Integer>[] adj; 

		 
		static int[] color;
		
		
		Graph(int V) 
		{ 
			this.V = V; 
			adj = new LinkedList[V];
			color = new int[V];
			
			for (int i = 0; i < V; i++) 
			{
				adj[i] = new LinkedList<Integer>();
			}
		} 

		void addEdge(int v, int w) 
		{ 
			adj[v].add(w); // Add w to v’s list 
			
		}

		public boolean isCyclic(int node) {
			for(int i=0; i<V;i++)
				color[i]=WHITE;
			
			 return DFS(node);
		}
		//*************IMPORTANT*************
		//Always try to take a static flag to indicate a grey is found.. 
		//this makes program much simpler than returning a boolean check
		private boolean DFS(int node) {
			
			color[node]=GRAY;
			
			Iterator<Integer> it = adj[node].iterator();
			
			while(it.hasNext() && !flag)
			{
				int i=it.next();
				if(color[i]==GRAY)
					return  true;
				
				if(color[i]!=BLACK)
					return DFS(i);
			}
			
			color[node]=BLACK;
			return false;
		}

	}
	
	public static void  main(String[] args) 
	{ 

		Graph g = new Graph(4); 
        g.addEdge(0, 1); 
        //g.addEdge(0, 2); // cycle
        //g.addEdge(1, 2); // cycle
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        //g.addEdge(3, 3); // cycle
        
        if (g.isCyclic(3)) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contain cycle"); 

	// rootForMinimumHeight();	
	} 
}
