package matrix;

public class MatrixSpiralDiagonal {

	private static void printSpiral(int[][] arr) {
	
		boolean up=false;
		boolean down=true;
		int i=0;
		int j=0;
		
		while(up|| down)
		{
			if(up)
			{
				System.out.print(arr[i][j]);
				if(!isInRange(i-1,j+1, arr))
				{
					up=false;
					down=true;
					if(isInRange(i, j+1, arr)){j++;}
					else{i--;}
					continue;
				}
				else
				{
					i--;
					j++;
				}
			}	
			
			if(down)
			{
				System.out.print(arr[i][j]);
				if(!isInRange(i+1,j-1, arr))
				{
					down=false;
					up=true;
					if(isInRange(i+1, j, arr)){i++;}
					else{j++;}
					continue;
				}
				else
				{
					i++;
					j--;
				}
			}
		}
	
	}
	
	private static boolean isInRange(int i, int j, int[][] arr) {
		if(i>=0 && i<arr.length && j>=0 && j<arr.length)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[][] arr = {
				{1,3,4,10},
				{2,5,9,11},
				{6,8,12,15},
				{7,13,14,16}
		};
		
		printSpiral(arr);

	}

	

}
