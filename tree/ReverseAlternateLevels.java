package tree;

public class ReverseAlternateLevels {
	
	static class Node  
	{  
	    char key;  
	    Node left, right;  
	}; 
	static void printInorder( Node root)  
	{  
	    if (root == null)  
	        return;  
	    printInorder(root.left);  
	    System.out.print( root.key + " ");  
	    printInorder(root.right);  
	}  
	  
	// A utility function to create a new node  
	static Node newNode(int key)  
	{  
	    Node temp = new Node();  
	    temp.left = temp.right = null;  
	    temp.key = (char)key;  
	    return temp;  
	} 
	public static void main(String[] args) {
		{  
		    Node root = newNode('a');  
		    root.left = newNode('b');  
		    root.right = newNode('c');  
		    root.left.left = newNode('d');  
		    root.left.right = newNode('e');  
		    root.right.left = newNode('f');  
		    root.right.right = newNode('g');  
		    root.left.left.left = newNode('h');  
		    root.left.left.right = newNode('i');  
		    root.left.right.left = newNode('j');  
		    root.left.right.right = newNode('k');  
		    root.right.left.left = newNode('l');  
		    root.right.left.right = newNode('m');  
		    root.right.right.left = newNode('n');  
		    root.right.right.right = newNode('o');  
		  
		    System.out.print("Inorder Traversal of given tree\n");  
		    printInorder(root);  
		  
		    reverseAlternate(root);  
		  
		    System.out.print("\n\nInorder Traversal of modified tree\n");  
		    printInorder(root);  
		      
		}  
	}

	private static void reverseAlternate(Node root) {
		levelOrder(root.left, root.right, 0);
		
	}

	private static void levelOrder(Node left, Node right, int level) {
		
		if(left==null || right==null){return;}
		
		if(level%2==0)
		{
			char temp = right.key;
			right.key = left.key;
			left.key = temp;
		}
		
		levelOrder(left.left, right.right, level+1);
		levelOrder(left.right, right.left, level+1);
		
	}

}
