package javaproject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*****S&P global CoderByte
 * https://github.com/gutty333/Medium-Programming-Challenges
 * @author Harish.Ennam
 *
 */
public class ProgrammsTes {

	public static void main(String[] args) {
		//longestSubStringNoRepeat();
	/*	String s ="abcabc";
		char c= s.charAt(0);
		int chars[] = new int[128];
		System.out.println(c+0);
		chars[c]++;
		System.out.println(chars[c]);
		
		int arr[] = new int[128];
		arr[0]=0;
		arr[0]++;
		System.out.println(arr[0]);
		arr[0]++;
		System.out.println(arr[0]);
		arr[0]++;
		System.out.println(arr[0]);*/
		//System.out.println(lengthOfLongestSubstring("abcabcbb"));
		int a[]= {6,2,-1,7,3};
		//System.out.println(concecutiveSubarrayMaxSum(a,3,5));
		int nums[] = {1,3,-1,-3,5,3,6,7}; int k = 3;
		slidingWindowMaximumV4(nums, k);
		int res[] = maxSlidingWindowV3(nums,k);
		for(int i = 0; i<res.length ; i++)
			System.out.print(res[i] +" ");
		//Integer.bitCount(10);
		//System.out.println(1.00==1.0);
		//System.out.println(squreRoot(24));
		System.out.println("\nmaxRepn "+lengthOfLongestSubstringEfficient("jdvdconceptoftheday"));
		System.out.println("\nmaxRepn2 : "+lengthOfLongestSubstringV4("jdvdconceptoftheday"));
		System.out.println("ending");
	}
	//of distinct chars
	public static int lengthOfLongestSubstringV4(String s) {
	        int len = s.length();//jdvdconceptoftheday
	        int i=0,j=0,ans=0;
	        Set<Character> set = new LinkedHashSet<Character>();
	        while(i < len && j < len){
	            if(!set.contains(s.charAt(j))){
	                set.add(s.charAt(j));
	                ans = Math.max(ans, j-i+1);
	                j++;
	            }else{
	                set.remove(s.charAt(i));
	                i++;
	            }
	        }
	        System.out.println(set);
	        return ans;
	    }
public static int lengthOfLongestSubstringEfficient(String s) {
        int[] chars = new int[26];
        //jdvdconceptoftheday
        int left = 0;
        int right = 0;

        int res = 0;
        String ans = "";
        int maxLeft = 0;
        int maxRight = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r-'a']++;
            while (chars[r-'a'] > 1) {
                char l = s.charAt(left);
                chars[l-'a']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            maxLeft = Math.max(maxLeft, left);
            maxRight = Math.max(maxRight, right);
            right++;
        }
      //  System.out.println("\nmaxLeft : "+maxLeft +" maxRight : "+maxRight);
        return res;
	}
	
        //Function to find a continuous sub-array which adds up to a given number.
        static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
           int currSum = 0;
            int start = 0; 
            int end = -1;
            ArrayList<Integer> ans = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0; i<n; i++){
                currSum+= arr[i];
                if(currSum-sum==0){
                    start = map.getOrDefault(currSum-sum,0)+1; 
                    end = i+1;
                    break;
                }
                if(map.containsKey(currSum-sum)){
                    start = map.get(currSum-sum)+1;
                    end = i+1;
                    break;
                }
                map.put(currSum,i+1);
            }
            if(end!=-1 ) ans.add(start);
            ans.add(end);
            return ans;
        }
	private static int concecutiveSubarrayMaxSum(int a[],int subarraySize,int len) {
		int max=0;
		int k = subarraySize;
		for(int i=0; i<k;i++){
			max = max+a[i];
		}
		//max = 6
		//5,2,-1,0,3 = 5,2,-1=>6
		//			=  2,-1,0 =>1
		//			  -1,0,3=>2
		int windMax = max;
		for(int j = k; j<len ;j++ ) {
			windMax = windMax + a[j]-a[j-k];//5-//2+
			max =Math.max(max, windMax);
		}
		return max;
	}
	
	
	 public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();

	        int res = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) {
	                if (checkRepetition(s, i, j)) {
	                    res = Math.max(res, j - i + 1);
	                }
	            }
	        }

	        return res;
	    }

	    private static boolean checkRepetition(String s, int start, int end) {
	        int[] chars = new int[128];

	        for (int i = start; i <= end; i++) {
	            char c = s.charAt(i);
	            chars[c]++;
 	            if (chars[c] > 1) {
	                return false;
	            }
	        }

	        return true;
	    }
	
	    public static int lengthOfLongestSubstringV2(String str){
		    int n = str.length();
		    int res = 0;
		     //javaconceptoftheday
		    int prev = 0;
		    for(int i = 0; i < n; i++)
		    {
		 
		        boolean[] visited = new boolean[256];
		         
		        for(int j = i; j < n; j++)
		        {
		            if (visited[str.charAt(j)] == true)
		                break;
		 
		            else
		            {
		                res = Math.max(res, j - i + 1);
		                visited[str.charAt(j)] = true;
		            }
		        }
		       // visited[str.charAt(i)] = false;
		    }
		    return res;
		}
	public static void longestSubStringNoRepeat() {
		String s = "abcdabcdbbbbc"; //a
		String sub ="";
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				sub= s.substring(i,j);
				
				for(int k=j; k<s.length(); k++) {
					
					String str =s.substring(j,k);
					if(str.equals(sub) ) {
						if(sub.length()> count)
						count = sub.length();
					}
				}
				
			}
		}
		System.out.println("count : "+count);
		
		
	}
	
	private static int Slidemax(int a[],int cnt) {
		int max = 0;
		for(int i =0;i<cnt;i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}
	private static int Slidemax(int a[],int start, int end) {
		int max = Integer.MIN_VALUE ;
		for(int i=start; i<end; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}
	
	private static int[] maxSlidingWindowV1(int a[],int k) {
		int ret [] = new int[a.length-k+1];
		int cnt = 0;
		for(int i =0; i<a.length-k+1; i++) {
			ret[cnt]= Slidemax(a,i,i+k);
			cnt++;
		}
		return ret;
	}
	
   public static int[] maxSlidingWindowV2(int[] a, int k) {
       int ret [] = new int[a.length-k+1];
       int max =0;
       int cnt = 0;
       for(int i =0; i<a.length-k+1; i++) {
            for(int j = i ; j < i+k; j++){
            	max = Integer.MIN_VALUE;
                max =Math.max(max,a[j]);
            }
            ret[cnt]= max;
            cnt++;
		}
        return ret;
    }
   
   public static List<Integer> slidingWindowMaximumV4(int[] nums, int k) {
       // WRITE YOUR BRILLIANT CODE HERE
       Deque<Integer> q = new ArrayDeque<>(k);  // stores *indices*
       List<Integer> res = new ArrayList<>();
       for (int i = 0; i < nums.length; i++) {
           while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
               q.removeLast();
           }
           q.addLast(i);
           // remove first element if it's outside the window
           if (q.getFirst() == i - k) {
               q.removeFirst();
           }
           // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
           if (i >= k - 1) {
               res.add(nums[q.getFirst()]);
           }
       }
       return res;
   }
   public static int[] maxSlidingWindowV3(int[] a, int k) {
       int ret [] = new int[a.length-k+1];
     //[1,3,-1,-3,5,3,6,7]
       int cnt = 0;
       Deque<Integer> queue = new ArrayDeque<Integer>();
       for(int i= 0; i<k; i++) {
    	   while(!queue.isEmpty() && a[i]>=a[queue.getLast()]) {
    		   queue.removeLast();
    	   }
    	   queue.addLast(i);
       }
       ret[cnt++] = a[queue.getFirst()];////1,2 indx
       //cnt++;
       for(int i=k; i<a.length; i++) {
    	   
    	   if(i-k==queue.getFirst()) {//1,2,3
    		   queue.removeFirst();
    	   }
    	   while(!queue.isEmpty() && a[i]>=a[queue.getLast()]) {
    		   queue.removeLast();
    	   }
    	   queue.addLast(i);//1,2,3, //4
    	   ret[cnt++] = a[queue.getFirst()];
           //cnt++;
	}
      
        return ret;//3,3,5
    }
   public int[] maxSlidingWindow3(int[] nums, int k) {
	   //[1,3,-1,-3,5,3,6,7]
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int[] ans = new int[nums.length - k + 1];
		int len = ans.length;

		for (int i = 0; i < k; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);//1=1,3=1,-1=1

		ans[0] = map.lastKey();//3

		for (int i = 1; i < len; i++) {
			map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);//num[3]=1,nu[4]=1,num[5]=1+1
			int freq = map.get(nums[i - 1]);//1
			if (freq == 1)
				map.remove(nums[i - 1]);//remove from begining
			else
				map.put(nums[i - 1], freq - 1);
			ans[i] = map.lastKey();
		}

		return ans;
	}
   
   public static int squreRoot(int N) {
	   
	   int low =1;
	   int high = N;
	   int mid = 0;
	   int sq = 0;
	   
	   while (low<=high){
		   
	   	mid = (low+high)/2; 

	   	sq =mid*mid;
	   	
	   	if(sq==N) return mid;
	   	
	   	if(sq > N) high = mid-1;
	   	
	   	else  low = mid+1;

	   }
	   return mid;
   }
   
   
   
   private double calPow(double x, int n) { 
       if (n == 0) return 1.0;
       if (n == 1) return x;
       if (n % 2 == 1) return x * calPow(x, n - 1); //4*cal(4, 2);//cal(4,1);=4>>16
       
       return calPow(x * x, n / 2);//cal(4,3);
       
   }
   
  
   private static String longestSubstringWithNoRepeat(String str) {
    return str;
       
   }
    
}
