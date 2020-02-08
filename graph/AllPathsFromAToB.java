package graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromAToB {
	
	static Graph g;
	static Deque<Integer> q = new LinkedList<Integer>();
	static boolean[] visited ;
	
	private static void printPaths(int s, int d) {
		q.add(s);
		visited[s]=true;
		
		if(s==d)
		{
			System.out.println(); //new line
			printQueue();
			q.removeLast();
			visited[s]=false;
			return;
		}
		
		Iterator<Integer> it = g.adj[s].listIterator();
		while(it.hasNext())
		{
			int next = it.next();
			if(!visited[next])
			printPaths(next, d);
		}
		
		q.removeLast();
		visited[s]=false;
	}
	
	private static void printQueue()
	{
		Iterator<Integer> it = q.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" -> ");
		}
		System.out.println(" END");
	}

	public static void main(String[] args) {
		 
		g = new Graph(5);
		visited = new boolean[5];
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 4); 
        g.addEdge(1, 4); 
        g.addEdge(1, 3); 
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(2, 1); //cyclic
        int source = 0, destination = 4; 
        printPaths(source, destination);
	}

	

}
