package javaproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InterviewBit {

	public static void main(String[] args) {
		//reverseBits(10);
		//System.out.println(countSetBitsTillnumber(5));
		//flipBitsv2(15l);
	    //findNthFibanocciNum(50);
	    //System.out.println(findNthFibanocciNumV1(49));
	    //medianofmatrix();
	    reverseString(" this is  ib ");
	    System.out.println(reverseBetweenKString("abcdefghi",3));
	    //minimumParanthesis();
	    System.out.println(getDecimalFromBinary(110));
	    int a[] = {1,5,6,8,9};
	    int b[] = {2,3,4,7,11,12,16};
	    mergeSorted(a, a.length, b, b.length);
	}

	private static void mergeSorted(int a[], int m, int b[], int n) {
	    int c[] = new int[m + n];
	    int p1 = 0, p2 = 0;
	    int i = 0;
	    while (p1 < m && p2 < n) {
		if (a[p1] < b[p2]) {
		    c[i] = a[p1];
		    p1++;
		} else {
		    c[i] = b[p2];
		    p2++;
		}
		i++;
	    }
	    while (p1 < m) {
		c[i] = a[p1];
		p1++;
		i++;
	    }
	    while (p2 < n) {
		c[i] = b[p2];
		p2++;
		i++;
	    }
	    System.out.println("c: " + c.length);
	    for (int j = 0; j < c.length; j++) {
		System.out.print(c[j] + " ");
	    }
	}
	/**Given an integer A find the Ath number whose binary representation is a palindrome.*/
	private static boolean getGivenNthBinaryNumPalindrome(long num) {
		//
		return false;
	}
	//111
	private static int getDecimalFromBinary(int num) {
	    int temp = num;
	    int res = 0;//111
	    int base = 1;
	    while(temp > 0) {
		res += (temp%10)*base;
		temp = temp/10;
		base = base*2;
	    }
	    return res;
	}
	private static long countSetBitsTillnumber(int num) {
			int cnt =1;
			
			while(num!=0) {
				if((num &1)==1) cnt++; 
				num = num-1;
			}
			System.out.println("no of bits in num: "+num +" are : "+cnt);
			
			return ((cnt%1000000007)+1);
			
	}
	private static long flipBitsv2(long given ) {
		long max=1;
		for(int i =0 ; i<32 ;i++) {
			max= max<<1;
		}
		System.out.println(max);
		return max-given;
	}
	private static long flipBits(long given ) {
		long max=1;
		for(int i =0 ; i<32 ;i++) {
			max= max<<1;
		}
		System.out.println(max-given-1);
		return max-given-1;
	}
	
	private static long reverseBits(int num) {
		//00000000000000000000000000000011
		
		  long res = 0; //B will hold the reversed number
		    for(int i=0;i<32;i++){  //Iterating on all bit positions
		        int k = num & 1;      //Extracting the rightmost bit from A (the ith bit in original number)
		        res= res  << 1 ;      //Shifting B to left (rightmost bit becomes 0)
		        res = res | k;        //Adding the extracted bit
		        num = num>> 1;        //Now the (i+1)st bit shifts to the rightmost position in A
		        System.out.println(res);
		    }
		    System.out.println(res);
		    return res;
	}
	private static long minXORvalue(int num[]) {//Need to workout, failed
		int res = Integer.MAX_VALUE;
		Arrays.sort(num);
		int xor =0;
		for(int i = 0 ; i<num.length ; i++) {
			xor = xor ^ num[i];
			if(xor < res && xor!=0) {
				res = xor;
			}
		}
		System.out.println("minx xor : "+res);
		return res;
	}
	
	
	private static int findNthFibanocciNum(int num) {
	    num=40;
	    //1,1,2,3,5,8,13,21,34
	    int x=0;
	    int y=1;
	    int result = 0;
	    for(int i=2; i<=num; i++) {
		result =(x+y)%1000000009;
		x= y;
		y= result;
	    }	
	    System.out.println(result%1000000009);
	    return result%1000000009;
	}
	
	private static int findNthFibanocciNumV1(int num) {
	   
	    if(num==1|| num==2) return 1%1000000009;
	    
	    while(num!=0) {
		return findNthFibanocciNumV1((num%1000000009)-1)+findNthFibanocciNumV1((num%1000000009)-2);
	    }
	    return 0;
	}
	
	private static void medianofmatrix() {
	    int a[][] = {{1,3,5},{2,6,9},{3,6,9}};
	 //   Arrays.sort(a);
	    for(int i=0; i<a.length;i++) {
		for(int j = 0;j<a.length;j++) {
		    System.out.print(a[i][j]+" ");
		}System.out.println();
	    }
	}
	
	private static void lengthOfLastWord(String s) {//chk in intevibit
	    String str[] = s.split(" ");
	    int cnt = 0;
	    for(int i = str.length-1; i >=0 ;i--) {
		int len = str[i].length();
		if(len > cnt) {
		    cnt =len; 
		}
	    }
	    System.out.println(cnt);
	}
	private static String reverseString(String s) {//chk in intevibit
	    s = " this is  ib ";
	    String str[] = s.split(" ");
	    String res ="";
	    for(int i = str.length-1; i >=0 ;i--) {
		res = res.trim() +" "+str[i].trim();
	    }
	    System.out.println(res.trim());
	    return res;
	}

	private static String reverseBetweenKString(String str, int k) {// chk in intevibit
	    //abcdefghi
	    int n = str.length();
	    int cnt = 1;
	    String res = "";
	    String ans = "";
	    for (int i = 0; i < n; i++) {
		//System.out.println("res  : "+res);
		res = str.charAt(i) + res;
		if (cnt == k) {
		    System.out.println("res : "+res +", cnt : "+cnt);
		    ans += res;
		    res = "";
		    cnt = 0;
		}
		cnt++;
	    }
	    return ans;
	}
	private static int minimumParanthesis() {
	   String s = ")";
	   
	   Map<Character,Character> maps=new HashMap<Character,Character>();
	        maps.put(')','(');
	        Stack<Character> stack=new Stack<Character>();
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if( maps.containsKey(c) && (!stack.isEmpty() && stack.peek()==maps.get(c))) {
	                    stack.pop();
	            }
	            else {
	        	stack.push(c);
	            }
	        }
	        System.out.println(stack.size());
	        return stack.size();
	    }
	
	private static int sumOfMaxMin(int arr[]) {
	    
	    Arrays.sort(arr);
	    int res =  arr[0]+arr[arr.length-1];
	    return res;
	}
	
	private static int[] sortArrayWithSqaures(int arr[]) {
	    int res [] = new int[arr.length];
	    for(int i=0; i<arr.length;i++)
		res[i] = arr[i]*arr[i];
	    Arrays.sort(res);
	    return res;
	}
	private static int[] MatrixMedian(int arr[][]) {
	    int res [] = new int[arr.length];
	    
	    for(int i=0; i<arr.length;i++)
		res[i] = arr[i][i]*arr[i][i];///WRONG
	    Arrays.sort(res);
	    return res;
	}
}
