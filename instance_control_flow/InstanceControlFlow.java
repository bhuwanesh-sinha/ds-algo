package instance_control_flow;

import java.util.ArrayList;

public class InstanceControlFlow {
	int i=10;
	ArrayList l;
	{
		m1();
		System.out.println("First Instance Block..");
	}
	
	InstanceControlFlow(){
		System.out.println("Constructor..");
	}

	
	public static void main(String[] args) {
		InstanceControlFlow o = new InstanceControlFlow();
		System.out.println("Main method..");

	}

	public void m1(){
		System.out.println("j = "+j);
	}

	{
		System.out.println("Second Instance Block..");
	}
	
	int j=20;
}
