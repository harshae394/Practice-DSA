package finalChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FinalChallenge {
    //https://www.lintcode.com/problem/1880/
//https://www.hackerrank.com/contests/smart-interviews-final-sep21/challenges/si-palindromic-concatenation
    public static void main(String[] args)  throws Exception{
	// TODO Auto-generated method stub
	//palindromicConcat();
	int arr[] = {-3, 5, 2, -3, 1 };
	//int arr[] = {-1, 4, 10, -3, 15, -8, -10, 30, -12, 9 };
	int cnt = maxSubarraySumLength0(arr);
	System.out.println(cnt);

    }

    public static void palindromicConcat() throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
        	String[] strgs = br.readLine().split(" ");
        	String str1 = strgs[0];
        	String str2 = strgs[1];
        	boolean res = palindromicConcatUtil(str1,str2);
        	if(res) 
        	    bw.write("Yes\n");
        	else bw.write("No\n");
        	bw.flush();
	}
    }
    public static boolean palindromicConcatUtil(String str1, String str2) {
	boolean arr[] = new boolean[26];
	
	int n = str1.length();
	int m = str2.length();
	//abc	 adw
	for(int i = 0; i < n; i++){
	    arr[str1.charAt(i) - 'a'] = true;
	}
	for(int i = 0; i < m; i++){
	    if(arr[str2.charAt(i) - 'a']) {
		   return true;
	    }
	}
	return false;
    }
    
    public  static int maxSubarraySumLength0(int arr[])
    {
        // Creates an empty hashMap hM {-3, 5, 2, -3, 1 };
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //{-1, 4, 10, -3, 15, -8, -10, 30, -12, 9 };
        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];
 
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
 
            if (sum == 0)
                max_len = i + 1;
 
            // Look this sum in hash table
            Integer prev_i = map.get(sum);
 
            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                map.put(sum, i);
        }
 
        return max_len;
    }
}
