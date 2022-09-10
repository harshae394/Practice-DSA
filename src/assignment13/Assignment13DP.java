package assignment13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Assignment13DP {
    public static int mod = 1000000007;

    public static void main(String[] args) throws Exception {
	List<Long> ll = new ArrayList<Long>();
	//ll.add(2l);ll.add(3l);ll.add(5l);ll.add(6l);
	ll.add(2l);ll.add(3l);ll.add(5l);
	NoOfPermutationsForCoinChange(7,ll);
	NoOfWaysForCoinChange(7,ll);
	//factDynamicProg();
    }

    public static long fact(long n) {
	if (n == 0 || n == 1)
	    return n;
	return n * fact(n - 1);

    }

    static void factDynamicProg() throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	int T = Integer.parseInt(br.readLine());
	long factArray[] = factPreCompute(1000000);
	while (T-- != 0) {
	    int num = Integer.parseInt(br.readLine());
	    //long dp[] = new long[num + 1];
	   // long res = fact(dp, num);
	    long res = factArray[num];
	    bw.write(res + "\n");
	    bw.flush();
	}

    }

    static long fact(long dp[], int n) { // TLE
	if (n == 0 || n == 1)
	    return n % mod;
	if (dp[n] == 0) {
	    long res = ((n % mod) * (fact(dp, n - 1) % mod)) % mod;
	    dp[n] = res;
	}
	return dp[n] % mod;
    }

    static long[] factPreCompute(int n) {
	long dp[] = new long[n + 1];
	dp[0] = 1;
	dp[1] = 1;
	for (int i = 2; i <= n; i++) {
	    dp[i] = ((i % mod) * (dp[i - 1] % mod)) % mod;
	}
	return dp;
    }
    
    public static long NoOfPermutationsForCoinChange(int n, List<Long> coins) {
	// Write your code here/ all combinations with order matters
	//2,3,5,6 ==>10
	long dp[] = new long[n+1];
	dp[0]=1;
	for(int i = 1; i<=n; i++) {
	    for(long coin : coins) {
		if(coin <=i) {
		    long remain = i-coin;
		    dp[i] = dp[i]+ dp[(int) remain];
		}
	    }
	}
	System.out.println(dp[n]);
	return dp[n];

    }
    
    public static long NoOfWaysForCoinChange(int n, List<Long> coins) {
	//2,3,5 ==>7
	long dp[] = new long[n+1];
	dp[0]=1;
	for(long coin : coins) {
	    for(long i = coin; i<=n; i++) {
		if(coin <=i) {//Not required
        		long remain = i-coin;
        		dp[(int)i] = dp[(int)i]+ dp[(int) remain];
		}
	    }
	}
	System.out.println(dp[n]);
	return dp[n];

    }

}
