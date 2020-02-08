package sorting;
/*Program to form largest number from gives array elements by modifying merge sort..
 * */
public class FormLargestNumFromArrayElements {
	
	public static void sort(String[] arr, int l, int r){
		
		if(!(l<r))
			return;
		
		sort(arr, l, (l+r)/2);
		sort(arr, (l+r)/2+1, r);
		
		merge(arr, l, (l+r)/2, (l+r)/2+1, r);
		
	}

	private static void merge(String[] arr, int i, int j, int k, int l) {
		String[] temp1 = new String[j-i+1];
		String[] temp2 = new String[l-k+1];
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
			if((temp1[t1]+temp2[t2]).compareTo(temp2[t2]+temp1[t1]) > 0)
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
		String[] arr = {"1", "34", "3", "98", "4", "76", "45", "9"}; // 9 98 76 45 4 34 3 1
		sort(arr, 0, arr.length-1);
		printArray(arr);
	}

	private static void printArray(String[] arr) {
		for(int i=0;i<arr.length; i++)
			System.out.print(" "+arr[i]);
		
	}

}
