package tree;

import utilities.BinaryTree;
import utilities.BinaryTree.Node;

public class BinaryTreeToDoubleLinkedList {
	
	static BinaryTree.Node prev = new Node(-1);

	public static void main(String[] args)
	{
		BinaryTree.Node root = BinaryTree.createTree();
		binaryTreeToDLL(root);
		
		System.out.println("Done recursion..");
		 while(prev.left!=null)
		 {
			 System.out.print(" "+prev.data);
			 prev=prev.left;
		 }

	}

	private static void binaryTreeToDLL(Node root) {
		
		inOrderTraversal(root);
	}

	private static void inOrderTraversal(Node root) {
		
		if(root==null){return;}
		
		inOrderTraversal(root.left);
		
		prev.right= root;
		root.left=prev;
		prev=prev.right;
		
		inOrderTraversal(root.right);
		
	}

}
