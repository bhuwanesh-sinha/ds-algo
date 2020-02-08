package sorting;

import java.util.Arrays;

public class FindInversionsUsingMergeSort {
	
	static int swaps = 0;

	public static void main(String[] args) {

		int[] arr = { 1, 20, 6, 4, 5 };
		printArray(arr);
		sort(arr, 0, arr.length-1);
		printArray(arr);
		
		System.out.println("\nTotal inversions = "+swaps);
	}

	private static void sort(int[] arr, int l, int r) {
		
		if(l>=r){return;}
		
		int mid = (l+r)/2;
		
		sort(arr, l, mid);
		sort(arr, mid+1, r);
		merge(arr, l, mid, r);
		
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] left = Arrays.copyOfRange(arr, l, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, r+1);
		int lctr=0, rctr=0, k=l;
		 
		while((lctr<left.length) && (rctr<right.length))
		{
			if(left[lctr] <= right[rctr])
			{
				arr[k] = left[lctr];
				k++; lctr++;
			}
			else
			{
				arr[k] = right[rctr];
				k++; rctr++;
				//if lower element is picked from right sub-array
				swaps = swaps+(left.length-lctr);
			}
		}
		
		while(lctr < left.length) //remaining elements
		{
			arr[k] = left[lctr];
			k++; lctr++;
		}
		
		while(rctr < right.length) //remaining elements
		{
			arr[k] = right[rctr];
			k++; rctr++;
		}
	}

	private static void printArray(int[] arr) {
		System.out.println();
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(" "+arr[i]);
		}
		
	}
}
