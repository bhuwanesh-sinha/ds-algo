package matrix;

import utilities.Utilities;

public class RotateMatrixByK {
	static boolean right=true;
	static boolean down=true;
	static boolean left=true;
	static boolean up=true;
	static int i=0;
	static int j=0;
	static int pass=0;
	static int m=5;
	static int n=5;
	static int k=4;//amount by which to rotate..
	

	private static void rotate(int[][] arr, int num) {
		
		if(right==false && left==false && up==false && down==false)
		{reset();}
		
	if(right==true && pass<=(j) && j<=(m-pass)){moveRight(arr, num);}
	else if(down==true && pass<=i && i<=(n-pass)){moveDown(arr, num);}
	else if(left==true && pass<=j && j<=(m-pass)){moveLeft(arr, num);}
	else if(up==true && pass<=i && i<=(n-pass)){moveUp(arr,  num);}
	
	}

	private static void moveUp(int[][] arr, int num) {
		k--;
		int temp=0;
		if(k==1)
		{
			temp = arr[i][j];
			arr[i][j]=num;
			
		}
			
		i--;
		
		if(i<(pass)) 
			up=false; 
		rotate(arr, temp);
		
	}

	

	private static void moveLeft(int[][] arr, int num) {
		k--;
		int temp = 0;
		if(k==1)
		{
			temp = arr[i][j];
			arr[i][j]=num;
		}
		j--;
		if(j<=pass)
			left=false; 
		rotate(arr, temp);
		
	}

	private static void moveDown(int[][] arr, int num) {
		k--;
		int temp = 0;
		if(k==1)
		{
		temp = arr[i][j];
		arr[i][j] = num;
		}
		i++;
		if(i>=(n-pass)) 
			down=false; 
		rotate(arr, temp);
		
	}

	private static void moveRight(int[][] arr, int num) {
		k--;
		int temp = 0;
		if(k==1)
		{
		temp=arr[i][j];
		arr[i][j]=num;
		}
		j++;
		if(j>=(m-pass)) 
			right=false;
		rotate(arr,temp);
		
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
				{17,30,34,35,25,8},
				{16,29,28,27,26,9},
				{15,14,13,12,11,10}};
		
		Utilities.print2DArray(arr, 6, 6);
		rotate(arr, arr[0][0]);
		System.out.println("\nAfter rotate - \n");
		Utilities.print2DArray(arr, 6, 6);
		
	}
}
