package javaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Recursion {
    	
	public static void main(String[] args) throws Exception {
	    
	    
	    
	   // int a[] = {2, 19, 8, 15, 4};
	   // reverse(a,a.length-1);
	    Test2();
	}
	static void Test1() throws NumberFormatException, IOException {
	    InputStreamReader input =new InputStreamReader(System.in);    
		BufferedReader br =new BufferedReader(input);
		long num = Long.parseLong(br.readLine());
		long num2 = Long.parseLong(br.readLine());
		
		System.out.println(num+num2);
		
		findSubsets();
	}
	
	static void Test2() throws Exception {
	    int arr[] = {2,3,1,4,4,5};
	    findAllIndexesOfNumber(arr, 4, 0);
	    System.out.println(list);
	}
	static void reverse(int arr[],int idx){
	    	if(idx < 0) return;
	        System.out.print(arr[idx]+" ");
	        reverse(arr,idx-1);
	}
	
	private static void findSubsets() {
		int a[] = {5,3,15};
		Arrays.sort(a);
		int ar[] = new int[3];
		//allSubsets(a,0,0,a,ar.length);
		subsetPairLexicographical(a,a.length);
		//for( int i =0 ; i<a.length ;i++) 
		//System.out.println(a[i]);
		//permuteRec("abc",a.length,-1,"");
	}
	
	
	static void subsetPairLexicographical(int arr[], int n ) {
	    
	    List<String> ans = new ArrayList< String >();
	    
	    for(int i = 1; i<(1<<n); i++) {
		String s ="";
		for (int j=0; j<n;j++) {
		    if((i& (1<<j))>0) {
			s = s+" "+arr[j];
		    }
		}
		ans.add(s);
		System.out.println("s: "+s);
		//System.out.println("ans: "+ans);
	    }
	    //System.out.println("ans: "+ans);
	   Collections.sort(ans);
	   //System.out.println("ans: "+ans);
	    
	    System.out.println("ans : "+ans);
	   for(String s : ans) {
	       	System.out.print(s.trim() +" ");
	       	System.out.println();
	   }
	   
	    
	}
	

	static void permuteRec(String str, int n, int index, String curr) {
		// base case
		if (index == n) {
			return;
		}
		System.out.print(curr + " ");
		for (int i = index + 1; i < n; i++) {
			curr += str.charAt(i);
			permuteRec(str, n, i, curr);
			// backtracking
			curr = curr.substring(0, curr.length() - 1);
		}
		return;
	}
	
	static void allSubsets(int arr[], int pos, int len, int[] subset, int N) 
	{
	  if(pos == N) 
	  { 
	     print(subset);
	     System.out.println();
	     return;
	  }
	  // Try the current element in the subset.
	  subset[len] = arr[pos];
	  allSubsets(arr, pos+1, len+1, subset,N);
	  // Skip the current element.
	  allSubsets(arr,pos+1, len, subset,N);
	}
	static void print(int[] subset) {
	 for(int i =0; i<subset.length;i++) 
	     if(subset[i]!=0)
	     System.out.print(subset[i] +" ");
	// System.out.println();
	} 
	
	static void printV1(int[][] subset, int n) {
		 for(int i =0; i<subset.length;i++) {
		     for(int j = 0; j<n;j++) {
        		     //if(subset[i][j]!=0)
        		     System.out.print(subset[i][j] +" ");
		     }
		     System.out.println();
		 } 
	}
	
	static List<Integer> list = new ArrayList<>();
	
	static void findAllIndexesOfNumber(int arr[],int target,int idx) {
	    
	    if(idx==arr.length) return;
	    
	    if(arr[idx]==target) {
		list.add(idx);
	    }
	    findAllIndexesOfNumber(arr, target, idx+1);
	}
}
