package utilities;

public class BinaryTree {
	
	public static class Node{
		public int data;
		public Node left;
		public Node right;
		public Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	public static Node createTree(){
		//inorder is in sequence
		Node root = new Node(6);
		root.left = new Node(4);
		root.left.left = new Node(2);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(3);
		root.left.right = new Node(5);
		root.right = new Node(10);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		return root;
	}
	
	public static Node createTree2(){
		//level order is in sequence
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		return root;
	}

	public static void main(String[] args) {

		BinaryTree.Node root = BinaryTree.createTree();
		inOrderTraverse(root);
	}

	public static void inOrderTraverse(Node root) {
		
		if(root==null)
		{
			return;
		}
		
		inOrderTraverse(root.left);
		
		System.out.print(" "+root.data);
		
		inOrderTraverse(root.right);
		
	}

}
