package range_queries;
/*SegmentTree is used to query a range in an array in log:n time
 * ex - find minimum from {1, 3, 2, 7, 9, 11} in range (0,3)
 * o/p = 1
 * 1is minimum among (1, 3, 2, 7)*/
public class SegmentTree {

	public static void main(String[] args) {
		
		int arr[] = {1, 3, 2, 7, 9, 11};
		
		constructSegmentTree(arr);

	}

	private static void constructSegmentTree(int[] arr) {
		
		int lengthST = getPerfectSquare(arr);
		
	}

	//get perfect square bigger than or equal to arr.length
	private static int getPerfectSquare(int[] arr) {
		int sqr = 1;
		int oddNums = 1;
		while(arr.length <= sqr)
		{
			sqr+= (oddNums+2);
		}
		return 0;
	}

}
