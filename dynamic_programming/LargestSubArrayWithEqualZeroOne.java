package dynamic_programming;

public class LargestSubArrayWithEqualZeroOne {

	//Program to find maximum length of subarray containing equal no. of 0s and 1s
	private static void findMaximumLength(int[] arr) {
		//1. count total minimum count of 0s and 1s
		int zeros=0;
		int ones=0;
		int start=0;
		int end=0;
		
		int limit = findLimit(arr);
		
		//2. traverse the loop and check if limit is crossed in the window between f and l
		int f=0;
		int l=0;
		
		while(f<arr.length && l<arr.length)
		{
			if(zeros>limit || ones>limit) //3. if limit is crossed, leave trailing elements until balance is restored..
			{
				 if(arr[l]==0){zeros--;}
				 else{ones--;}
				 l++;
				 continue;
			}
			
			if(arr[f]==0){zeros++;}  //{1, 0, 0, 1, 0, 1, 1}
			else if(arr[f]==1){ones++;}
			
			//4. if at a point count of zeros and ones are equal, and the length of subarray is greater, mark it as a solution
			
			if(zeros==ones && (f-l)>(start-end)) {
				start=f;
				end=l;
			}
			f++;
		}
		
		System.out.println("start = "+start+" end = "+end);
		
	}
	private static int findLimit(int[] arr) {
		
		int zeros=0;
		int ones=0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]==0){zeros++;}
			if(arr[i]==1){ones++;}
		}
		return Math.min(zeros, ones);
	}
	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 1, 0, 1, 1}; //1 to 5
		//int arr[] = {1, 0, 1, 1, 1, 0, 0}; //1 to 6
		findMaximumLength(arr);

	}

	

}
