package tree;

public class CreateTreeFromString {
	static char[] pre = "nlnnlll".toCharArray(); //pre-order traversal string, l=leaf, n=node
	static int index = 0;
	static int maxDepth = 0;
	static class Node{
		char data;
		Node left, right;
		Node(char data)
		{
			this.data=data;
			left=right=null;
		}
	}
	
	private static Node createTree(char c, int depth) { // depth to calculate depth..
		
		if(depth>maxDepth){maxDepth=depth;}
		
		if(index>pre.length){return null;}
		if(c=='l')
		{return new Node('l');}
		
		Node root = new Node(c);
		
		if(!(index>=pre.length))
		root.left=createTree(pre[++index], depth+1);
		
		if(!(index>=pre.length))
		root.right=createTree(pre[++index], depth+1);
		
		return root;
	}

	public static void main(String[] args) {
		
		
		Node root = createTree(pre[index], 0);
		System.out.println("MaxDepth = "+maxDepth);
	}

	

}
