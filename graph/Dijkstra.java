package graph;

import java.util.Arrays;
import java.util.HashMap;

public class Dijkstra {
	
	private int[] dijkstra(int[][] graph, int src) {

		 int V = graph.length;
		 int[] dist = new int[V];
		 boolean[] set = new boolean[V];
		 Arrays.fill(dist, Integer.MAX_VALUE);
		 Arrays.fill(set, false);
		 HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		 
		 dist[src]=0;
		 parent.put(src,-1);
		 for(int i=0;i<V; i++)
		 {
			 int u = findMin(dist, set);
			 set[u]=true;
			 
			 for(int v=0;v<V; v++)
			 {
				 if(!set[v] && graph[u][v]!=0 &&  dist[u]+graph[u][v] <dist[v])
				 {
					 dist[v] = dist[u]+graph[u][v];
					 parent.put(v, u); // to print prent path
				 }
			 }
		 }
		
		 for(int i=0; i<V;i++)
		 {
			 int p=i;
			 
			 while(p!=-1)
			 {
				 System.out.print(p+" -> ");
				 p = parent.get(p);
			}
			 System.out.println();
		 }
			 
			 
	return dist;	 
	}

	

	private int findMin(int[] dist, boolean[] set) {
		//this code can be optimized using minHeap
		int min=Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=0; i<dist.length; i++)
		{
			if(dist[i]<min && !set[i])
			{
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}

	void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < dist.length; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    }
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { 
			{ 0,  4,  0,  0,   0,  0,  0,  8,  0 }, 
			{ 4,  0,  8,  0,   0,  0,  0, 11, 0 }, 
			{ 0,  8,  0,  7,   0,  4,  0,  0,  2 }, 
			{ 0,  0,  7,  0,   9, 14, 0,  0,  0 }, 
			{ 0,  0,  0,  9,   0, 10, 0,  0,  0 }, 
			{ 0,  0,  4, 14, 10,  0, 2,  0,  0 }, 
			{ 0,  0,  0,  0,   0,   2, 0,  1,  6 }, 
			{ 8, 11,  0,  0,  0,   0, 1,  0,  7 }, 
			{ 0,   0,  2,  0,  0,   0, 6,  7,  0 } 
			}; 
			Dijkstra t = new Dijkstra(); 
			int src=0;
			int[] dist = t.dijkstra(graph, src);
			t.printSolution(dist);
		}

	

}
