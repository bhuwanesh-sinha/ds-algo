package tree;

import java.util.HashMap;

public class TreeFromInOrderAndLevelOrder {

	static int[] in    = {4, 8, 10, 12, 14, 20, 22};
	static int[] level = {20, 8, 22, 4, 12, 10, 14};
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int index=0;
	
	static class Node{
		int data;
		Node left, right;
		Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	//magic starts here..
	private static void constructTree(Node node) {
		
		if(node==null){return;}
		
		if(hasLeftChild(node.data))
		{
			node.left=new Node(level[++index]);
			in[map.get(level[index])]=-1;
		}
		
		if(hasRightChild(node.data))
		{
			node.right=new Node(level[++index]);
			in[map.get(level[index])]=-1;
		}
		
		constructTree(node.left);
		constructTree(node.right);
		
		
	}
	
	private static boolean hasRightChild(int data) 
	{
		if(!(map.get(data)+1 >= in.length) && (in[map.get(data)+1] != -1)){return true;}
		else{return false;}
	}

	private static boolean hasLeftChild(int data) {
		if((!(map.get(data)-1 <= -1) && in[map.get(data)-1] != -1)){return true;}
		else{return false;}
	}

	public static void main(String[] args) {
		
		for(int i=0; i<in.length; i++)
		{
			map.put(in[i], i);
		}
		
		Node root = new Node(level[index]);
		in[map.get(level[index])]=-1;
		constructTree(root);
		System.out.println("done..");
		
	}

	

}
