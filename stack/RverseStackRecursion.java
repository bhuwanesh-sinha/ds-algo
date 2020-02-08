package stack;

import java.util.Stack;

public class RverseStackRecursion {
	static Stack<String> st = new Stack<String>();
	static boolean reverse = true;
	
	static void recursiveProcess() {
	
		if(st.isEmpty()){return;}
		
		String e = st.pop();
		recursiveProcess();
		//sortStack(e);   //comment/uncomment the functionality..
		pushDown(e);
		
		
	}
	
private static void pushDown(String e) {
		
		if(st.isEmpty()){st.push(e); return;}
		
		String e2 = st.pop();
		pushDown(e);
		st.push(e2);
		
	}

	private static void sortStack(String e) {
		
		if(st.isEmpty()){st.push(e); return;}
		
		else if(e.compareTo(st.peek())<0){
			String e2 = st.pop();
			sortStack(e);
			st.push(e2);
		}
		
		else{st.push(e);}
		
	}
	
	
	private static void recPrintStack() {
		if(st.isEmpty()){return;}
		
		String item = st.pop();
		recPrintStack();
		System.out.print(" "+item);
		st.push(item);
	}
	
	public static void main(String[] args) {
		st.push("Z");
		st.push("D");
		st.push("E");
		st.push("F");
		st.push("A");
		st.push("B");
		st.push("C");
		
		recPrintStack();
		recursiveProcess();
		System.out.println();
		recPrintStack();
		

	}

	
	

}
