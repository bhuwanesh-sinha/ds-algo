package matrix;

import utilities.Utilities;

public class SpiralTravel {
	static boolean right=true;
	static boolean down=true;
	static boolean left=true;
	static boolean up=true;
	static int i=0;
	static int j=0;
	static int pass=0;
	static int m=5;
	static int n=5;
	

	private static void printSpiral(int[][] arr) {
		
		if(right==false && left==false && up==false && down==false)
		{reset();}
		
	if(right==true && pass<=(j) && j<=(m-pass)){moveRight(arr);}
	else if(down==true && pass<=i && i<=(n-pass)){moveDown(arr);}
	else if(left==true && pass<=j && j<=(m-pass)){moveLeft(arr);}
	else if(up==true && pass<=i && i<=(n-pass)){moveUp(arr);}
	
	}

	private static void moveUp(int[][] arr) {
		System.out.print(arr[i--][j]+" "); 
		if(i<=(pass)) 
			up=false; 
		printSpiral(arr);
		
	}

	private static void moveLeft(int[][] arr) {
		System.out.print(arr[i][j--]+" "); 
		if(j<=pass)
			left=false; 
		printSpiral(arr);
		
	}

	private static void moveDown(int[][] arr) {
		System.out.print(arr[i++][j]+" "); 
		if(i>=(n-pass)) 
			down=false; 
		printSpiral(arr);
		
	}

	private static void moveRight(int[][] arr) {
		System.out.print(arr[i][j++]+" "); 
		if(j>=(m-pass)) 
			right=false;
		printSpiral(arr);
		
	}

	private static void reset() {
		right=true;
		down=true;
		left=true;
		up=true;
		pass++;
		i=pass;
		j=pass;
		
	}
	
	public static void main(String[] args) 
	{
		int[][] arr = {
				{0,1,2,3,4,5},
				{19,20,21,22,23,6},
				{18,31,32,33,24,7},
				{17,30,35,34,25,8},
				{16,29,28,27,26,9},
				{15,14,13,12,11,10}};
		
		Utilities.print2DArray(arr, 6, 6);
		System.out.println("\nSpiral travel is: -");
		printSpiral(arr);
	}
}
