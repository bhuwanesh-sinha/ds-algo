package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestLeafToLeafPath {
	
	static int maxDiameter =0;
	static Node maxDiameterNode =null;
	static int maxLeftHeight = 0;
	static int maxRightHeight = 0;
	static Stack<Integer> st = new Stack<Integer>();
	static Deque<Integer> q = new LinkedList<Integer>();
	
	public static int findMaxDiameterNode(Node root) {
		
		if(root==null)
		{
			return 0;
		}
		
		int leftHeight=findMaxDiameterNode(root.left);
		
		int rightHeight=findMaxDiameterNode(root.right);
		
		int diameter = 1 + leftHeight + rightHeight;
		
		if(diameter > maxDiameter)
		{
			maxDiameter = diameter;
			maxDiameterNode = root;
			maxLeftHeight = leftHeight;
			maxRightHeight = rightHeight;
		}
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	
	
	private static void printPath() {
		printLeftPathWithGivenHeight(maxDiameterNode.left, maxLeftHeight-1);
		System.out.print(" "+maxDiameterNode.data);
		printRightPathWithGivenHeight(maxDiameterNode.right, maxRightHeight-1);
	}
//****************IMPORTANT!!!!*************	
//one awesome way to print path is to store parent of every node in a map<node,parent>, can avoid backtracking
	private static void printLeftPathWithGivenHeight(Node node, int height) {
		if(node==null || height<0){return;}
		st.push(node.data);
		printLeftPathWithGivenHeight(node.left, height-1);
		printLeftPathWithGivenHeight(node.right, height-1);
		if(height==0)
			printStack(st);
		else if(!st.empty())
			st.pop();			// BACK-TRAKING...******** :)
	}
	
	private static void printRightPathWithGivenHeight(Node node, int height) {
		if(node==null){return;}
		
		q.add(node.data);
		printRightPathWithGivenHeight(node.left, height-1);
		printRightPathWithGivenHeight(node.right, height-1);
		if(height==0)
			printQueue(q);
		else if(!q.isEmpty())
			q.removeLast();  // BACK-TRAKING...******* :)
	}

	private static void printQueue(Queue<Integer> q) {
		while(!q.isEmpty())
		{
			System.out.print(" "+q.poll());
		}		
	}

	private static void printStack(Stack<Integer> st) {
		while(!st.empty())
		{
			System.out.print(" "+st.pop());
		}
		
	}

	public static void main(String[] args) 
	{

		Node root = createTree();
		findMaxDiameterNode(root); // populates maxDiameter and maxDiameterNode
		//System.out.println(maxDiameter+" - "+ maxDiameterNode.data);
		//Now print the path having maxLeftHeight and maxRightHeight 
		printPath();
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
//second diagram in https://www.geeksforgeeks.org/print-longest-leaf-leaf-path-binary-tree/
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.left.right.left = new Node(9);
		root.left.left.right.left.right = new Node(12);
		root.left.right = new Node(5);
		root.left.right.right = new Node(8);
		root.left.right.right.left = new Node(10);
		root.left.right.right.right = new Node(11);
		root.left.right.right.right.left = new Node(13);
		
		root.right = new Node(3);
		
		
		return root;
	}

}
