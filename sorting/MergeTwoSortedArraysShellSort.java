package sorting;

public class MergeTwoSortedArraysShellSort {

	

	private static void mergeUsingShellSort(int[] arr1, int[] arr2) {
		int total_len = (arr1.length+arr2.length);
		int ctr1=-1, ctr2=-1;
		
		for(int gap = total_len/2; gap>=1; gap=gap/2)
		{
			for(int j=gap; j<total_len; j++)
			{
				for(int i=j-gap; i>=0; i=i-gap)
				{
					if(elementAt(arr1, arr2, i+gap)<elementAt(arr1, arr2, i))
						swap(arr1, arr2, i, i+gap);
				}
			}
		}
	}

	private static int elementAt(int[] arr1, int[] arr2, int i) {
		if(i<arr1.length)
			return arr1[i];
		else 
			return arr2[i-arr1.length];
	}
	
	private static void swap(int[] arr1, int[] arr2, int x, int y) {
		if(x<arr1.length && y<arr1.length)
		{
			int temp = arr1[x];
			arr1[x] = arr1[y];
			arr1[y] = temp;
		}
			
		if(x<arr1.length && y>=arr1.length)
		{
			int temp = arr1[x];
			arr1[x] = arr2[y-arr1.length];
			arr2[y-arr1.length] = temp;
		}
		
		if(x>=arr1.length && y>=arr1.length)
		{
			int temp = arr2[x-arr1.length];
			arr2[x-arr1.length] = arr2[y-arr1.length];
			arr2[y-arr1.length] = temp;
		}
	}

	private static void printArray(int[] arr) {
		for(int i:arr)
	    	System.out.print(" "+i);
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 9, 10, 15, 20};
	    int[] arr2 = {2, 3, 8, 13};
	    
	    printArray(arr1);
	    System.out.println();
	    printArray(arr2);
	    
	    mergeUsingShellSort(arr1, arr2);
	    System.out.println("\nafter sorting-");
	    
	    printArray(arr1);
	    System.out.println();
	    printArray(arr2);
	}

}
