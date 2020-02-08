package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dynamic_programming.SieveOfEratosthenesPrimeNumbers;

public class ShortestPathTwoPrimeNumbers {
	static Graph g;
	//find all prime numbers from 1 to 4 digits
		private static ArrayList<Integer> findPrimeNumbers(int digits) {
			// TODO Auto-generated method stub
			return null;
		}


	public static void main(String[] args) {
		int num=9999;
		g = new Graph(num);
		
		ArrayList<Integer> primeNumbers = getPrimeNumOf4Digits(num);
		
		for(Integer i : primeNumbers)
		{
			for(Integer j : primeNumbers)
			{
				if(digitDifferenceIsOne(i, j))
					g.addEdge(i, j);
			}
		}
		
		printShortestPath(1033, 8179);
		
	}


	private static void printShortestPath(int i, int j) {
		List<Integer> list = g.adj[i];
		boolean[] visited = new boolean[g.V];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		map.put(i, null);
		visited[i]=true;
		
		while(!q.isEmpty())
		{
			Integer parent = q.poll();
			List<Integer> l=g.adj[parent];
			for(Integer item: l)
			{
				if(!visited[item])
				{
					q.add(item);
					map.put(item, parent);
					visited[item]=true;
				}
				
				if(item==j)
				{
					printPath(item, map);
					return;
				}
				
			}
			
		}
	}


	private static void printPath(Integer item, HashMap<Integer, Integer> map) {
		System.out.print(" "+item);
		if(map.get(item)!=null)
		printPath(map.get(item), map);
	}


	private static boolean digitDifferenceIsOne(Integer a, Integer b) {
		int count=0;
		char[] arr1 = Integer.toString(a).toCharArray();
		char[] arr2 = Integer.toString(b).toCharArray();
		
		for(int i=0; i<arr1.length; i++)
		{
			if(arr1[i]!=arr2[i]){count++;}
		}
		
		if(count==1)
		return true;
		
		return false;
	}


	private static ArrayList<Integer> getPrimeNumOf4Digits(int num) {
		ArrayList<Integer> primeNumbers=SieveOfEratosthenesPrimeNumbers.getPrimeNumbers(num);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for(Integer i: primeNumbers)
			if(i>1000){primes.add(i);}
		
		return primes;
	}

	
}
