package tree;

import utilities.BinaryTree;
import utilities.BinaryTree.Node;

public class LowestCommonAncestor {
	
	static Node LCA;
	
	
	private static boolean findLCA(Node node, int i, int j)
	{
		if(node==null){return false;}
		
		if(node.data==i || node.data==j){return true;}
		
		boolean foundInLeft = findLCA(node.left, i, j);
		boolean foundInRight = findLCA(node.right, i, j);	
		
		if(foundInLeft && foundInRight){LCA=node;}
		
		return (foundInLeft || foundInRight);
		
	}

	
	public static void main(String[] args) {
		BinaryTree.Node root = BinaryTree.createTree2();
		
		if(findLCA(root, 8, 1) && LCA!=null) //LCA!=null check for parameter 1 i.e. root
		System.out.println(LCA.data);
		else
		System.out.println("LCA not found!!");
	}

	

}
