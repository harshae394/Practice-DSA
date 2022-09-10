package assessmentQuestions;
/*package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {
		int ar[] = {2,5,7,3,9,1,12};
		int k =18;
		boolean found = false;
		for(int i = 0; i<ar.length ;i++) {
			if(ar[i]==k) {
				found = true;
				break;
			}
		}
		if(found) {
			System.out.println("found");
		}else System.out.println("not found");
		
		System.out.println(bst(ar, k));	
		//System.out.println(numTest(123,2132));
		
		LinkedList<Integer> num = new LinkedList<>();
		num.add(1);num.add(5);num.add(2);num.add(3);num.add(9);
		System.out.println("res : " + findImmortle(num, 9));
		maxsubArraySize(3);
	}
	
	public static int bst(int ar[], int k) {
		Arrays.sort(ar);
		
		int left = 0;
		int right= ar.length;
		
		while(left+1 < right) {
			
			int mid = (left+right)/2;
			
			if(ar[mid] ==k) {
				return k;
			}else if(ar[mid] < k) {
				left = mid;
			}else right = mid;
			
		}
		
		if(ar[left]==k) return k;
		
		else return -1;
	}

	
	public static boolean numTest(int a, int b) {
		//123, 312
		//512 ,126
		//22, 222
		int s1 = sum(a);
		int s2 = sum(b);
		
		return s1==s2;
		
	}
	static int sum(int x) {
		//123
		int res = 0;
		
		while(x!=0) {
			res = res + x%10;
			x = x/10;
		}
		System.out.println(res);
		return res;
	}
	
	//1->2-4>5>6--1
	
	static int findImmortle(LinkedList<Integer> num, int k) {
	
		int ans =0;
		for(int  i =0; i<num.size() ; i++) {
			if(num.get(i)!=k) {
				num.remove(num.get(i));
			}
		}
		System.out.println(num);
		return num.get(0);
	}
	static int maxsubArraySize(int k ) {
		int ar[] = {-2,4,1,6,-5,-7,-12,20,21};
		
		int sum = Integer.MIN_VALUE;
		int localSum = 0;
		int l = 0,r = 0;
		for(int i = 0; i<ar.length ; i++) {
			l = i;
			for(int j = i; (j < i+k && i+k<ar.length); j++){
				sum = sum +ar[j];
				r = j;
			}
			System.out.println( l  +", "+ r +" sum : "+sum);
			sum = Math.max(localSum, sum);
		}
		System.out.println( l  +", "+ r);
		System.out.println(sum);
		
		return 0;
	}
	String s=”aaaabbbccacdddttt”;

	output=”4a3b2cabc3d3t”;

	int cnt = 1;
	String res =””;
	int start = 0;
	for(int i =start; i<s.length; i++){
		cnt =0;
	for(int j =i+1; j<s.length-1; j++){
		if(s.charAt(i).equals(s.charAt(j))){
	cnt++;
	start = j;
	}
	else break;
	}	
		if(cnt>2){
	res+= cnt+s.charAt(i);
	}else{
		res+= s.charAt(i);
	}
	}
	System.out.println(res);


	String s="aaaabbbccacdddttasasdfaaccccaaabbaaat";

	output=”4a3b2cabc3d3t”;

	LinkedHashMap<String,Integer> map = new LinkedHashMap();
	String res = “”;
	for(int i = 0; i<s.length(); i++){
		
		if(map.containsKey() && (map.get(s.charAt(i).equls((map.get(s.charAt(i+1))))){
			map.put(s.charAt(i),map.get(s.charAt(i))+1);
	}else{
		map.put(s.charAt(i)+”$”,1);
	}


	z}{a=4, b=3,c=2,}

	THread.sleep(8880)













}
*/