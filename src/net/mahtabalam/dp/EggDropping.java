package net.mahtabalam.dp;


class EggDropping 
{ 
	public static void main(String args[] ) 
	{ 
		int n = 3, m = 100; 
		System.out.println("Minimum number of attempts in worst case with "+n+" eggs and "+m+ 
				" floors is "+eggDrop(n, m)); 
	} 
	
	/* Function to get minimum number of attempts needed in worst 
	case with n eggs and m floors */
	static int eggDrop(int n, int m) 
	{ 
	/* A 2D table where entery eggFloor[i][j] will represent minimum 
	number of trials needed for i eggs and j floors. */
		int eggFloor[][] = new int[n+1][m+1]; 
		int result; 
		int i, j, x; 
		
		// We need one trial for one floor and0 trials for 0 floors 
		for (i = 1; i <= n; i++) 
		{ 
			eggFloor[i][1] = 1; 
			eggFloor[i][0] = 0; 
		} 
		
	// We always need j trials for one egg and j floors. 
		for (j = 1; j <= m; j++) 
			eggFloor[1][j] = j; 
		
		// Fill rest of the entries in table using optimal substructure 
		// property 
		for (i = 2; i <= n; i++) 
		{ 
			for (j = 2; j <= m; j++) 
			{ 
				eggFloor[i][j] = Integer.MAX_VALUE; 
				for (x = 1; x <= j; x++) 
				{ 
					result = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]); 
					if (result < eggFloor[i][j]) 
						eggFloor[i][j] = result; 
				} 
			} 
		} 
		
		return eggFloor[n][m]; 

	} 
		
	
} 
