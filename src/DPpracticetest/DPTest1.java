package DPpracticetest;

public class DPTest1 {

    public static void main(String[] args) {
	//
	int n =5;
	//1 1 2 3 5 8 13 21 34 55 89
	long dp[] = new long[n+1];
	System.out.println(fibonacci(n,dp));
	System.out.println(findNthFibanocciNum(50000));
	//System.out.println(factorial(n,dp));
	//kanpsackTest();
	
    }
    private static long findNthFibanocciNum(int num) {
	    //1,1,2,3,5,8,13,21,34
	    long x=0;
	    long y=1;
	    long result = 0;
	    for(int i=2; i<=num; i++) {
		result =(x+y)%1000000009;
		x= y;
		y= result;
	    }	
	    System.out.println(result);
	    return result;
	}
	
    
    private static void kanpsackTest() {
	int profits[]= {1,6,10,16};
	int weights[] = {1,2,3,5};
	int capacity = 7;
	int res = 0;
	//res = kanpsackRecursion(profits, weights, capacity, 0);
	Integer dp[][] = new Integer[profits.length][capacity+1];
	res= kanpsackRecursionTopDown(profits, weights, capacity, 0, dp);
	System.out.println(res);
    }
    
    private static long fibonacci(int n, long dp[]) {
	
   	if(n==0 ) return 0;
   	if(n==1 || n==2 ) return 1;
   	
   	if(dp[n]!=0) return dp[n];
   	
   	long res = (fibonacci(n-1,dp) + fibonacci(n-2,dp));
   	dp[n]= res; 
   	
   	return dp[n];
       }
    
    private static long factorial(int n, long dp[]) {
	
	if(n==0) return 1;
	
	if(dp[n]!=0) return dp[n];
	
	dp[n]= n*factorial(n-1,dp);
	
	return dp[n];
    }
    
    private static int kanpsackRecursion(int profits[], int weights[], int capacity,int idx) {
	if(capacity<=0 || idx >= profits.length) {
	    return 0;
	}
	int prof1 = 0;
	if(weights[idx] <= capacity) {
	    prof1 = profits[idx] + kanpsackRecursion(profits, weights, capacity-weights[idx], idx+1);
	}
	int prof2 =  kanpsackRecursion(profits, weights, capacity, idx+1);
	int res = Math.max(prof1, prof2);
	return res;
	
    } 
    
    private static int kanpsackRecursionTopDown(int profits[], int weights[], int capacity,int idx, Integer dp[][]) {
   	if(capacity<=0 || idx >= profits.length) {
   	    return 0;
   	}
   	int prof1 = 0;
   	if(dp[idx][capacity]!=null) {
   	    return dp[idx][capacity];
   	} 
   	if(weights[idx] <= capacity) {
   	    prof1 = profits[idx] + kanpsackRecursionTopDown(profits, weights, capacity-weights[idx], idx+1,dp);
   	}
   	int prof2 =  kanpsackRecursionTopDown(profits, weights, capacity, idx+1,dp);
   	
   	dp[idx][capacity] = Math.max(prof1, prof2);
   	
   	return dp[idx][capacity];
   	
       } 

}
