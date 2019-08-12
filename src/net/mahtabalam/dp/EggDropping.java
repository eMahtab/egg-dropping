package net.mahtabalam.dp;


class EggDropping 
{ 
	public static void main(String args[] ) 
	{ 
		int n = 3, m = 100; 
		System.out.println("Minimum number of attempts in worst case with "+n+" eggs and "+m+ 
				" floors is "+eggDrop(n, m)); 
	} 
	
	/* Function to get minimum number of attempts needed in worst case with n eggs and m floors */
	public static int eggDrop(int n, int m) 
	{ 
	    //A 2D array where dpTable[i][j] will represent minimum number of attempts needed for i eggs and j floors.
		int dpTable[][] = new int[n+1][m+1]; 
		int result; 
		int i, j, x; 
		
		// We need one attempt for one floor and 0 attempt for 0 floors 
		for (i = 1; i <= n; i++) 
		{ 
			dpTable[i][1] = 1; 
			dpTable[i][0] = 0; 
		} 
		
	    // We will need j attempts when we have only one egg and j floors. 
		for (j = 1; j <= m; j++) 
			dpTable[1][j] = j; 
		
		
		for (i = 2; i <= n; i++) 
		{ 
			for (j = 2; j <= m; j++) 
			{ 
				dpTable[i][j] = Integer.MAX_VALUE; 
				for (x = 1; x <= j; x++) 
				{ 
					result = 1 + Math.max(dpTable[i-1][x-1], dpTable[i][j-x]); 
					if (result < dpTable[i][j]) 
						dpTable[i][j] = result; 
				} 
			} 
		} 
		
		return dpTable[n][m]; 
	} 
} 
