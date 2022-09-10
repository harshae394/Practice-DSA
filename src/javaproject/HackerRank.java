package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HackerRank {

    public static void main(String[] args) throws Exception {
	//System.out.println(hourGlassSumV2(readInput()));
	/*
	 * int n=11; if (n == 0 || n == 1){ System.out.println(n); }else{ long res = 1;
	 * for (int i = n; i > 1; i--) { res = res * i; } System.out.println(res); }
	 */
	/*
	 * int xx =12; System.out.println(xx);//1100 System.out.println((xx &
	 * (~(xx-1))));//1100 1011 => 1100 & 0100=0100
	 * 
	 * xx =12; System.out.println(xx);//1100 System.out.println((xx &
	 * (xx-1)));//1100 & 1011= 1000
	 */
	/*
	 * InputStreamReader input =new InputStreamReader(System.in); BufferedReader br
	 * =new BufferedReader(input);
	 */
	// long num = Long.parseLong(br.readLine());

	// System.out.println(fact2(10));
	// System.out.println(trailingZerosInFactorial(60));
	// System.out.println(powerOf2(30));
	// System.out.println(checkBit(17,4));
	/*
	 * int tc =1; //for(int i = 0; i<tc ; i++){ int size =
	 * Integer.parseInt(br.readLine()); System.out.println("zie : "+size); int a[] =
	 * new int[size]; for(int j = 0; j < size;j++){ a[j] = br.read(); }
	 * getRepeatedNums(a,size); System.out.println();
	 */
	// }
//final int a[] = {1, 3, 2, 3, 4, 6, 5, 5}; 
//
	final int a[] = { 1, 2, 3, 4, 5, 5, 6, 7, 6 };
	// getRepeatedNums(a,a.length);

	// final int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
	// final int arr[] = {1,3,8,2,1,2,8,7};
	// final int arr[] = {3,4,8,2,1,2,8,3};
	final int arr[] = { 1, 2, 3, 4, 4, 5, 5, 6 };// 0011,0111==>0100
	// getRepeatedNum(arr,arr.length);
	//System.out.println(sumXOR(10));
	/*
	 * int xx =5; int yy=4;
	 * 
	 * System.out.println((xx&yy) +" + "+(xx^yy));
	 */
	// System.out.println(maxXOR(10, 12));
	
	BigDecimal ss = new BigDecimal("147573952589676412928");
	countSetBits(6);
	System.out.println("ss: "+ss);
	// binaryRepresentation(120);
	// reverseBits(15);
	//hourGlass();
	//hoi(3,'A','C','B');
	//sumOfPairs();
	//tipplePairsWithDifferenceK();
	int xx=64;//10 0000
		int cnt = -1;
		while(xx!=0) {
			cnt++;
		    xx = xx>>1;
		}
		System.out.println(cnt);
    }

    private static void binaryRepresentation(int num) {
	int x = 0;
	String s = "";
	while (num != 0) {
	    x = (num & 1);
	    s = x + s;
	    num = num >> 1;
	}
	System.out.println(s);

    }

    private static void swapAdjacentBits() {
	// 101011
	// 010111
    }

    private static void getRepeatedNums(int arr[], int size) {
	/**
	 * All elements occur once except two numbers, which occur twice. Your task is
	 * to find the two repeating numbers
	 **/
	int xor = arr[0];
	int n = size - 2;
	for (int i = 1; i < size; i++) {
	    xor = xor ^ arr[i];
	}
	System.out.println("xor : " + xor);
	for (int i = 1; i <= size; i++) {
	    xor = xor ^ i;
	}
	System.out.println("xor with index: " + xor);// 0110
	int setbit = (xor & ~(xor - 1));// 1010 & 0110 =0100
	System.out.println("setbit: " + setbit);
	int x = 0;
	int y = 0;
	for (int i = 0; i < size; i++) {
	    if ((arr[i] & setbit) != 0) {
		x = x ^ arr[i];
	    } else
		y = y ^ arr[i];
	}

	for (int i = 0; i <= n; i++) {

	    if ((i & setbit) != 0) {
		x = x ^ i;
	    } else
		y = y ^ i;
	}
	if (x > y)
	    System.out.print(y + " " + x);
	else
	    System.out.print(x + " " + y);
    }

    public static int[] getRepeatedNum(int[] arr, int n) {
	/** this will return two numbers are which are non repeated from a list **/
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    sum = sum ^ arr[i];
	}
	System.out.println("xor of all : " + sum);
	sum = (sum & ~(sum - 1));
	// sum = (sum & -sum); // or sum = (sum & ~(sum-1));0110 & 0101(1010)=>0010
	System.out.println("bitwsise & 2s compelment : " + sum);
	int sum1 = 0;
	int sum2 = 0;
	// 0111, 1001==>0001
	for (int i = 0; i < n; i++) {
	    if ((arr[i] & sum) > 0) {// 0111&0100
		sum1 = sum1 ^ arr[i];// 0111&000
		System.out.println(arr[i] + " kth bit set : " + sum1);
	    } else {
		sum2 = sum2 ^ arr[i];
		System.out.println(arr[i] + " kth bitunset : " + sum2);
	    }

	}
	System.out.println("uniq numbers: " + sum1 + "," + sum2);
	return null;
    }

    public static long powerOf2(long num) {
	return 1 << num;
    }

    public static int countSetBits(int num) {
	int cnt = 0;
	while (num != 0) {
	    if ((num & 1) == 1)
		cnt++;
	    num = num >> 1;
	} // time complxity ==> log(n)
	System.out.println("no of bits in num: " + num+ " are : " + cnt);
	return cnt;

    }

    public static void getPrimeNumsInaRange(long num, long num2) {

    }

    public static boolean checkPowerOf2(long num) {
	return ((num & (num - 1)) == 0);
    }

    public static long fact(long n) {
	if (n == 0 || n == 1)
	    return n;
	return n * fact(n - 1);

    }

    public static long fact2(long n) {
	if (n == 0 || n == 1)
	    return n;
	long res = 1;
	for (long i = n; i >= 1; i--) {
	    res = res * i;
	}
	return res;
    }

    public static BigInteger fact2(int n) {
	if (n == 0 || n == 1)
	    return new BigInteger(n + "");
	BigInteger res = new BigInteger("1");
	for (long i = n; i >= 1; i--) {
	    res = res.multiply(BigInteger.valueOf(i));
	}
	return res;
    }

    public static int checkSetBitCount(long a) {
	int cnt = 0;
	// time complxety is all bits of a
	while (a != 0) {
	    if ((a & 1) == 1)
		cnt = cnt + 1;
	    a = a >> 1;
	}
	return cnt;
    }

    public static long trailingZerosInFactorial(long num) {
	long count = 0;
	for (int i = 5; num / i >= 1; i *= 5) {// 5!==> 120==>0 returned
	    count += num / i;
	}
	return count;
    }

    public static boolean checkBit(int num, int positionBit) {

	// return ((num>>positionBit)%2==1);
	// return ((num>>positionBit) &1 ==1);
	// return ( ( (num<<positionBit)& num)==(num<<positionBit) ); ???
	return (((num << positionBit) & num) != 0);
    }

    public static long sumXOR(long num) {
	/*
	 * int cnt= 1; for(int i =1; i<num ; i++) { if(num+i==(num^i)) { cnt++; } }
	 * return cnt;
	 */
	//a+b = a ^b + (a & b);
	long unsetBitCnt = 0;
	while (num > 0) {
	    if ((num & 1) == 0)
		unsetBitCnt++;
	    num = num >> 1;
	}
	long res = 1l << unsetBitCnt;;
	return res;
    }

    public static long maxXOR(long num1, long num2) {
	// 1010--> 0001->0100->0101
	long xor = num1 ^ num2;
	long max = 0;
	while (xor != 0) {
	    max = max | xor;
	    xor = xor >> 1;
	}

	return max;
    }
    // 0010 0000 0000 0000 0000 0000 0000 0000

    public static long countSetBits(long num) {
	int cnt = 0;
	System.out.println("countSetBits : " + num);
	while (num != 0) {
	    if ((num & 1) == 1)
		cnt++;
	    num = num >> 1;
	} // time complxity ==> log(n)
	System.out.println("no of bits in num: " + num + " are : " + cnt);
	return cnt;

    }

    private static long reverseBits(int num) {
	long res = 0;
	// 0101-->010
	// 0101
	for (int i = 0; i < 32; i++) {
	    res = res << 1;
	    if ((num & 1) == 1)
		res++;
	    num = num >> 1;
	    System.out.println(res);
	}
	System.out.println("revese of : " + num + " is: " + res);
	return res;
    }

    private static int findUniqueNumWhenAllNumsRepeatsTwice(int a[]) {
	// [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
	// 1,2,3,4
	int xor = 0;

	for (int i = 0; i < a.length; i++) {
	    xor = xor ^ a[i];
	}
	return xor;
    }

    static void permuteRec(String str, int n, int index, String curr) {
	// base case
	if (index == n) {
	    return;
	}
	System.out.println(curr);
	for (int i = index + 1; i < n; i++) {

	    curr += str.charAt(i);
	    permuteRec(str, n, i, curr);

	    // backtracking
	    curr = curr.substring(0, curr.length() - 1);
	}
	return;
    }

    public static void hourGlass() throws NumberFormatException, IOException {
	//
	/*
	 * List<Integer> l1= new ArrayList<Integer>(); l1.add(-9);l1.add(-9);l1.add(-9);
	 * l1.add(1);l1.add(1);l1.add(1);
	 * 
	 * List<Integer>l2= new ArrayList<Integer>(); l2.add(0);l2.add(-9);l2.add(0);
	 * l2.add(4);l2.add(3);l2.add(2);
	 * 
	 * List<Integer>l3= new ArrayList<Integer>(); l3.add(-9);l3.add(-9);l3.add(-9);
	 * l3.add(1);l3.add(2);l3.add(3);
	 * 
	 * List<Integer>l4= new ArrayList<Integer>(); l4.add(0);l4.add(0);l4.add(8);
	 * l4.add(6);l4.add(6);l4.add(0);
	 * 
	 * List<Integer>l5= new ArrayList<Integer>(); l5.add(0);l5.add(0);l5.add(0);
	 * l5.add(-2);l5.add(0);l5.add(0);
	 * 
	 * List<Integer>l6= new ArrayList<Integer>(); l6.add(0);l6.add(0);l6.add(1);
	 * l6.add(2);l6.add(4);l6.add(0);
	 * 
	 * List<List<Integer>> req = new ArrayList<List<Integer>>();
	 * req.add(l1);req.add(l2);req.add(l3); req.add(l4);req.add(l5);req.a dd(l6);
	 */
	List<List<Integer>> req = readInput();
	int eachSum = 0;
	int rowstart = 0;
	int rowend = 3;
	int maxvalue = Integer.MIN_VALUE;
	int size = req.size();
	System.out.println("req: " + size);
	for (int i = rowstart; i < rowend; i++) {
	    int colstart = 0;
	    int colend = 3;
	    for (int j = colstart; j < colend; j++) {
		if (size - 2 == colstart)
		    break;
		eachSum = getMaxValue(req, rowstart, rowend, colstart, colend);
		if (eachSum > maxvalue) {
		    maxvalue = eachSum;
		}
		colstart++;
		colend++;

	    }
	    rowstart++;
	    rowend++;
	    if (size - 2 == rowstart) {
		System.out.println("MaxValue : " + maxvalue);
		return;
	    }
	}

    }

    public static int getMaxValue(List<List<Integer>> req, int rowstart, int rowend, int colstart, int colend) {
	int rowsum = 0;
	int eachSum = 0;
	for (int i = rowstart; i < rowend; i++) {
	    for (int j = colstart; j < colend; j++) {
		rowsum = req.get(i).get(j);
		if (!((i == rowstart + 1) && (j == colstart || j == colend - 1)))
		    eachSum = eachSum + rowsum;
	    }
	}
	return eachSum;
    }

    static List<List<Integer>> readInput() throws NumberFormatException, IOException {
	Scanner sc =null;
	try {
	    sc = new Scanner(System.in);
	    List<List<Integer>> req = new ArrayList<List<Integer>>();
        	for (int i = 0; i < 6; i++) {
        	    List<Integer> rows = new ArrayList<Integer>();
        	    for (int j = 0; j < 6; j++) {
        		rows.add(Integer.parseInt(sc.next()));
        	    }
        	    req.add(rows);
        	}
        	return req;
    	}
	finally {
	    sc.close();
	}
    }
    
    static int hourGlassSumV2(List<List<Integer>> req) {
    int maxvalue = Integer.MIN_VALUE;
    int tempMax =0;
	for(int i = 0; i<req.size()-2; i++) { //rows
	    for(int j = 0; j<req.size()-2; j++) {//columns
		tempMax = req.get(i).get(j) + req.get(i).get(j+1) +req.get(i).get(j+2);
		tempMax = tempMax+ req.get(i+1).get(j+1);
		tempMax = tempMax+req.get(i+2).get(j) + req.get(i+2).get(j+1) +req.get(i+2).get(j+2);
		 if(tempMax > maxvalue)
			maxvalue = tempMax;
	    }
	    
	   
	}
	return maxvalue;
    }
    //1000
    public static int digitsSum(int num) {
	if(num==0 || num<9) return num;
	return num%10 + digitsSum(num/10);
    }
    
    public static BigInteger digitsSumV1(BigInteger num) {
	
	if( num.compareTo(new BigInteger("10"))==-1) {
	    return num;
	}
  	return num.remainder(new BigInteger("10")).add(digitsSumV1(new BigInteger(num.divide(new BigInteger("10"))+"")));
      }
    public static void verifyAllalphbetsInAString() {
	Scanner sc = new Scanner(System.in);
        String n = sc.next();
        if (n.length()<26 ) {
            System.out.println("No");
        }else{
            n = n.toLowerCase();
            char[] arr = n.toCharArray();
            Map<String,Integer> map = new HashMap<String,Integer>();
            for(int i= 0; i<arr.length; i++) {
                int x = arr[i];
                if(x>96 && x<123) {
                String key = Character.toString(arr[i]);
                if(!map.containsKey(key))
                    map.put(key, 1);
                }
            }
            Collection<Integer> values = map.values();
            long sum = 0;
            for(Integer tt: values) {
                sum = sum+tt;
            }
            if(sum!=26) System.out.println("No");
            else System.out.println("Yes");
        }
    
    }
    //hoi(3,'A','C','B');
    public static void hoi(int num, char src, char dest, char temp) {
	if(num==0) {
	    return;   
	}
	hoi(num-1,src,temp,dest);
	System.out.println("Move "+num+" from "+src+" to "+dest);
	hoi(num-1,temp,dest,src);
    }
    static {
	//hoi(3,'A','C','B');
	//int arr[] = {5,5,5,7,7,7,8,8,8,9};
	int arr[] = {5,5,5,9};
	//tripple(arr,arr.length);
	//0101 //0101 //0101 //1000 /1000
	//0111 //0111 //0111 //1000 /1001
	//msbSetBitPosition(3);
	//System.out.println(powerV2(-1,1));
	//System.out.println(Math.pow(-1, 2)%20);
	try {
	  //  printOut();
	  //  diagMatrix();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    /** All numbers occurr trice excpet one*/
    private static int tripple(int arr[],int n){
        int ans =0;
        for(int i = 0; i<=31; i++){
            int sum = 0;
            for(int j = 0; j<n; j++){
                if((( arr[j] >> i)&1)==1){
                    sum++;
                }
            }
            if((sum%3)!=0)  ans = ans | (1<<i);
        }
        System.out.println(ans);
        return ans;
    }
    //0101 1010 0100 1000 0000
    //1100
    //1000
    //0000 0011 0110 1100 1000 0000
    //1000
    private static int msbSetBitPosition(int xx) {
	int cnt = -1;
	while(xx!=0) {
		cnt++;
	    xx = xx>>1;
	}
	//System.out.println(cnt);
	return cnt;
    }
	
    
    private static int power(int base, int exp){
        int mod = 1000000007;
        long x = base;
        long res = 1;
        int maxPosition = msbSetBitPosition(exp);
        for(int i =0; i<=maxPosition; i++){
            if(((exp>>i)&1)==1){
		res = (res * x)/* %mod */;
            }
	    x = (x * x) /* %mod */;
        }
        System.out.println(res);
        return (int)(res%mod);
    }
    
    private static long powerV1(int base, int exp){
        int mod = 1000000007;
        long x = base;
        long res = 1;
        while(exp!=0) {
            if((exp & 1)==1){
		res = (res * x)%mod;
            }
	    x = (x * x)  %mod;
	    base = base >>1;
        }
        System.out.println(res);
        return res;
    }
    
    private static int powerV2(int base, int exp){
        int mod = 20;
        long x = base;
       if(exp==0) return 1;
       if(exp%2==0) {
	 long  y = powerV2(base,exp/2);
	   return (int) ((y*y)%mod);
       }
       else {
	   return (int) ((x*powerV2(base,exp-1))%mod);
       }
    }
    
    private static void printOut() throws Exception{
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     bw.write("12gee\n");
	     bw.write("hello2\n");
	     bw.flush();
    }
    
    static void diagMatrix() throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int tc = Integer.parseInt(br.readLine());
	        for (int it= 0; it<tc; it++){
	        int size = Integer.parseInt(br.readLine());
	        int arr[][] = new int[size][size];
	        for(int i=0; i<size;i++){
	          String input[] = br.readLine().split(" ");
	            for(int j=0; j<input.length; j++){
	             arr[i][j] = Integer.parseInt(input[j]);
	            }
	         }   
	        printDiagMatrix(arr,arr.length);
	        }
	        
    }
    static void printDiagMatrix(int arr[][],int size){
	int cnt = 0;
        for(int i=0; i<size;i++){
             for(int j=0; j<size;j++){
        	 cnt = arr[i][j];
                 System.out.print(cnt +" ");
             }
             System.out.println();
        }
   }
    
    static void printDiagMatrixV2(int arr[][],int n) {
	 for (int slice = 0; slice < 2 * n - 1; ++slice) {
	        System.out.println(slice+" ");
	        int z = (slice < n) ? 0 : slice - n + 1;
	        for (int j = z; j <= slice - z; ++j) {
	            System.out.println(arr[j][slice - j]+" ");
	        }
	        System.out.println();
	    }
    }
    
    static void sumOfPairs() throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int tests = Integer.parseInt(br.readLine());
	        for (int i = 0; i < tests; i++) {
	            String inputs[] = br.readLine().split(" ");
	            int value = Integer.parseInt(inputs[1]);
	            String array[] = br.readLine().split(" ");
	            boolean res = sumOfPairsUtil(array,value);
	            bw.write(res?"True\n":"False\n");
	            bw.flush();
	        }
    }

    static boolean sumOfPairsUtil(String array[], int value) {
	Set<Long> set = new HashSet<Long>();
	for (String ele : array) {
	    long res = value - Long.parseLong(ele);
	    if (set.contains(res)) {
		return true;
	    } else {
		set.add(Long.parseLong(ele));
	    }
	}
	return false;
    }
    
    static boolean pairsWithDifferenceK_Util(Set<Long> set, int value) {
	for (Long ele : set) {
	    long res = value + ele;
	    if (set.contains(res)) {
		return true;
	    }
	}
	return false;
    }
    
    static boolean tipplePairsWithDifferenceK_Util(Map<Long,Long> map, int value) {
	for(int i=0; i<map.size();i++) {
	}
	/*
	 * for (Long ele : set) { long res = value - ele;
	 * 
	 * if (set.contains(res)) { return true; } }
	 */
	return false;
    }
    
    static void tipplePairsWithDifferenceK() throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int tests = Integer.parseInt(br.readLine());
	    for (int it = 0; it < tests; it++) {
		   String inputs[] = br.readLine().split(" ");
		   int n = Integer.parseInt(inputs[0]);
		   int arr [] = new int[n];
		   int k = Integer.parseInt(inputs[1]);
	           String array[] = br.readLine().split(" ");
	           for (int idx = 0; idx < n; idx++) {
	               arr[idx] = Integer.parseInt(array[idx]);
	           }
	           Arrays.sort(arr);
	           boolean res = tipplePairsWithDifferenceKUtil(arr,k,n);
	           System.out.println(res);
	    }
    	}
    
    
    private static boolean tipplePairsWithDifferenceKUtil(int arr[],int k, int n) {
	for(int i =0 ; i<n;i++) {
	    int res = k-arr[i];
	    int p1 = i+1, p2=n-1;
	    
	    while(p1 < p2) {
		if(arr[p1]+arr[p2]==res) {
		// System.out.println("true");
		 return true;
		}
		else if(arr[p1]+arr[p2] > res) p2--;
		else p1++;
	    }
	}
	//System.out.println("false");
	return false;
    }
    
}