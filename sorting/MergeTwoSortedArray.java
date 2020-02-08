package sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    
      
    static void rearrange(int[] arr1, int[] arr2) 
    { 
    	int i=0; //pointer for arr1
    	int j=0; //pointer for arr2
    	int k=arr1.length-1; //pointer for arr1's last element
    	
    	/*1. start from first element of both arrays i.e. i=0 & j=0
    	 *2. check if arr2's current element is less than arr1's current element
    	 *3. if yes, exchange it with the last element of arr1
    	 *4. else move forward in arr1
    	 *5. At last, all the smaller elements are in first array
    	 *5. Finally sort both the arrays
    	 * */
        for (int ctr=0; ctr<arr1.length; ctr++) 
        {
        	if(arr2[j]<arr1[i])
        	{
        		int temp = arr1[k];
        		arr1[k] = arr2[j];
        		arr2[j] = temp;
        		k--;
        		j++;
        	}
        	else {i++;}
        } 
    } 
    
    private static void printArray(int[] arr) {
    	System.out.println();
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(" "+arr[i]);
		}
		
	}
      
    
    
    // Driver method to test the above function 
    public static void main(String[] args)  
    {  int[] arr1 = new int[]{1, 5, 9, 10, 15, 20}; 
       int[] arr2 = new int[]{2, 3, 8, 13};
       printArray(arr1);
       printArray(arr2);
       
       rearrange(arr1, arr2);
       System.out.println("After merge - \n");
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       printArray(arr1);
       printArray(arr2);
    } }
