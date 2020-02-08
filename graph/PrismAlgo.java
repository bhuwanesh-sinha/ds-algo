package graph;

import java.util.Arrays;

public class PrismAlgo {
static int V;
static ListNode[] adj ;

class Graph{
	Graph(int v)
	{
		PrismAlgo.V=v;
		adj= new ListNode[v];
	}
	
	void addEdge(int u, int v, int w)
	{
		if(adj[u]==null)
		{
			adj[u] = new ListNode(v, w);
		}
		else
		adj[u].addNode(v, w);
	}
}

class ListNode{
	int v, w;
	ListNode next, head;
	ListNode(int v, int w){
		this.v=v;
		this.w=w;
		head=this;
	}
	void addNode(int v, int w)
	{
		head.next = new ListNode(v, w);
		head = head.next;
	}
}

private static void prismMST(Graph g, int src) {
	
	int[] parent = new int[PrismAlgo.V];
	
	int[] heap = new int[PrismAlgo.V];
	int[] whoIsHere = new int[PrismAlgo.V];
	int [] whereIs = new int[PrismAlgo.V];
	
	initialize(parent, heap, whoIsHere, whereIs);
	
	heap[src]=0;
	swap(whoIsHere, whereIs, heap, 0, src);
	
	int last = heap.length-1;
	
	while(last>0)
	{
		int u = whoIsHere[0];
		swap(whoIsHere, whereIs, heap, 0, last);

		ListNode  head = adj[u];
		while(head!=null)
		{
			if(whereIs[head.v]<last && head.w < heap[whereIs[head.v]])
			{
				heap[whereIs[head.v]] = head.w;
				parent[head.v] = u;
				heapify(whoIsHere, whereIs, heap, whereIs[head.v]);
			}
			
			head=head.next;
		}
		last--;
	}
	
	
	for(int i=0; i<heap.length; i++)
	{
		if(parent[i]==-1){continue;}
		System.out.println(i+ " ----- "+ parent[i] +"    "+ heap[whereIs[i]]);
	}
}

private static void heapify(int[] whoIsHere, int[] whereIs, int[] heap, int i) {
	if(i==0){return;}
	
	int p = (i-1)/2;
	while(heap[i]<heap[p])
	{
		swap(whoIsHere, whereIs, heap, i, p);
		heapify(whoIsHere, whereIs, heap, p);
	}
	
}

private static void swap(int[] whoIsHere, int[] whereIs, int[] heap, int u, int v) {
	swap(heap, u, v);
	swap(whereIs, whoIsHere[u], whoIsHere[v]);
	swap(whoIsHere, u, v);
	
	
}

static void swap(int[] arr, int s, int d)
{
	int temp = arr[s];
	arr[s] = arr[d];
	arr[d] = temp;
}


	private static void initialize(int[] parent, int[] heap, int[] whoIsHere, int[] whereIs) {
	Arrays.fill(parent, -1);
	Arrays.fill(heap, Integer.MAX_VALUE);
	for(int i=0; i< heap.length; i++)
	{
		whoIsHere[i] = i;
		whereIs[i] = i;
	}
}

	public static void main(String[] args) {
		int[][] arr = 
				 { { 0, 2, 0, 6, 0 }, 
                    { 2, 0, 3, 8, 5 }, 
                    { 0, 3, 0, 0, 7 }, 
                    { 6, 8, 0, 0, 9 }, 
                    { 0, 5, 7, 9, 0 } };

		PrismAlgo.Graph g = new PrismAlgo().new Graph(arr.length);

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0)
					g.addEdge(i, j, arr[i][j]);
			}
		
		prismMST(g, 0);

	}

	

}
