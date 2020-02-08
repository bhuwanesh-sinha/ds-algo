package stack;

import utilities.Utilities;

public class FindMaximumMinimumOfWindow {
	
	private static void findMaximumMinimumOfWindow(int[] arr) {
		int last = arr.length-1;
		int max=arr[0];
		while(last>0)
		{
			for(int i=0; i<=(last-1); i++)
			{
				arr[i]=Math.min(arr[i], arr[i+1]);
				if(arr[i+1]>max){max=arr[i+1];}
			}
			
			arr[last--]=max;
			max=Integer.MIN_VALUE;
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 50, 10, 70, 30};
		findMaximumMinimumOfWindow(arr);
		for(int i=arr.length-1;i>=0;i--)
			System.out.print(" "+arr[i]);

	}

	

}
