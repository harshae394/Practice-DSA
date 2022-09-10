package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SPOJ {

	public static void main(String[] args) throws Exception {
	    
	    printPrimeNumsinRange();
	    //OptmiziedPrimeNumbers();
	    //aggressiveCows();
	 
	   // aggressiveCowsV2();
		/*Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0 ; i<tc ;i++) {
			long num1 = sc.nextLong();
			long num2 = sc.nextLong();
			long res = revNum(revNum(num1) + revNum(num2));
			System.out.println(res);
		}*/
	    
		//capitalize();
		//lexicographical_order();
		//DecideGender();
		/*String word = "hello";
		char cs = word.charAt(0);
		char res = 0 ;
		if(cs > 96 && cs < 123) {
			 res  = (char) (cs - 32);
		}
		word =  word.substring(1,word.length());
		System.out.println(res+word);
		
		//addRevNum(1,305,794);
		inversionCount();*/
	    //System.out.println(fastMultiplication());
	   

	}
	
	private static void aggressiveCows() throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tc = Integer.parseInt(br.readLine());

	    for (int it = 0; it < tc; it++) {
		String inputs[] = br.readLine().split(" ");
		int stalls = Integer.parseInt(inputs[0]);
		int cows = Integer.parseInt(inputs[0]);
		int arr[] = new int[stalls];
		for(int st = 0; st < stalls; st++) {
		    arr[st] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int k = 0;k<arr.length;k++)
		    System.out.print(arr[k]+" ");
		int low = 0; int high = arr[stalls-1];
		int best = 0;
		
		while(low<=high) {
		    int mid = (low+high+1)/2;
		    int cnt = 1;
		    int left = 0;
		    for(int i = 1; i <stalls && cnt < cows ; i++) {
			if(arr[i]-arr[left]>=mid) {
			    left = i;
			    cnt++;
			}
		    }
		    if(cnt>=cows) {
			best = mid;
			low = mid+1;
		    }else {
			high = mid-1;
		    }
		}
		
		System.out.println(best);
		
	    }
	}
	
	private static void aggressiveCowsV2() throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tests = Integer.parseInt(br.readLine());
	    for (int i = 0; i < tests; i++) {
		String inp[] = br.readLine().split(" ");
		int barns[] = new int[Integer.parseInt(inp[0])];
		int cows = Integer.parseInt(inp[1]);
		for (int st = 0; st < barns.length; st++) {
		    barns[st] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(barns);
		/*
		 * System.out.println(); for (int k = 0; k < barns.length; k++) {
		 * System.out.print(barns[k] + " "); } System.out.println();
		 */
		int low = 1;//1 2 4 8 9
		int high = barns[barns.length - 1] - barns[0];
		int n = barns.length;
		low = barns[1] - barns[0];
		/*for (int j = 1; j < n; j++) {
		    if (barns[j] - barns[j - 1] < low)
			low = barns[j] - barns[j - 1];
		}*/
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
		    int mid = (low + high) / 2;
		    if (validDistance(barns, cows, mid, n)) {
			ans = mid;
			low = mid + 1;
		    } else {
			high = mid - 1;
		    }
		}
		bw.write(ans+"\n");
		// bw.write(binarySearch(barns, low, high, cows, n) + "\n");
	    }
	    bw.flush();
	}
	private static boolean validDistance(int barns[],int cows, int mid,int n) {
	    int prev = 0;//cows = 4
	    int r=1;//1 2 5  9 16
	    for(int i= 1; i<n;i++) {
		if(barns[i]-barns[prev]>=mid) {
		    prev = i;
		    r++;
		}
	    }
	    return r>=cows;
	}
	private static int getMaxMinDistance(int barns[],int low, int high,int cows, int n) {
	    low = barns[1] - barns[0];
		for (int j = 1; j < n; j++) {
		    if (barns[j] - barns[j - 1] < low)//1 2 4 8 9 
			low = barns[j] - barns[j - 1];
		    
		}
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
		    int mid = (low + high) / 2;
		    if (validDistance(barns, cows, mid, n)) {
			ans = mid;
			low = mid + 1;
		    } else {
			high = mid - 1;
		    }
		}
		return ans;
	}
	
	
	private static void addRevNum(int tc, long num1,long num2) {
		
		for(int i=0 ; i<tc ;i++) {
			long res = revNum(revNum(num1) + revNum(num2));
			System.out.println(res);
		}

	}
	//123
	private static long revNum(long num) {
		 long sum = 0;
	        while(num!=0){
	        	sum = sum*10 + num%10;
	        	num=num/10;
	        }
	     return sum;
	}

	private static void inversionCount() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		System.out.println("tccount : "+ (tc));
		for(int i = 0; i<tc ; i++){
			
			int eachArraySize = sc.nextInt();	
			System.out.println("eachArraySize : "+ (eachArraySize));
			int arr[] = new int[eachArraySize];
			int cnt = 0;
			for(int j = 0; j<eachArraySize ; j++){
				arr[j] = sc.nextInt();
			}
			
			for(int k = 0; k<eachArraySize;k++) {
				for(int l = k+1; l<eachArraySize;l++) {
					if((l>k && arr[k] > arr[l])){
						cnt++;				
					}
				}
				
			}
			if(cnt > 1) System.out.println("count : "+ (cnt));
			
		}
	}
	
	private static void capitalize() {
		String word = "xnhcigytnqcmy";
		word = word.toLowerCase();
		String res = "";
		char array[] = word.toCharArray();
		for(char cs : array) {
			if(cs == 97 || cs ==101 || cs==105|| cs==111| cs==117 || cs==121) {
				
			}
			else {
				res = res+ "."+cs; 
			}
		}
		System.out.println(res);
	}
	
	private static void lexicographical_order() {
		String word1 = "aaaa".toLowerCase();
		String word2 ="aaaA".toLowerCase();
		char c1[] = word1.toCharArray();
		char c2[] = word2.toCharArray();
		int cnt=0;
		for(int i =0 ; i<c1.length ;i++) {
			if(c1[i] > c2[i]) {
				System.out.println(1);
				return;
			}
			else if(c2[i] >c1[i]) {
				System.out.println(-1);
				return;
			}
			else {
				cnt++;
				}
		}
		if(cnt==word1.length())
		System.out.println(0);
	}
	private static void DecideGender() {
		String word1 = "wjmzbmr";
		char c1[] = word1.toCharArray();
		int cnt = 1;
		Arrays.sort(c1);
		for(int i =1 ; i<c1.length ;i++) {
			if(c1[i-1]!=c1[i])
			cnt++;
		}
		System.out.println("count : "+cnt);
		if(cnt%2!=0) {
			System.out.println("IGNORE HIM!");	
		}else {
			System.out.println("CHAT WITH HER!");
		}
		
	}
	
	private static List<Long> fastMultiplication() {
	    List<Long> ll = new ArrayList<Long>();
	    Scanner sc = new Scanner(System.in);
	    int tc = sc.nextInt();

	    for (int it = 0; it < tc; it++) {
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int idx = 0;
		long res = 0;
		if (num1 > num2) {
		    idx = num2;
		    res = num1;
		} else {
		    idx = num1;
		    res = num2;
		}
		long fin = 0;
		for (int i = 1; i <= idx; i++) {
		    fin = fin + res;
		}
		ll.add(fin);

	    }
	    return ll;
	}
	private static long multiplyNum(int a, int b) {
		   if(b == 0) {
		       return 0; 
		   } else { 

		       long result = multiplyNum(a, b / 10) * 10; 

		       long lastDigit = b % 10; 

		       if(lastDigit > 0) {
		           result = result + (a * lastDigit);
		       } 

		       return result;
		   }
	}
	
	public static BigInteger multiply(BigInteger a, BigInteger b) {
	    return a.multiply(b);
	}
	
	public static void printPrimeNumsinRange() throws NumberFormatException, IOException {

		InputStreamReader input =new InputStreamReader(System.in);    
		BufferedReader br =new BufferedReader(input);
		int tc = Integer.parseInt(br.readLine());
		
		for(int it =0; it<tc; it++){
			int start = Integer.parseInt(br.readLine());
			int end = Integer.parseInt(br.readLine());
			int res = 0;
			for(int i= start; i<=end; i++){
			    if(i==1 || i==0) {
				    continue;
			    }
			    int cnt=0;
			    for(int j = 1; j<=Math.sqrt(i); j++) {
					if(i%j==0) {
					   cnt++;
					}
			    }
			    if(cnt==1) {
				res++;
					//System.out.println(i%1000000007);
			    }
			}
			System.out.println(res);
		}
	
	}
	 
	
	static void OptmiziedPrimeNumbers() throws NumberFormatException,Exception {
		Scanner br =new Scanner(System.in);    
		//BufferedReader br =new BufferedReader(input);
		int tc = Integer.parseInt(br.next());
		
		for(int it =0; it<tc; it++){
			int start = Integer.parseInt(br.next());
			int end = Integer.parseInt(br.next());
			for(int i= start; i<=end; i++){
			    	if(i==1) continue;
			   		if(isPrime(i)) System.out.println(i%100000007); 
				}
			}
		}
	
	static boolean isPrime(int i) {
	    for(int j = 2; j<=Math.sqrt(i); j++) {
		if(i%j==0) {
		   return false;
		}
	    }
	    return true;
	}
	public static void visaContest() throws Exception{

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tc = Integer.parseInt(br.readLine());
	    for(int it=0; it<tc;it++){
	        String values[] = br.readLine().split(" ");
	        int x1 = Integer.parseInt(values[0]);
	        int x2 = Integer.parseInt(values[1]);
	        int y1 = Integer.parseInt(values[2]);
	        int y2 = Integer.parseInt(values[3]);
	        int z1 = Integer.parseInt(values[4]);
	        int z2 = Integer.parseInt(values[5]);
	        
	        if( (x1>=x2) && (y1>=y2) && (z1<=z2)) {
	            bw.write("YES\n");
	        }else  bw.write("NO\n");
	    }
	    bw.flush();
	}
}
