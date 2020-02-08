package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesPrimeNumbers {
	
	public static ArrayList<Integer> getPrimeNumbers(int num)
	{
		boolean[] isPrime = new boolean[num];
		int[] primes = new int[num];
		
		for(int i=2; i<num; i++) 
		{primes[i]=(i);}
		
		Arrays.fill(isPrime, true);
		
		for(int i=2; i<num; i++)
		{
			if(isPrime[i])
			for(int j=i*i; j<num; j=j+i)
			{
				isPrime[j]=false;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<=num-2; i++)
		{
			if(isPrime[i] && primes[i]!=0)
			list.add(primes[i]);
		}
		
		return list;
	}

	
	public static void main(String[] args) {

		List<Integer> list = getPrimeNumbers(99);
		for(Integer i : list)
			System.out.print(" "+i);
	}

}
