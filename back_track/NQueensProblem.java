package back_track;

import java.util.HashSet;

class Position{
	int i, j;
	Position(int i, int j)
	{
		this.i=i; 
		this.j=j;
	}
}


public class NQueensProblem {
	static HashSet<Position> positions = new HashSet<Position>();
	static int[][] solution;
	static boolean foundSolution;
	static int QUEENS=4;
	static int count=0;
	
	static boolean isSafeMove(int x2, int y2)
	{
		int x1,y1;
		if(x2>=0 && x2<QUEENS && y2>=0 && y2<QUEENS)
		for(Position pos: positions)
		{
			x1 = pos.i;
			y1= pos.j;
			
			
			if(x1==x2 || y1==y2 || (x1+y1)== (x2+y2) ||(x1-y1)== (x2-y2))
			return false;
			
		}
		
		
		return true;
	}
	
	private static void solveNQUEENS(int x) {
		
		if(x>=QUEENS ||  foundSolution)
			return;
		Position pos=null;
		for(int i=0; i<QUEENS; i++)
		{
			if(isSafeMove(x, i))
			{
				solution[x][i]=1;
				pos = new Position(x,i);
				positions.add(pos);
				count++;
				solveNQUEENS(x+1);
				if(count==QUEENS)
				{
					printSolution();
					foundSolution=true;
				}
				positions.remove(pos);
				solution[x][i]=0;
				count--;
				
			}
			
		}
		
		
		
		return;
	}
	
	private static void printSolution() {
		for(int i=0; i<QUEENS; i++)
		{
			for(int j=0; j<QUEENS; j++)
				System.out.print(" "+solution[i][j]);
		System.out.println();
		}
				
		
	}

	public static void main(String[] args) {
		solution = new int[QUEENS][QUEENS];
		for(int i=0; i<QUEENS; i++)
		{
			for(int j=0; j<QUEENS; j++)
				solution[i][j]=0;
		}
		
		solveNQUEENS(0);
	}



	

}
