package tree;

public class MaxSumInNonAdjacentNodes {
	
	private static int findMaxNonAdjacentSum(Node node) {
		
		if(node==null){return 0;}
		
		int sumLeft = findMaxNonAdjacentSum(node.left);
		int sumRight = findMaxNonAdjacentSum(node.right);
		
		return Math.max(node.data, sumLeft+sumRight);
	}
	
	public static void main(String[] args) 
	{
		Node root = createTree();
		int sumLeft = findMaxNonAdjacentSum(root.left);
		int sumRight = findMaxNonAdjacentSum(root.right);
		System.out.println(sumLeft+sumRight);
	}
	
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
		Node root= new Node(10); 
	    root.left= new Node(1); 
	    root.left.left= new Node(2); 
	    root.left.left.left= new Node(1); 
	    root.left.right= new Node(3); 
	    root.left.right.left= new Node(4); 
	    root.left.right.right= new Node(5);
		
		
		return root;
	}

}
