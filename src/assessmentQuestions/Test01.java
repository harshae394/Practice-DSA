package assessmentQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test01 {

	/**Given an array of N integers, and a number sum, the task is to find the number of pairs of integers in the array whose sum is equal to sum. 
	 * Input:  arr[] = {1, 5, 7, -1, 4}, sum = 6
Output:  3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
*///
	//-1,1,4,5,8
	//1,5,7,-1,4
	//6-1=5
	private static int pairsWithSum(int arr[], int sum) {
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		for(int i = 0; i<arr.length ; i++)
			set.add(arr[i]);
		
		for(int i = 0; i<arr.length ; i++) {
			int ele = sum-arr[i];
			if(set.contains(ele)) {
				System.out.println(arr[i]+","+ele);
				cnt++;
				set.remove(arr[i]);
				
			}
		}
		return cnt;
	}
	
	/**
	 * Given a sorted array arr[] of n elements, write a function to search a given
	 * element x in arr[] and return the index of x in the array.Input: arr[] = {10,
	 * 20, 30, 50, 60, 80, 110, 130, 140, 170}, x = 110 Output: 6 Explanation:
	 * Element x is present at index 6.
	 */
	

	private static int search(int arr[], int k) {
		int left = 0;
		int right = arr.length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] > k) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (arr[left] == k) {
			return left;
		}
		return -1;
	}
	public static void main2(String[] args) {
		int arr[] = {60,70,80,90, 100, 110,20,30,40,50};
		int arr2[] ={30,40,50,60,70,80,90,100,10,20};
		
		int k =330;
		System.out.println(findPivot(arr2));
		System.out.println(maxLenUniqueSubstr("assaabchdddffeghhtis"));
	}
	
	public static int maxLenUniqueSubstr(String str) {
		int max = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		for(int i= 0; i<str.length(); i++) {
			char cc = str.charAt(i);
			if(map.containsKey(cc)) {
				start = Math.max(start, map.get(cc)+1);
			}
			map.put(cc, i);
			max = Math.max(max,i-start+1);
		}
		return max;
	}
	//str = “assaabchdddffeghtis”
//abchd
//feghtis
	public static int findPivot(int arr[]) {
		int left = 0;
		int right = arr.length;
		while(left+1< right) {
			int mid = (left+right)/2;
			if(arr[mid] > arr[left]) {
				left = mid;
			}else if(arr[mid-1]>arr[mid]) {//{30,40,50,60, 20, 10,5,6,7,9}
				return mid-1;
			}else  {
				right = mid;
			}
		}
		return left;
	}
	
	public static int findElement(int arr[], int k) {
		int left = 0;
		int right = arr.length-1;
		while(left+1< right) {
			int mid = (left+right)/2;
			
			if(arr[mid]==k) {
				return mid;
			}else if(arr[mid]<k) {
				left = mid;
			}else if(mid < arr.length && arr[mid]>arr[mid+1]) {
				right = mid;
			}
		}
		if(arr[left]==k) {
			return left;
		}
		return -1;
	}
	public static void printSumV1(int arr[], int sum) {
		int p1 =0;
		int p2 = arr.length-1;
		while(p1<p2) {
			int tempSum = arr[p1]+arr[p2];
			if(tempSum==sum) {
				System.out.println(arr[p1]+", "+arr[p2]);
				p1++;
				p2--;
			}else if(tempSum > sum) {
				p2--;
			}else {
				p1++;
			}
		}
	}

//{1,2,3,4,5,6,7,8,9},10
	public static void printSum(int arr[], int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length ; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		for(int i = 0; i<arr.length ; i++) {
			int remainNum = sum-arr[i];
			if(map.containsKey(remainNum) && remainNum!=arr[i]) {
				System.out.println(arr[i]+", "+remainNum);
			}
			map.remove(arr[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "134452X-/-1X 2/--36";
		// "13 44 52 X -/ -1 X 2/ -- 36";
		//frame = 2*rolls
		int score = 0;
		//17x+10+2 next rolls
		//4 + 8 +7+10+10+10+1+10+10+2+8+3+6=91
		//4+8+7=>17+10--+10+1+10+2+10+9
		Map<Character,Integer> map = new HashMap<>();
		map.put('X', 20);
		map.put('/', 10);
		map.put('-', 0);
		int frame = 0;
		int cnt = 0;
		for(int i = 0; i<str.length() ; i++) {
			if(frame==2) {
				frame =0;
				cnt=0;
			}
			String strike = str.charAt(i)+"";
			if(strike.equalsIgnoreCase("XX") ) {
				cnt+= map.get(str.charAt(i));
				cnt = cnt>10 ?10:cnt;
			}
			if(strike.equalsIgnoreCase("//")) {
				cnt+= map.get(str.charAt(i));
				cnt = cnt>10 ?10:cnt; 
			}
			cnt+= str.charAt(i);
			
			frame++;
			score = cnt;
		}
		System.out.println(score);
		

	}

}
