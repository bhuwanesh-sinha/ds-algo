package stack;

import java.util.Stack;

/* A special stack having peek() pop() and push() along with additional getMin()
 * that returns minimum value in a stack without using extra space and all
 * operations in O(1) time.. :)
 * */
public class SpecialStack {
	
	int min=Integer.MAX_VALUE;
	Stack<String> st = new Stack<String>();
	
	void getMin(){System.out.println("min is: "+min);}
	
	void push(Integer i)
	{
		if(st.isEmpty()){min=i;}
		
		if(i<min)
		{ st.push(min+"X"); //encode and push
			min=i;
			return;
		}
		
		st.push(i.toString());
	}
	
	

	void pop()
	{
		String e = st.pop();
		if(e.charAt(e.length()-1)=='X')
		{
			System.out.println(min);
			min = Integer.parseInt(e.substring(0, e.length()-1));
		}
		else
		{
			System.out.println(e);
		}
	}
	
	void peek()
	{
		String e = st.peek();
		
		if(e.charAt(e.length())=='X') {System.out.println(e.substring(0, e.length()-2));}
		
		else {System.out.println(e);}
		
	}

	
	public static void main(String[] args) {
		SpecialStack s = new SpecialStack();
		s.push(3);
		s.getMin();
		s.push(2);
		s.getMin();
		s.push(6);
		s.getMin();
		s.push(1);
		s.getMin();
		s.push(8);
		s.getMin();
		s.push(5);
		s.getMin();  //3 2 6 1 8 5 <--
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		

	}

}
