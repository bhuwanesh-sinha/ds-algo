package graph;

import java.util.Arrays;
import java.util.LinkedList;

class NodeList{
	Integer v;
	Integer w;
	NodeList next;
	NodeList head;
	
	NodeList(Integer v, Integer w)
	{
		this.v=v;
		this.w=w;
		next=null;
	}
	
	public NodeList() {
		// TODO Auto-generated constructor stub
	}

	NodeList add(int v, int w)
	{
		if(head==null){head = this;}
		
		NodeList n = new NodeList(v, w);
		head.next = n;
		head = n;
		return head;
	}
}

class Graph1{
	static int V;
	static NodeList[] adj ;
	
	Graph1(int v)
	{
		V=v;
		adj = new NodeList[V];
		//for(int i=0; i<V; i++){ adj[i] = new NodeList();}
	}
	
	void addEdge(int u, int v, int w)
	{
		if(adj[u]==null){ adj[u]=new NodeList(v, w); }
		else{ adj[u].add(v, w); }
	}
	
}

public class DijkstraAdjacencyListOptimizrd {

	private static void dijkstra(int src, Graph1 g) {

		int[] heap = new int[g.V];
		int[] whereIsX = new int[g.V];
		int[] whoIsHere = new int[g.V];

		initialize(src, heap, whereIsX, whoIsHere);

		int last = heap.length - 1;

		while (last > 0) {
			int node = whoIsHere[0];
			swap(whereIsX[node], last, heap, whereIsX, whoIsHere);
			NodeList head = g.adj[node];

			while (head != null) {
				// check if neighbour's index in heap is less than dynamic length of the heap i.e. not-visited(All the visited nodes are beyond last)
				if (whereIsX[head.v] < last) 
				{
					relaxNeighbours(heap, node, head, whereIsX);
					heapify(whereIsX[head.v], heap, whereIsX, whoIsHere);
				}
				    
				head = head.next;
			}

			last--;
		}

		printSolution(heap, whereIsX);
	}

	private static void initialize(int src, int[] heap, int[] whereIsX, int[] whoIsHere) {
		Arrays.fill(heap, Integer.MAX_VALUE);
		
		for (int i = 0; i < Graph1.V; i++) {
			whereIsX[i] = i;
			whoIsHere[i] = i;
		}
		
		heap[src] = 0; // assign zero distance to src
		swap(whereIsX[src], 0, heap, whereIsX, whoIsHere); //bring src to 0th position
		
	}

	private static void heapify(Integer v, int[] heap, int[] whereIsX, int[] whoIsHere) {
		if (v == 0) {return;}
		
		int parent = (v - 1) / 2;
		
		if (heap[parent] > heap[v]) {
			swap(v, parent, heap, whereIsX, whoIsHere);
		}
		heapify(parent, heap, whereIsX, whoIsHere);
	}

	private static void swap(int i, int j, int[] heap, int[] whereIsX, int[] whoIsHere) {
		swap(heap, i, j);
		swap(whereIsX, whoIsHere[i], whoIsHere[j]);
		swap(whoIsHere, i, j);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void relaxNeighbours(int[] heap, int node, NodeList head, int[] whereIsX) 
	{
		if ((heap[whereIsX[node]] + head.w) < heap[whereIsX[head.v]])
		{
			heap[whereIsX[head.v]] = heap[whereIsX[node]] + head.w;
		}

	}

	static void printSolution(int heap[], int[] whereIsX) {

		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < heap.length; i++)
			System.out.println(i + " \t\t " + heap[whereIsX[i]]);
	}

	public static void main(String[] args) {

		int[][] arr = 
			  {{ 0,  4,  0,  0,   0,  0,  0,  8,  0 }, 
				{ 4,  0,  8,  0,   0,  0,  0, 11, 0 }, 
				{ 0,  8,  0,  7,   0,  4,  0,  0,  2 }, 
				{ 0,  0,  7,  0,   9, 14, 0,  0,  0 }, 
				{ 0,  0,  0,  9,   0, 10, 0,  0,  0 }, 
				{ 0,  0,  4, 14, 10,  0, 2,  0,  0 }, 
				{ 0,  0,  0,  0,   0,   2, 0,  1,  6 }, 
				{ 8, 11,  0,  0,  0,   0, 1,  0,  7 }, 
				{ 0,   0,  2,  0,  0,   0, 6,  7,  0 } };

		Graph1 g = new Graph1(arr.length);

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0)
					g.addEdge(i, j, arr[i][j]);
			}

		dijkstra(0, g);
		
	}

}

/*O/P - 
 * 
Vertex 	Distance from Source
0 		 0
1 		 4
2 		 12
3 		 19
4 		 21
5 		 11
6 		 9
7 		 8
8 		 14*/
