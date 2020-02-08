package linked_list;

import java.util.LinkedList;
import java.util.Queue;

import utilities.BinaryTree.Node;

public class LinkedListToBinaryTree {
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data=data;
			this.next=null;
		}
		
		ListNode push(int data)
		{
			ListNode node = new ListNode(data);
			this.next=node;
			return this.next;
		}
	}
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
			left=right=null;
		}
	
	}

	public static void main(String[] args) {
		

		ListNode head = new ListNode(0);
		head.push(1).push(2).push(3).push(4).push(5).push(6).push(7).push(8);
		TreeNode root=convertToTree(head);
		System.out.println("\ninorder traversal of tree - \n");
		levelOrderTraversalUsingQueue(root);
		
	}

	private static TreeNode convertToTree(ListNode head) {
		
		if(head==null){return null;}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(head.data);
		q.add(root);
		head = head.next;
		
		while(head!=null)
		{
			TreeNode parent = q.poll();
			
			TreeNode leftChild=new TreeNode(head.data);
			parent.left = leftChild;
			q.add(leftChild);
			head = head.next;
			
			TreeNode rightChild=new TreeNode(head.data);
			q.add(rightChild);
			parent.right = rightChild;
			head = head.next;
			
		}
		
		
		return root;
	}
	
	private static void inOrderTraversal(TreeNode root) {
		
		if(root==null){return;}
		
		inOrderTraversal(root.left);
		
		System.out.print(" "+root.data);
		
		inOrderTraversal(root.right);
		
	}
	
private static void levelOrderTraversalUsingQueue(TreeNode root) {
	
	if(root==null){return;}
	
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	
	q.add(root);
	
	while(q.peek()!=null)
	{
		System.out.print(" "+q.peek().data);
		q.add(q.peek().left);
		q.add(q.peek().right);
		q.poll();
		
	}
}

}
