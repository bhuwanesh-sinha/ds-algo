package test;

public class AmazonTest2 {

	static int[] iMove = {0,0,1,-1};
	static int[] jMove = {1,-1,0,0};
	static boolean[][] visited;

	private static void updateServer(int i, int j, int row, int col, int[][] mat) {
		
		for(int m=0; m<iMove.length; m++)
		{
			if (validCell(i+iMove[m], j+jMove[m], row, col, mat)) 
			{
				mat[i+iMove[m]][j+jMove[m]]=1;
			}
		}

	}


private static boolean validCell(int i, int j, int row, int col, int[][] mat) {
	if(i>=0 && j>=0 && i<row && j<col && mat[i][j]==0)
		return true;
	else 
		return false;
}

public static void main(String[] args) {
		
		int count=0;
		int row=4;
		int col=5;
		int[][] mat = {
				{0, 1, 1, 0, 1},
				{0, 1, 0, 1, 0},
				{0, 0, 0, 0, 1},
				{0, 1, 0, 0, 0}
		};
		visited = new boolean[row][col];
		while(!isAllUpdated(row, col, mat))
		{
			count++;
			System.out.println("Day: "+count);
			
			updateVisited(row, col, mat);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if(mat[i][j]==1 && visited[i][j]==true)
					updateServer(i, j, row, col, mat);
				}
			}

		}
		System.out.println(count);

	}
	private static void updateVisited(int row, int col, int[][] mat) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(mat[i][j]==1)
				visited[i][j]=true;
				else
					visited[i][j]=false;
			}
		}
	
}

	private static boolean isAllUpdated(int row, int col, int[][] mat) {
		for(int i=0; i<row;i++)
		{
			for(int j=0; j<col;j++)
			{
				if(mat[i][j]==0)
				{
					return false;
				}
			}
		}
		return true;
	}

}
