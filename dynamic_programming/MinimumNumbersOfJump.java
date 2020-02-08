package dynamic_programming;

public class MinimumNumbersOfJump {

	private static int findMinimumJumps(int[] arr) {
		int jumps=0;
		int steps=arr[0];
		int globalSteps=arr[0];
		int max=arr[0];
		int max_index = 0;
		
		for(int i=1; i<arr.length; i++)
		{
			if(i>=(arr.length-1))
				return jumps+1;
			steps--;
			
			if(steps<0) //no jump possible
				break;
			
			if(steps<arr[i] && arr[i]>max)
			{
				max = arr[i];
				max_index = i;
				System.out.println("Max - "+max);
			}
			
			if(steps==0)
			{
				steps=max-(i-max_index);
				jumps++;
				max=0;//reset max
			}
		}
		return jumps;
	}
	
	public static void main(String[] args) {
		//int arr[] = {2,3,1,1,2,4,2,0,1,1};
		int arr[] ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//int arr[] = {2,9,3,1,2,4,3,2,1,1};
		System.out.println("Maximum no.of jumps required = "+findMinimumJumps(arr));

	}

	

}
