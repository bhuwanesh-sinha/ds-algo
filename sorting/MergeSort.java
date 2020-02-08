package sorting;

public class MergeSort {
	
	public static void sort(int[] arr, int l, int r){
		
		sort(arr, l, (l+r)/2);
		sort(arr, (l+r)/2+1, r);
		
		merge(arr, l, (l+r)/2, (l+r)/2+1, r);
		
	}

	private static void merge(int[] arr, int i, int j, int k, int l) {
		int[] temp1 = new int[j-i+1];
		int[] temp2 = new int[l-k+1];
		int t1=0;
		int t2=0;
		
		for(int x=i; x<=j; x++)
		{
			temp1[t1]=arr[x];
			t1++;
		}
		
		for(int x=k; x<=l; x++)
		{
			temp2[t2]=arr[x];
			t2++;
		}
		
		t1=0;
		t2=0;
		int x=i;
		while( t1<temp1.length && t2<temp2.length)
		{
			if(temp1[t1] < temp2[t2])
			{
				arr[x]=temp1[t1];
				t1++;
				x++;
			}
			else
			{
				arr[x]=temp2[t2];
				t2++;
				x++;
			}
		}
		
		if(t1<temp1.length)
		{
			while(t1<temp1.length)
			{
				arr[x]=temp1[t1];
				t1++;
				x++;
			}
		}
		else{
			while(t2<temp2.length)
			{
				arr[x]=temp2[t2];
				t2++;
				x++;
			}
		}
			
	}

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		MergeSort.sort(arr, 0, arr.length-1);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i=0;i<arr.length; i++)
			System.out.print(" "+arr[i]);
		
	}

}
