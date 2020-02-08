package sorting;



public class HeapSort {

	private static void buildHeap(int[] arr) {
		
		for(int i=(arr.length/2)-1;i>=0;i--)
		{
			heapify(arr,i, arr.length-1);
		}
		
	}

	private static void heapify(int[] arr, int i, int length) {
		
		int left = 2*i+1;
		int right = 2*i+2;
		int bigger = i;
		
		if(left<=length && arr[left]>arr[bigger] ){bigger = left;}  //left<length-1 put this condition first to avoid ArrayIndexOutOfBound check.
		
		if(right<=length && arr[right]>arr[bigger]  ){bigger = right;}
		
		if(!(i==bigger))
		{
			swap(arr, i, bigger);
			heapify(arr, bigger, length);
		}
	}
	
	private static void sort(int[] arr) {
		System.out.println();
		System.out.println("Now sorting by extraction..");
		int last = arr.length-1;
		
		while(last>0)
		 {
			 swap(arr, 0, last);
			 heapify(arr, 0, last-1);
			 last--;
		 }
		
	}

	private static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
		
	}

	private static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(" "+arr[i]);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,0,4,6,5,5,3,7,8,9}; //10 size
		//int[] arr = {2,1,0}; //10 size
		printArray(arr);
		buildHeap(arr);
		System.out.println();
		printArray(arr);
		sort(arr);
		System.out.println();
		printArray(arr);
		
	}
}
