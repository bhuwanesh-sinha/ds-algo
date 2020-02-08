package test;

public class AmazonTest1 {
	static boolean[][] visited;
    static int[] iMove = {0, 0, 1, -1};
    static int[] jMove = {1, -1, 0, 0};
    
    static boolean isSafeMove(int[][] mat, int i, int j, int rows, int columns)
    {
        
        if(i<rows && j<columns && i>=0 && j>=0)
        {
            if(!visited[i][j] && mat[i][j]==1)
            return true;
        }
        
        return false;
        
    }
    
	static void findTT(int[][] mat,int i, int j, int rows, int columns)
    {
        visited[i][j]=true;
        //System.out.println(i+" === "+j);
        for(int k=0; k<iMove.length; k++)
        {
            //System.out.println(i+"--"+j);
            if(isSafeMove(mat, i+iMove[k], j+jMove[k], rows, columns))
            findTT(mat, i+iMove[k], j+jMove[k], rows, columns);
        }
    }
    
    static int numberAmazonTreasureTrucks(int rows, int column, int[][] mat)
    {
        int count=0;
       
        visited = new boolean[rows][column];
        
        
        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<column; j++)
            {
                if(mat[i][j]==1 && !visited[i][j])
                {
                    findTT(mat, i, j,rows, column);
                    count=count+1;
                    //System.out.println("count = "+count);
                }
            }
        }
    //System.out.println(count);
    return count;
    }
    
    public static void main(String[] args)
    {
    	int[][] arr = {
    			{1,1,0,0},
    			{0,0,0,0},
    			{0,0,1,1},
    			{0,0,0,0}
    	};
    	System.out.println(numberAmazonTreasureTrucks(4,4,arr));
    }
}
