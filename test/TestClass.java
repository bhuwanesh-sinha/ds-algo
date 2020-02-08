package test;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class TestClass {
	public static void badMethod(){}
	public static void main(String[] args) 
    {
		try{
			badMethod();
			System.out.println("A");
		}
		catch(Exception e){System.out.println("B");}
		finally{System.out.println("C");}
		System.out.println("D");
    } 
}

