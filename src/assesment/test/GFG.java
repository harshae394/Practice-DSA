package assesment.test;

// Java program to find the
// minimum sum of multiplication
// of n numbers
import java.io.*;
import java.math.*;
import java.util.LinkedList;
import java.util.Queue;

class GFG {

    // Used in recursive
    // memoized solution
    static long dp[][] = new long[1000][1000];

    // function to calculate the
    // cumulative sum from a[i] to a[j]
    static long sum(int a[], int i, int j) {
	long ans = 0;
	for (int m = i; m <= j; m++)
	    ans = (ans + a[m]) % 100;
	return ans;
    }

    static long solve(int a[], int i, int j) {
	// base case
	if (i == j)
	    return 0;

	// memoization, if the partition
	// has been called before then
	// return the stored value
	if (dp[i][j] != -1)
	    return dp[i][j];

	// store a max value
	dp[i][j] = 100000000;

	// we break them into k partitions
	for (int k = i; k < j; k++) {
	    // store the min of the
	    // formula thus obtained
	    dp[i][j] = Math.min(dp[i][j], (solve(a, i, k) + solve(a, k + 1, j) + (sum(a, i, k) * sum(a, k + 1, j))));
	}

	// return the minimum
	return dp[i][j];
    }

    static void initialize(int n) {
	Queue<String> qq = new LinkedList<String>();
	for (int i = 0; i <= n; i++)
	    for (int j = 0; j <= n; j++)
		dp[i][j] = -1;
    }

    // Driver code
    public static void main(String args[]) {
	int a[] = { 134 };
	int n = a.length;
	initialize(n);
	System.out.println(solve(a, 0, n - 1));

    }
}

/* This code is contributed by Nikita Tiwari. */
