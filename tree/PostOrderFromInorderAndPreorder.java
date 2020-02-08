package tree;

import java.util.HashMap;

public class PostOrderFromInorderAndPreorder {
	static int in[] = { 4, 2, 5, 1, 3, 6 }; 
	static  int pre[] = { 1, 2, 4, 5, 3, 6 };
	static int index=0;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	private static void printPostOrder(int start, int end)
	{
		if(start>end){return;}
		
		int ind = map.get(pre[index++]);
		printPostOrder(start, ind-1);
		printPostOrder(ind+1, end);
		System.out.print(in[ind]+" ");
	}

	public static void main(String[] args)
	{ 
         
        int len = in.length-1; 
         
        for(int i=0; i<in.length;i++)
        {map.put(in[i], i);}
        printPostOrder(0, len);
        
	}

	

}
