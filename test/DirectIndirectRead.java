package test;

public class DirectIndirectRead {

	
	static{
		m1();
		//System.out.println(i);  //commeny/uncomment this
	}
	
	public static void m1(){
		
		System.out.println(i);
		
	}
	
	static int i=10;
	
	public static void main(String[] args){}
	

}
