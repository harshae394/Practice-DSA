package DPpracticetest;

// Fibonacci Series using Dynamic Programming
class fibonacci {
    static long fib(int n) {
	/* Declare an array to store Fibonacci numbers. */
	long f[] = new long[n + 2]; // 1 extra to handle case, n = 0
	int i;
	/* 0th and 1st number of the series are 0 and 1 */
	f[0] = 0;
	f[1] = 1;

	for (i = 2; i <= n; i++) {
	    /*
	     * Add the previous 2 numbers in the series and store it
	     */
	    f[i] = f[i - 1]%1000000009 + f[i - 2]%1000000009;
	}

	return f[n];
    }

    public static void main(String args[]) {
	//int n = 50000;
	//System.out.println(fib(n));
	fibonacci(10);
	System.out.println();
	System.out.println("\nrecursion : "+ fibonacciRec(10));
    }
    
    static void fibonacci(int N) {
	int ans = 0;
	int x =0;
	int y =1;
	System.out.print (y+" ");
	for(int i = 1; i<N; i++) {
	    ans = x+y;
	    System.out.print(ans+" ");
	    x= y;
	    y= ans;
	}
    }
    
    static int fibonacciRec(int N) {
	if(N==0) return 0;
	if(N==1 || N==2) return 1;
       int res = fibonacciRec(N-1)+fibonacciRec(N-2);
      System.out.print(res+" ");
       return res;
    }
}
/* This code is contributed by Rajat Mishra */
