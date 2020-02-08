package matrix;

import java.util.LinkedList;
import java.util.Queue;

class Node
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data=data;
	}
}

public class CreateTreeFromAncestorMatrix {
	
	private static void findParent(int col, int[][] mat, int[] count, Node[] nodes) { 
		//An ancestor with least no.of  descendants is the  parent.
		Node parent=null;
		int cnt=Integer.MAX_VALUE;
		
		//find an ancestor with minimum no. of descendants and store it in parent variable
		for(int row=0; row<count.length; row++)
		{
			//mat[row][col]==1 means it is an ancestor
			// an ancestor with minimum descendants is the parent
			if(mat[row][col]==1 && count[row] < cnt) //if this element in the column is a parent
			{
				parent = nodes[row];
				cnt = count[row];
			}
		}
		
		//if parent is not null, make current node as its left or right child.
		if(parent!=null)
		{
			if(parent.right==null) { parent.right=nodes[col]; }
			else if(parent.left==null){ parent.left=nodes[col]; }
			//recursively find  parent of this parent node.	
			findParent(parent.data, mat, count, nodes);
		}
	
	}
	
	static Node createTree(int[][] mat)
	{
		int[] count = new int[mat.length]; //used to count no. of descendants a node has.. it is sum of all the all the elements in that row.  
		Node[] nodes = new Node[mat.length]; // a map to store mapping of int/actual node. 
		
		for(int i=0; i<mat.length; i++){nodes[i]=new Node(i);} //initialize map .
		
		//initialize count[] to store total no. of descendants of that element
		for(int i=0; i<mat.length; i++)
		{
			int c=0;
			for(int j=0; j<mat.length; j++)
			{
				if(mat[i][j]==1){c++;}
			}
			count[i]=c;
		}
		
		/* find a leaf node which has all the elements in its row as 0
		 * and recursively find parent of it till root node is reached*/
		for(int i=0; i<mat.length; i++)
		{
			if(count[i]==0)// if it is a leaf node
			{
				findParent(i, mat, count, nodes);
			}
		}
		
		Node root=null;
		//find root of the tree, an element with count of descendants = (total_no_of_nodes -1) is the root
		for(int i=0; i<mat.length; i++)
		{
			if(count[i]== mat.length-1)
			{
				root=nodes[i];
			}
		}
		return root;
	}

public static void main(String[] args) {
		 int[][] mat = 
			 {      { 0, 0, 0, 0, 0, 0 }, 
			        { 1, 0, 0, 0, 1, 0 }, 
			        { 0, 0, 0, 1, 0, 0 }, 
			        { 0, 0, 0, 0, 0, 0 }, 
			        { 0, 0, 0, 0, 0, 0 }, 
			        { 1, 1, 1, 1, 1, 0 } 
			    }; 
		 Node root = createTree(mat);
		 System.out.println("level order - ");
		 printLevelOrder(root);
	}

static void printLevelOrder(Node root)  
{ 
    Queue<Node> queue = new LinkedList<Node>(); 
    queue.add(root); 
    while (!queue.isEmpty())  
    { 
    	
        Node tempNode = queue.poll(); 
        System.out.print(tempNode.data + " "); 

        if (tempNode.left != null) { 
            queue.add(tempNode.left); 
        } 

        if (tempNode.right != null) { 
            queue.add(tempNode.right); 
        } 
    } 
}

}
