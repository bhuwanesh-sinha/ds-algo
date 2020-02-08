package graph;

public class MotherVertex {
	
	private static int findMotherVertex(Graph g)
	{
		boolean[] visited = new boolean[g.V];
		int lastNode=0;
		for(int i=0; i<g.adj.length; i++)
		{
			if(!visited[i])
			{
				lastNode=i;
				g.DFS(i, visited);
			}
		}
		
		visited =  new boolean[g.V]; //reset all flags and visit all from lastNode
		g.DFS(lastNode, visited);
		
		for(int i=0; i<g.V; i++)
		{
			if(visited[i]==false)
			return -1;	
		}
		
		return lastNode;
	}

	public static void main(String[] args) {
		Graph g = new Graph(7); 
	    g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0);
	    
	    int mother = findMotherVertex(g);
	    System.out.println();
	    System.out.println("Mother vertex found- "+mother);
	}

	

}
