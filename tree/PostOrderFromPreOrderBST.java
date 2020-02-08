package tree;

import java.util.Stack;
/*use range logic.. at every step check in next element has a child or not
 * if yes, then recurse for it
 * if it dont has any child then simply print it*/
public class PostOrderFromPreOrderBST {
	
	static int[] pre = {100, 90, 80, 70, 85, 95, 200, 150, 300};
	static int index = 0;
	static Stack<Integer> st = new Stack<Integer>();
	
	static void printPostOrder(int start,int element, int end){
		if(index>=pre.length){return;}
		
		if((index+1)<pre.length && start<pre[index+1] && pre[index+1]<element)
		{
			printPostOrder(start, pre[++index], element);
		}
		
		if((index+1)<pre.length && element<pre[index+1] && pre[index+1]<end)
		{
			printPostOrder(element, pre[++index], end);
		}
		
		System.out.print(" "+element);
	}
	
	public static void main(String[] args) {
		int element = pre[index];
		//st.push(element);
		printPostOrder(Integer.MIN_VALUE, element, Integer.MAX_VALUE);

	}

}
