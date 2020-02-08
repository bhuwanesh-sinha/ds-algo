package back_track;

import java.util.Arrays;
//int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
//int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
public class KnightsTour {

	static int[] xmove= {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] ymove= {1, 2, 2, 1, -1, -2, -2, -1};
	static int[][] solution;
	static boolean foundSolution;
	static int path=1;
	static int visitedCount = 1;
	static int solNo=1; 
	
	static boolean isSafeMove(int x, int y)
	{
		if(x>=0 && x<xmove.length && y>=0 && y<ymove.length)
		{
			if(solution[x][y]==-1)
				return true;
		}
		
		return false;
	}
	
	private static void solveTKUtil(int x, int y) {
		for(int i=0; i<xmove.length; i++)
		{
			if(isSafeMove(x+xmove[i], y+ymove[i]))
			{
				solution[x+xmove[i]][y+ymove[i]]=path++;
				visitedCount++;
				solveTKUtil(x+xmove[i], y+ymove[i]);
				solution[x+xmove[i]][y+ymove[i]]=-1;
				visitedCount--;
				path--;
			}
			
		}
		
		if(visitedCount==64)
		printSolution();
		
		return;
	}
	
	private static void printSolution() {
		System.out.println("\nsolution No:- "+solNo++);
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
				System.out.print(" "+solution[i][j]);
		System.out.println();
		}
				
		
	}

	public static void main(String[] args) {
		solution = new int[8][8];
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
				solution[i][j]=-1;
		}
		solution[0][0]=path++;
		solveTKUtil(0,0);
	}



	

}
