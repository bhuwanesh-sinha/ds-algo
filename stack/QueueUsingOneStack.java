package stack;

import java.util.Stack;

public class QueueUsingOneStack {
	
	Stack<Integer> s = new Stack<Integer>();
	static int retVal=-1;
	
	void enqueue(int item ){s.push(item);}
	
	int dequeue(){
		
		if(s.isEmpty()){throw new RuntimeException("Stack is empty..");}
		
		if(s.size()==1){retVal= s.pop();}
		else
		{
			int e = s.pop();
			dequeue();
			s.push(e);
		}
		return retVal;
	}
	
	boolean hasNext(){return !s.isEmpty();}

	public static void main(String[] args) {
		QueueUsingOneStack q = new QueueUsingOneStack();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		while(q.hasNext()){System.out.println(q.dequeue());}
		//System.out.println(q.dequeue());
	}

}
