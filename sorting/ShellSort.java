package sorting;

public class ShellSort {
	
	private static void shellSort(int[] arr) {
		for(int gap=arr.length/2; gap>=1; gap=gap/2 )
		{
			for(int j=gap; j<arr.length; j++)
			{
				for(int i=j-gap; i>=0; i=i-gap)
				{
					if(arr[i+gap]<arr[i])
						swap(arr, i+gap, i);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		int[] arr = {9,6,8,7,3,4,5,2,1};
		for(int i: arr)
		{
			System.out.print(" "+i);
		}
		System.out.println();
		shellSort(arr);
		for(int i: arr)
		{
			System.out.print(" "+i);
		}
	}

	

}
