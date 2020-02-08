package utilities;

public class Utilities {
	
	

	public static void main(String[] args) {
		int[][] arr = {
				{0,1,2,3,4,5},
				{19,20,21,22,23,6},
				{18,31,32,33,24,7},
				{17,30,34,35,25,8},
				{16,29,28,27,26,9},
				{15,14,13,12,11,10}};
		
		print2DArray(arr,6,6);

	}
	
	public static void printIntegerArray(int[] arr){
		for(int i=0; i<arr.length;i++)
			System.out.print(" "+arr[i]);
	}

	public static void print2DArray(int[][] arr, int rows, int columns) {
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<columns; j++)
			{
				System.out.print(String.format("%02d",arr[i][j])+" ");
			}
		System.out.println();
			
		}
		
	}

}
