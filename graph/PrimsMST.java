package graph;

import java.util.Arrays;

public class PrimsMST {

	private static void findMST(int[][] graph) {
		int V = graph.length;
		int[] dist = new int[V];
		boolean[] included = new boolean[V];
		int[] parent = new int[V];
		
		Arrays.fill(included,false);
		Arrays.fill(dist,Integer.MAX_VALUE);
		Arrays.fill(parent,-1);
		dist[0]=0;
		
		
		for(int i=0; i<V; i++)
		{
			int u = findMin(included, dist);
			included[u]=true;
			for(int v=0; v<V; v++)
			{
				if(graph[u][v]!=0 && !included[v] && graph[u][v]<dist[v])
				{
					dist[v]=graph[u][v];
					parent[v]=u;
				}
			}
		}
		printMST(dist, parent);
	}
	
	private static void printMST(int[] dist, int[] parent) {
		for(int i=0; i<dist.length; i++)
		{
			if(parent[i]!=-1)
			System.out.println(parent[i] +" --- "+i+" | "+dist[i]);
		}
	}

	private static int findMin(boolean[] included, int[] dist) {
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0; i<dist.length; i++)
		{
			if(!included[i] && dist[i]<min)
			{
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { 
			{ 0, 2, 0, 6, 0 }, 
            { 2, 0, 3, 8, 5 }, 
            { 0, 3, 0, 0, 7 }, 
            { 6, 8, 0, 0, 9 }, 
            { 0, 5, 7, 9, 0 } 
            }; 
         
            findMST(graph);
            

	}

	

}
