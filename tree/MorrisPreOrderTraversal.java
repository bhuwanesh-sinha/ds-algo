package tree;

import tree.ReverseAlternateLevels.Node;

public class MorrisPreOrderTraversal {
	
	private static void morristraversal(Node root) {
		Node curr = root;
		Node suc = root; //in-order successor, which is always one left then right most node.
		
		while(curr!=null)
		{
			
			
			if(curr.left!=null)
			{
				suc = curr.left;
				
				while(suc.right!=null && suc.right!=curr){suc = suc.right;}
				
				if(suc.right==curr)
				{
					suc.right=null;
					curr=curr.right;
				}
				else
				{
				System.out.print(" "+curr.data);
				suc.right=curr;
				curr=curr.left;
				}
			}
			else
			{
				System.out.print(" "+curr.data);
				curr=curr.right;
			}
		}
	}
	
	static class Node  
	{  
	    int data;  
	    Node left, right;  
	};
	
	// A utility function to create a new node  
		static Node newNode(int data)  
		{  
		    Node temp = new Node();  
		    temp.left = temp.right = null;  
		    temp.data = data;  
		    return temp;  
		}
	
	public static void main(String[] args) {
		{  
		    Node root = newNode(10);  
		    root.left = newNode(5);  
		    root.right = newNode(30);  
		    root.left.left = newNode(-2);  
		    root.left.right = newNode(6);  
		    root.right.right = newNode(40);  
		    root.left.left.right = newNode(2);  
		    root.left.right.right = newNode(8);
		    root.left.left.right.left = newNode(-1);
		    
		    morristraversal(root);
		  
		}


}

	
}
