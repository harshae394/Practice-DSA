package javaproject;

import java.util.HashMap;

public class OpenText {

	public static int reverse(int A) {
        long sum = 0;
        while(A!=0){
        	//System.out.println(sum*10);
        	//if(sum*10 > Integer.MAX_VALUE || sum*10 < Integer.MIN_VALUE) return 0;
        	sum = sum*10 + A%10;
        	if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return 0;
            A=A/10;
        }
        //if(sum >Integer.MAX_VALUE || sum < Integer.MIN_VALUE ) return 0;
        return (int)sum;
    }
	
	public static void swap(int x, int y) {
	    x = x+y; //20+30 =50
	    y = x-y; //50-30=20
	    x = x-y;
	    System.out.println("x = "+x +" y = "+y);
	    x = x*y;
	    x = x/y;
	    y = x/y;
	}
	public static void swap(String x, String y) {
	    x = x+"_"+y;//Harish_kumar
	    System.out.println("x: "+x);
	    y = x.substring(0,x.indexOf("_"));
	    x = x.substring(x.indexOf("_")+1,x.length());
	    
	    System.out.println("x = "+x +" y = "+y);
	}
	public static void main(String[] args) {
	    subArraySum(-20);	
	    //swap(90,30);
	    	//swap("harish", "kumar");
		//System.out.println(reverse(1146467285));
		//System.out.println(Integer.bitCount(10));
		int a =(int)Math.pow(10,10);
		System.out.println("a : "+a);
		//sumOfNum(99);
		//smallestNumber(14);
		/*String inp ="5";
		int num = -15958;//1+958,159+8
		String st = String.valueOf(num);
		String newSt = st.replace(inp,"");
		
		int n = st.length()- newSt.length(); //Occurrences of given num in gvn string
		
		String ar [] =st.split("");
		
		int len = ar.length;
		int indxs[] = new int[n];//storing indxs of gvn num in in gvn string
		
		if(st.contains(inp)) {
			int cnt = 0;
			for(int i=0 ; i<len ; i++) {
				if(ar[i].equals(inp)) {
					indxs[cnt]= i;//1,3
					cnt++;
				}
			}
			
			String p ="";
			int res=0;
			for(int k = 0; k<indxs.length; k++) {
				p = st.substring(0,indxs[k])+ st.substring(indxs[k]+1,st.length());
				
				if(Integer.parseInt(p)> res) {
					res= Integer.parseInt(p);
					
				}
				System.out.println("p :"+p);
			}
			System.out.println("result : "+res);
		}
		
		
		
		int n = 50872;
		n=88;
		String st = String.valueOf(n);
		String ar [] =st.split("");
		int len = ar.length;
		
		String val ="0";
		
		for(int i = 0; i <len; i++) {
			for(int j=i+1; j<i+2 && (j<len);j++) {
			if(Integer.parseInt(ar[i]+ar[j]) > Integer.parseInt(val)) {
				val = ar[i]+ar[j];
			}
		}
	}
		System.out.println(Integer.parseInt(val));
		System.out.println(reverseNum(123));*/
		//int cost[] = {0,1,2,3,4,5};
		//String s = "abccbd";
		//int cost[] = {10,5,10,5,10};
		//String s = "ababa";
		//int cost[] = {3,4,5,6};
		//String s = "aaaa";
		int cost[] = {1,2,1,2,1,2};
		String s = "aabbcc";
		//System.out.println(MinCost(s,cost));
		System.out.println(generatePalindromeOfKDistinctCharsWithNSize(8,3));
		System.out.println(Max("59552"));
		/*int e[] = {6,6,10,8,1,1,1,4,4,4,4,4,4,4,8,7};
		int numRange =10;
		getMaxVotesByCandidate(e,e.length,numRange);*/
		getKthCharInConcatenated();
		int rever = circularSubarraySum(new int[] {8, -8, 9, -9, 10, -11, 12}, 7);
		System.out.println(rever);

	}
	
	//17,1+7+9
	private static int test1(int N) {
	
	if(N<10 && N>0) return N;
	
	int pow =  (int) Math.pow(10, (N / 9));
	
	int res = 	( (N % 9 + 1) *pow - 1);
        return res;
		/*int res = 0;
		for(int i =1; i<=50 ; i++) {
			
			for(int j =i+1; j<=50;j++) {
				if(i+j==n) {
					
					if(i+j>res) {
						res =i+j;
					}
				}
				
			}*/
		}
	
	static int Maxcost(String s, int []cost)
		{
		      
		    // Maximum cost 
		    int maxcost = 0;
		    int i = 0;
		      
		    // Traverse from 0 to len(s) - 2
		    while (i < s.length() - 1) 
		    {
		          
		        // If characters are identical
		        if (s.charAt(i) == s.charAt(i + 1)) 
		        {
		              
		            // Add cost[i] if its maximum
		            if (cost[i] < cost[i + 1])
		                maxcost += cost[i];
		  
		            // Add cost[i + 1] 
		            // if its maximum
		            else
		            {
		                maxcost += cost[i + 1];
		                cost[i + 1] = cost[i];
		            }
		        }
		  
		        // Increment i 
		        i++;
		    }	
		    return maxcost;
		}
	
private static int reverseNum(int x) {
	if(x==0 || (x>=-9 && x<=0) || (x<=9 && x>=0)) return x;
	int res = 0;
	
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
	return res;
		
	}
	
static int MinCost(String S, int []C){
  //  int cost[] = {1,2,1,2,1,2};
	//String s = "aabbcc";
    int mnCnt = 0;
    int i = 0;
    while (i < S.length() - 1) {
        if (S.charAt(i) == S.charAt(i + 1))  {
            if (C[i] > C[i + 1]) {
            	mnCnt = mnCnt+ C[i + 1];
                C[i + 1] = C[i]; 
            }
            else {
            	mnCnt = mnCnt+ C[i];
            }
        }
        i++;
    }	
    return mnCnt;
}
/**https://www.geeksforgeeks.org/maximize-cost-of-deletions-to-obtain-string-having-no-pair-of-similar-adjacent-characters**/
//0,1,2,4,4,3,5 //abcccbd
static int MinCostV2(String s, int []c){
    int res = 0;
    for(int i=0; i<s.length()-1;i++) {
    	
    	if(s.charAt(i)==s.charAt(i+1)) {
    		if(c[i]>c[i+1]) {
    			res = res+c[i+1];
    		}else {
    			res = res+c[i];
    		}
    	}
    }
    return res;
}

static void sumOfDigits(int N) {
	
	 System.out.println((N%9 + 1) *Math.pow(10, (N / 9)) - 1);
}

static void sumOfNum(int N) {
	N=99;
	System.out.println("input: "+N);
	int res = 0 ; //14
	int N1 =N;
	while(N!=0) {
		res = res+N%10;
		N = N/10;
	}
	res  =2*res;//5*2 =10;
	System.out.println("res *2: "+res);
	int ans= Integer.MAX_VALUE;
	int res2= 0;
	for(int i=1; i<=res*res; i++) {//2
		for(int j=i; j<=res*res;j++) {
			
			if(i+j == res) {//64
				res2 = Integer.parseInt(String.valueOf(i+""+j+""));//64//37//73/19
				System.out.println(res2);
				
				if((ans > res2))
					ans = res2;
				//ans = Math.min(ans, res2);
						
			}
		}
		
	}
	System.out.println("ans :"+ans);//19
	/*int z =0;
	
	while(ans!=0) {
		z =z+ ans%10;
		ans =ans/10;
	}
	System.out.println("z: "+z);//19
*/	
	
	
}

static int getSum(int n)
{
    int sum = 0;
    while (n != 0)
    {
        sum = sum + n % 10;
        n = n / 10;
    }
    return sum;
}



static void smallestNumber(int N)
{
    int i = 1;
    while (1 != 0)
    {
        // Checking if number has
        // sum of digits = N
        if (getSum(i) == N)
        {
            System.out.println(i);
            System.out.println("new");
            break;
        }
        i++;
    }
    
    
}




static int getMaxVotesByCandidate(int arr[],int length,int numRange) {
	
	int cnt[] = new int[numRange+1];
		
	int maxCand = 0;
	int maxvotes = 0;
	for(int i = 0; i<length; i++) {
		cnt[arr[i]]++; 
	}
	for(int k = 0; k<cnt.length ; k++) {
		if(cnt[k]>maxvotes) {
			maxvotes = cnt[k];
			maxCand = k;
		}
	}
	
	//System.out.println("Candiate : "+maxCand+", Max Votes: "+maxvotes);
	
	for(int  p = 1; p<cnt.length; p++) {
		for(int l = 0; l<cnt[p];l++) {
			System.out.println("Candiate : l : "+l+", "+p);
		}
	}
	
	
	return 0;
	
}


//https://www.geeksforgeeks.org/find-maximum-sum-pair-with-same-digit-sum/
static void findMax(int []arr, int n)
{
   
    // Map to store the sum of digits
    // in a number as the key and
    // the maximum number having
    // that sum of digits as the value
    HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
    int ans = -1, pairi = 0, pairj = 0;
    for (int i = 0; i < n; i++) {
 
        // Store the current sum of digits
        // of the number in temp
        int temp = digitSum(arr[i]);
 
        // If temp is already present
        // in the map then update
        // ans if the sum is greater
        // than the existing value
        if (mp.containsKey(temp)) {
            if (arr[i] + mp.get(temp) > ans) {
                pairi = arr[i];
                pairj = mp.get(temp);
                ans = pairi + pairj;
            }
            mp.put(temp, Math.max(arr[i], mp.get(temp)));
        }
        else
        // Change the value in the map
        mp.put(temp, arr[i]);
         
    }
 
    System.out.print(pairi+ " " +  pairj
        + " " +  ans +"\n");
}




static int digitSum(long n)
{
    int sum = 0;
    while (n > 0)
    {
        sum += (n % 10);
        n /= 10;
    }
    return sum;
}

static String generatePalindromeOfKDistinctCharsWithNSize(int N, int K) {
    N = 8;
    K = 3;
    if(K==1 || (K==1 && N>1) || (N-K==0) || (N-K<2)) return null;
    String ans = "";
    for (int i = 0; i < K; i++) {
	ans = ans + (char) ('a' + i);
    }
    String rep = ans.charAt(K - 1) + "";
    String newStr = "";
    for (int i = K - 2; i >= 0; i--) {
	newStr = newStr + ans.charAt(i);
    }
    String res = ans + newStr;
    while (res.length() != N) {
	newStr = rep + newStr;
	res = ans + newStr;
    }
    System.out.println("res : " + res + "res leng : " + res.length());
    return res;
}
/** you are given a string consisting of digits. Find the biggest two-digits value that is a consistent fragment of thr given string.
For example, two-digit consistent fragment of "50552" are["50","05","55","52"], representing the numbers [50,5,55,52]. the biggest value among them is 55.**/
    public static int Max(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++){
            int current = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (current > max)
                max = current;
        }
        return max;
    }
  
    //gupshup hackerearth--Character kk
    public static void getKthCharInConcatenated() {
	
	int[][] a= {{3,3,3},
		{1,5,16},
		{3,5,15}};
	String[] b= {"aaaaa","bbbbb","ccccc","ddddd","eeeee"};
	
	String s = "";
	for(int i = 0 ; i<a.length ; i++) {
	    s = "";
	    int start = a[i][0]-1;
	    int end = a[i][1]-1;
	    int value = a[i][2]-1;
	    
	    for(int  k = start ; k<=end ; k++) {
		s = s+b[k];
	    }
	    System.out.println("s: "+s);
	   s= s.charAt(value)+"";
	   System.out.println("eachVal : "+ s);
	}
	
    }
    /**https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1 **/
    long maxSubarraySum(int arr[], int n) {
	// -10,2,1 7, 8
	int ans = Integer.MIN_VALUE;
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
	    sum = sum + arr[i];
	    ans = Math.max(ans, sum);
	    if (sum < 0) {
		sum = 0;
	    }
	}
	return ans;

    }
    /** https://www.youtube.com/watch?v=kd0-hUwISDo**/
static int circularSubarraySum(int a[], int n) {
        
        if(a.length==1) return a[0];
        if(a.length==2 && (a[0]<0 && a[1]<0)) return Math.max(a[0],a[1]);
        return Integer.max(kadane(a,n), reverseKadane(a,n));
    }
    
/**https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/**/
    static int reverseKadane (int arr[], int n) {
        
        int firstSum = 0;
        int secondSum = 0;
        
        for(int i = 0; i<n ; i++){
            firstSum+= arr[i];
            arr[i]= -arr[i];
        }
        //8, -8, 9, -9, 10, -11, 12
        secondSum = kadane(arr,n);
        //-8,8,-9,9,-10,11,-12
        
        System.out.println("firstSum : "+firstSum +", secondSum: "+secondSum);
        return secondSum+firstSum;
    }
     static int kadane(int arr[], int n) {
    
    	int ans = Integer.MIN_VALUE;
    	int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    	    sum = sum + arr[i];
    	    ans = Math.max(ans, sum);
    	    if (sum < 0) {
    		    sum = 0;
    	    }
    	}
    	System.out.println("kadan ans : "+ans);
    	 return ans;
    }  
     
  // Java program to print subarray with sum as given sum

     	public static void subArraySum( int sum) {
     	    	int[] arr = {10, 2, -2, -20, 10};
		int n = arr.length;
		sum = 12;
     		//cur_sum to keep track of cumulative sum till that point
     		int cur_sum = 0;
     		int start = 0;
     		int end = -1;
     		HashMap<Integer, Integer> hashMap = new HashMap<>();

     		for (int i = 0; i < n; i++) {
     			cur_sum = cur_sum + arr[i];
     			System.out.println("hashMapins : "+hashMap);
     			//check whether cur_sum - sum = 0, if 0 it means
     			//the sub array is starting from index 0- so stop
     			if (cur_sum == sum ) {
     				start = 0;
     				end = i;
     				break;
     			}
     			//if hashMap already has the value, means we already
     			// have subarray with the sum - so stop
     			if (hashMap.containsKey(cur_sum - sum)) {
     				start = hashMap.get(cur_sum - sum) + 1;
     				end = i;
     				break;
     			}
     			//if value is not present then add to hashmap
     			hashMap.put(cur_sum, i);

     		}
     		System.out.println("subArryMap: "+hashMap);
     		// if end is -1 : means we have reached end without the sum
     		if (end == -1) {
     			System.out.println("No subarray with given sum exists");
     		} else {
     			System.out.println("Sum found between indexes "
     							+ start + " to " + end);
     		}

     	}


}
