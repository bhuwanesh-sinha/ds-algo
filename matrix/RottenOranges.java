package matrix;

public class RottenOranges {
	
	static int arr[][] = //all not rotten case
				{ {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
	
	/*static int arr[][] = //all rotten case
				{ 
				{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};*/
	
	static int rows = 3;
	static int col = 5;

	public static void main(String[] args) {

		boolean isAllRotten = true;
		
		int islandCount=0;
		for(int i=0; i<3; i++)
			for(int j=0; j<5; j++)
			{
				if(arr[i][j]==2){
					findIslands(i,j);
					islandCount++;
				}
					
			}
		//check if all are rotten
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(arr[i][j]>0)
				{
				isAllRotten=false; 
				break;
				}
				//System.out.print(" "+arr[i][j]);
			}
		System.out.println();
		}
					
		if(isAllRotten)
		System.out.println("time frame = "+islandCount);
		else
			System.out.println(-1);
	}

	private static void findIslands(int i, int j) {
		
		arr[i][j]=-1;
		
		if(isVisitable(i,j+1)){findIslands(i,j+1);}
		if(isVisitable(i+1,j)){findIslands(i+1,j);}
		if(isVisitable(i,j-1)){findIslands(i,j-1);}
		
	}

	private static boolean isVisitable(int i, int j) {
		if(!(i>=0 & i<rows) || !(j>=0&&j<col) || arr[i][j]==0 || arr[i][j]==-1)
			return false;
		else
			return true;
	}

}
