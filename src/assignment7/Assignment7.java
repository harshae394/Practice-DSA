package assignment7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Assignment7 {

    public static void main(String args[]) throws Exception{
	//isPalindrome();
	int res = 0;
	res = equilibriumPoint(new long[] {1, 3, 5, 2, 2}, 5);
	System.out.println("res : "+res);
    }
    
    public static int equilibriumPoint(long arr[], int n) {
	int sum1 = 0, sum2 = 0, i, j;
	for (i = 0; i < n; i++)
	    sum1 += arr[i];
	if (n == 1) {
	    return 1;
	} else if (n == 2) {
	    return -1;
	} else {
	    for (i = 0; i < n - 1; i++) {
		if (sum2 == (sum1 - arr[i] - sum2)) {
		    return (i + 1);
		}
		System.out.println("sum2 : "+sum2);
		sum2 += arr[i];
	    }
	}
	return -1;

    }

 
    public static void secondlargest() throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tests = Integer.parseInt(br.readLine());
        for (int it = 0; it < tests; it++) {
          
            String inputs[] = br.readLine().split(" ");
            int size = inputs.length;
            int arr[] = new int[size];
            for(int i =0; i<size; i++ ) {
        	arr[i]= Integer.parseInt(inputs[i]);
            }
            //Arrays.sort(arr);
            ///bw.write(arr[size-2]+"\n");
            bw.write(secondLargestUtil(arr, size)+"\n");
            bw.flush();
        }
    }
    
    public static int secondLargestUtil(int arr[], int n) {
	int first = Integer.MIN_VALUE;
	int second = first;
	for(int i = 0; i<n ; i++) {
	    if(arr[i] > first) {
		second = first;
		first = arr[i];
	    }if( arr[i] > second && arr[i]!=first) {
		second = arr[i];
	    }
	}
	return second;
    }
    private static void isPalindrome() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int tests = Integer.parseInt(br.readLine());
	        for (int it = 0; it < tests; it++) {
	            String input = br.readLine();
	            
	            int n = input.length();
	            int p1=0; int p2=n-1;
	            //geeksskeeg
	            boolean notPalindrome = false;
	            while(p1<=p2) {
	        	if(input.charAt(p1)==input.charAt(p2)) {
	        	    p1++;
	        	    p2--;
	        	}else {
	        	    notPalindrome = true;
	        	    break;
	        	}
	            }
	            if(!notPalindrome) System.out.println("palindrome");
	            else System.out.println("Not palindrome");
	        }
	        
	            
    }
}
