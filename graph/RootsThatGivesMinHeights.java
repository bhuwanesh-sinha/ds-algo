package graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class RootsThatGivesMinHeights {
	
	static class Graph {
		static int V; 
		
		static LinkedList<Integer>[] adj;

		
		static int[] degree;

		Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			degree = new int[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<Integer>();
				degree[i] = 0;
			}
		}

		void addEdge(int v, int w) {
			adj[v].add(w); 
			adj[w].add(v); 
			degree[v]++; 
			degree[w]++; 
		}

		static void rootForMinimumHeight() {
			Deque<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < V; i++)
				if (degree[i] == 1)
					q.add(i);
			boolean flag = true;

			while (!q.isEmpty()) {
				if (!flag)
					break;
				if(adj[q.peekFirst()].getLast()==q.peekFirst())
					break;
				int t = q.poll();

				Iterator<Integer> it = adj[t].listIterator();
				
				while (it.hasNext()) {
					int num = it.next();
					degree[num]--;
					if (num == q.peekLast())
						flag = false;
					if (degree[num] == 1)
						q.add(num);
				}
			}
			while (!q.isEmpty())
				System.out.print(" " + q.pop());
		}

	}
	
	
	// Driver code to test above methods
	public static void main(String[] args) {
		Graph g = new Graph(13);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		g.addEdge(11, 2);
		g.addEdge(2, 5);
		g.addEdge(5, 4);
		g.addEdge(4, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(9, 10);
		g.addEdge(11, 12);
		g.rootForMinimumHeight();
	}
}
