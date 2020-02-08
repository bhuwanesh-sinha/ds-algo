package test;

public class OverloadingConcept {
	
	void m(int i){System.out.println("int version");}
	
	//void m(Integer i){System.out.println("Integer version");}
	
	void m(Long i){System.out.println("Long version");}
	
	void m(float i){System.out.println("float version");}
	
	void m(long i){System.out.println("long version");}
	
	void m(double i){System.out.println("double version");}
	
	//void m(Object i){System.out.println("Object version");}
	
	//void m(String i){System.out.println("String version");}
	
	public static void main(String[] args){
		
		OverloadingConcept test = new OverloadingConcept();
		test.m(1);
	}
}
