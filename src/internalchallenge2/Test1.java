package internalchallenge2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {
//https://www.hackerrank.com/contests/smart-interviews-21b/challenges
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	// deleteMinCharactersTomakeAnagrams();
	// numberOfSubArraysInGivenRange();
	// numberOfPrimes();
	//primes(2, 11);
	//perfectSqaureInRange();
	groupAnagrams(null);
	System.out.println("numberFactors" +numberFactors(12));
	String str1 ="12";
	char c = str1.charAt(0);
	int b = c-'0';
	//b = b+3;
	//System.out.println("c: "+b);
	int numericVal = Character.getNumericValue(c);
	//System.out.println(numericVal);
	String s3 = "+";
	String spc =" ";
	char empty = spc.charAt(0);
	//System.out.println("space : "+ (int)empty);
	//System.out.println(('+'==s3.charAt(0)));
	//Integer.parseInt(c);
	
	System.out.println(calculator("14+2+3"));
	System.out.println(calculate("1+2*4+3"));

    }
    public static List<List<String>> groupAnagrams(String [] arr){
	 arr = new String[] {"eat","tea","tan","ate","nat","bat"};
	Set<List<Character>> list =new HashSet<>();
	 for(int i = 0; i<arr.length; i++) {
	   List<Character> each = new ArrayList<Character>();
	   
	   for(int j =0; j<arr[i].length(); j++) {
	       each.add(arr[i].charAt(j));
	   }
	   list.add(each);
	 }
	 System.out.println("list : "+list);
	for(int i =0;  i<list.size();i++) {
	    
	}
	 return null;
    }

    private static void deleteMinCharactersTomakeAnagrams() throws NumberFormatException, IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    String words[] = br.readLine().split(" ");
	    String word1 = words[0];
	    String word2 = words[1];

	    int count[] = new int[26];
	    char arr1[] = word1.toCharArray();
	    char arr2[] = word2.toCharArray();
	    //smart interviews
	    //
	    for (int i = 0; i < arr1.length; i++) {
		count[arr1[i] - 97]++;
	    }
	    for (int i = 0; i < arr2.length; i++) {
		count[arr2[i] - 97]--;
	    }

	    int res = 0;
	    for (int i = 0; i < count.length; i++) {
		res = res + Math.abs(count[i]);
	    }

	    bw.write(res + "\n");
	}
	bw.flush();
    }

    private static void checkAisSubsequenceOfB() throws NumberFormatException, IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    String words[] = br.readLine().split(" ");
	    String word1 = words[0];
	    String word2 = words[1];
	    int n = word1.length();// abc
	    int m = word2.length();// xyzapboc
	    String res = "";
	    int k = 0;
	    for (int i = 0; i < m && k < n; i++) {
		if (word1.charAt(k) == word2.charAt(i)) {
		    k++;
		}
	    }
	    if (n == k)
		res = "Yes";
	    else
		res = "No";
	    bw.write(res + "\n");
	}
	bw.flush();
    }

    private static void numberOfSubArraysInGivenRange() throws NumberFormatException, IOException {
//failed
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    String sizeNRange[] = br.readLine().split(" ");
	    String ele[] = br.readLine().split(" ");
	    int range[] = { Integer.parseInt(sizeNRange[1]), Integer.parseInt(sizeNRange[2]) };
	    int size = Integer.parseInt(sizeNRange[0]);
	    int arr[] = new int[size];
	    for (int i = 0; i < size; i++) {
		arr[i] = Integer.parseInt(ele[i]);
	    }
	    System.out.println("***");
	    // -5 10 -3
	    int cnt = 0;
	    for (int i = 0; i < size; i++) {
		int sum = 0;
		for (int j = 0; j <= i; j++) {
		    System.out.print(arr[j] + " ");
		    sum = sum + arr[j];
		}
		System.out.println();
		// if(sum >=range[0] || sum<=range[1]) cnt++;
	    }
	    System.out.println();
	    // bw.write(cnt + "\n");
	}
	bw.flush();
    }

    private static void numberOfPrimesSieveOfEroth() throws NumberFormatException, IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    String range[] = br.readLine().split(" ");
	    int start = Integer.parseInt(range[0]);
	    int n = Integer.parseInt(range[1]);
	    int primes[] = new int[n + 1];
	    for (int i = 0; i <= n; i++)
		primes[i] = 1;
	    primes[0] = 0;
	    primes[1] = 0;

	    for (int i = 2; i * i <= n; i++) {
		if (primes[i] == 1) {
		    for (int j = 2; i * j <= n; j++) {
			primes[i * j] = 0;
		    }
		}
	    }
	    int cnt = 0;
	    for (int i = start; i < primes.length; i++) {
		if (primes[i] == 1)
		    cnt++;
		// System.out.print(primes[i]+" ");
	    }
	    // System.out.println();
	    System.out.println("\n" + cnt);

	}
	bw.flush();
    }

    private static void primesV1(int a, int b) {
	int flag = 0;
	int cnt = 0;
	while (a <= b)

	{
	    flag = 0;
	    for (int i = 2; i * i <= a; ++i) {

		if (a % i == 0 || a % 2 == 0) {
		    flag = 1;
		    break;
		}
	    }
	    if (flag == 0) {
		cnt++;
		System.out.print(a + " ");
	    }
	    ++a;
	}
	System.out.println("\n" + cnt);
    }

   private static List<Integer> numberFactors(int n){
       int MAX = (int) Math.sqrt(n);
       List<Integer> res = new ArrayList<>();
       for (int i=1; i<=MAX; i++){
           if (n%i==0){
               if (n/i == i) {
        	   res.add(i);
               }else {
        	   res.add(i);res.add(n/i);
               }
           }
       }
       return res;
   }
    private static void primes(int a, int b) {
	int flag = 0;
	int cnt = 1;

	for (int i = a; i * i <= b; ++i) {
	    if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 || i % 11 == 0) {
		cnt++;
	    }
	}
	/*
	 * if (flag == 0) { cnt ++; System.out.print(a + " "); }
	 */
	// ++a;
	System.out.println("\n" + cnt);
    }


    private static void perfectSqaureInRange() throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());
	for (int it = 0; it < tests; it++) {
	    String range[] = br.readLine().split(" ");
	    long start = Long.parseLong(range[0]);
	    long end = Long.parseLong(range[1]);
	    long num = 0;
	    int cnt =0;
	    
	    cnt = (int) (Math.floor(Math.sqrt(end)) - Math.ceil(Math.sqrt(start)) + 1);
	    
	    /*for (long i = start; i <= end; i++)
		 
	            // Check if current number 'i' is perfect
	            // square
	            for (int j = 1; j * j <= i; j++)
	                if (j * j == i)
	                    cnt++;
	    
	   /* for(long i = 2; i<=start ;i++) {
		num = i * i;
		if(num>=start && num<=end) {
		    cnt++;
		   // System.out.println(num);
		}
	    }*/
	    bw.write(cnt+"\n");
	    
	}
	bw.flush();
    }

    
    private static int calculator(String str) {
	int len  = str.length();//1+2+3*4
	int res = 0;
	int currentNumber = 0;
	int lastNumber = 0;
	char ele [] = str.toCharArray();
	char sign ='+';
	for(int i =0; i<len;i++) {
	    char currentChar = ele[i];
	    if(isNumber(currentChar)) {
		currentNumber =  (currentNumber*10)+currentChar-'0';
		
	    }if( !isNumber(currentChar) && !isWhiteSpace(currentChar) || i == len-1){
		
		if(sign=='+' || sign=='-') {
		   res = res +lastNumber;
		   lastNumber = (sign=='+')?  currentNumber :-currentNumber;
		}else if (sign=='*') {
		    lastNumber = lastNumber * currentNumber;
		}else if (sign=='/') {
		    lastNumber = lastNumber / currentNumber;
		}
		sign =currentChar;
		currentNumber = 0;
	    }
	}
	res = res +lastNumber;
	return res;
    }
    
    private static boolean isNumber(char val) {
	if(val>47 && val<58) {
	    return true;
	}
	return false;
    }
    private static boolean isWhiteSpace(char val) {
	return val==32;
    }
    public static int calculate(String s) {
	s = "1+2+3";
	    int ans = 0;
	    int currNum = 0;
	    int prevNum = 0;
	    char op = '+';

	    for (int i = 0; i < s.length(); ++i) {
	      final char c = s.charAt(i);
	      if (Character.isDigit(c))
	        currNum =  (c - '0');
	      if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
	        if (op == '+' || op == '-') {
	          ans += prevNum;
	          prevNum = (op == '+') ? currNum : -currNum;
	        } else if (op == '*') {
	          prevNum = prevNum * currNum;
	        } else if (op == '/') {
	          prevNum = prevNum / currNum;
	        }
	        op = c;
	        currNum = 0;
	      }
	    }

	    return ans + prevNum;
	  }
}
