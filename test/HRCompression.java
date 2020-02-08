package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HRCompression {

	private static void compress(List<String> list, int i) {
		Stack<String> st = new Stack<String>();
		int count=1;
		
		for(String s: list)
		{
			if(st.isEmpty())
			if(!s.equals(st.peek())){st.push(s);}
			
			while()
			
		}
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("e");
		list.add("e");
		list.add("e");
		list.add("e");
		list.add("d");
		list.add("x");
		list.add("y");
		list.add("z");
		
		compress(list, 3);

	}

	

}
