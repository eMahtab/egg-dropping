package net.mahtabalam.recursive;

public class EggDropping { 
	
	public static void main(String args[]) 
	{ 
		int n = 2, m = 11; 
		System.out.print("Minimum number of " + "drops in worst case with " + n + " eggs and " + m 
		 + " floors is " + eggDrop(n, m)); 
	} 
	
	/* Function to get minimum number of attempts needed in worst case with n eggs and m floors */
	public static int eggDrop(int n, int m) 
	{ 
		System.out.println("eggDrop("+n+" , "+m+")");
		// If there are no floors, then no drops needed. OR if there is only one floor, then one drop needed. 
		if (m == 1 || m == 0) 
			return m; 
	
		// We need m trials for one egg and m floors 
		if (n == 1) 
			return m; 
	
		int minimumDrops  = Integer.MAX_VALUE; 
		int x, result; 
	
		// Consider all droppings from 1st  floor to mth  floor  and return the minimum of these values plus 1. 
		for (x = 1; x <= m; x++) 
		{ 
			result = Math.max(eggDrop(n-1, x-1), eggDrop(n, m-x)); 
			if (result < minimumDrops ) 
				minimumDrops  = result; 
		} 
	
		return minimumDrops  + 1; 
	} 
	
} 
