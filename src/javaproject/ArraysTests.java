package javaproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class ArraysTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		/*
		 * System.out.println(1900 / 500); int arr[] = { 1, 2,3,4,9 }; Integer q[] = {
		 * 4, 3, 2, 6 }; //q = findNoOfMinimumElementTillX(arr, q);
		 * System.out.println(Arrays.asList(q)); int arr2[] = { 9, 6, 1, 2 }; Integer
		 * q2[] = { 1, 2, 3, 4 }; Map<Integer, List<Integer>> processZeroBalanceHolders
		 * = withDrawTillZeroBalance(3, arr2, q2);
		 * System.out.println(processZeroBalanceHolders); Map<Integer, Integer>
		 * withDrawMoney = withDrawMoney(2900, new int[] { 100, 500, 2000, 200 });
		 * System.out.println(withDrawMoney); Integer[] nge = nextGreaterElement(new
		 * int[]{3,1,8,7,9,11}); System.out.println(Arrays.asList(nge));
		 * System.out.println("duplciates"); printRepeating(new int[]{ 1, 2,3,5,8,9,11
		 * }, 7); printRepeating2(); printfrequency();
		 */
		threeSumClosest(null, 0);
		Integer[] merger = mergeTwoDimensionalArrayToSingleDimension(
				new int[][] { { 1, 3, 4, 5 }, { 2, 1, 4, 7 }, { 1, 4, 3, 2 } });
		System.out.println(Arrays.asList(merger));
		System.out.println(getMissingNo(new int[] { 1, 2, 3, 5 }, 4));
		int[] arr = { 0, 0, 0, 1, 1, 2, 2, 3 };
		int indx = removeDuplicates(arr);
		for (int k = 0; k < indx; k++)
			System.out.print(arr[k] + " ");
		System.out.println("ended!!");
		closestnum(arr, 8);

	}

	static int getMissingNo(int a[], int n) {
		int total = 1;
		for (int i = 2; i <= (n + 1); i++) {
			total += i;
			total -= a[i - 2];
		}
		return total;
	}

	public static Integer[] mergeTwoDimensionalArrayToSingleDimension(int arr[][]) {
		int rows = arr.length;
		int cols = arr[0].length;
		int arr2[] = { 1, 2 };
		// {{1,3,4,5}, {2,1,4,7}, {1, 4, 3,2}};
		// 00,01,02,03, 10, 11,12, 20, 21, 22
		// 0,1,2,3,4,5,6,7,8,9,10,11,12`
		Integer res[] = new Integer[rows * cols];
		for (int i = 0; i < res.length; i++) {
			int row = (i / cols);
			int col = (i % cols);
			res[i] = arr[row][col];
		}
		return res;
	}

	public static Integer[] findNoOfMinimumElementTillX(int arr[], Integer q[]) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int num : arr) {

		}
		/*
		 * Arrays.sort(arr);/// {1,2,4,5,3,6,1,2}; Map<Integer, Integer> map = new
		 * HashMap<>();// {1,1,2,2,3,4,5,6}; int cnt = 1; for (int num : arr) { if
		 * (map.containsKey(num)) map.put(num, map.get(num) + 1); else map.put(num,
		 * cnt); cnt++; }
		 */
		System.out.println(map);
		int prev = 0;
		for (int i = 0; i < q.length; i++) {// {4,3,2,6};
			int ele = map.getOrDefault(q[i], 0);
			if (ele == 0) {
				q[i] = q[i - 1];
			} else {
				q[i] = ele;
			}
		}
		return q;
	}

	public static Map<Integer, List<Integer>> withDrawTillZeroBalance(int eachDebitLimit, int arr[],
			Integer customers[]) {
		Map<Integer, List<Integer>> res = new LinkedHashMap<>();
		Map<Integer, Integer> mapping = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			mapping.put(arr[i], customers[i]);
		}

		Arrays.sort(arr);
		List<Integer> withDrwls = new ArrayList<>();
		for (int num : arr) {
			withDrwls = new ArrayList<>();
			int out = mapping.get(num);
			res.put(out, withDrwls);

			if (num > eachDebitLimit) {
				while (num > eachDebitLimit) {
					num = num - eachDebitLimit;
					res.get(out).add(num);
				}
			}
			withDrwls.add(0);
		}
		return res;
	}

	public static Map<Integer, Integer> withDrawMoney(int amount, int denominations[]) {
		Map<Integer, Integer> res = new LinkedHashMap<Integer, Integer>();
		Arrays.sort(denominations); // 2000,500,200,100 ==>2300
		if (amount < denominations[0]) {
			System.out.println("No denominations available for the amount");
			return null;
		}
		int n = denominations.length;
		for (int i = n - 1; i >= 0; i--) {
			// for(int i=0; i <n;i++) {
			int value = denominations[i];
			int denm = amount / value;
			if (denm > 0) {
				amount = amount - (value * denm);
				res.put(value, denm);
			}
			if (amount == 0) {
				return res;
			}
		}
		System.out.println("Can't withdraw, Please enter multiples of 100s");
		return null;
	}

	public static Integer[] nextGreaterElement(int arr[]) {
		Stack<Integer> stck = new Stack<>();// 3,1,8,7,9,11,4
		Integer ngeArr[] = new Integer[arr.length];// 6 8 7
		for (int i = arr.length - 1; i >= 0; i--) {

			while (!stck.isEmpty() && arr[i] > stck.peek()) {
				stck.pop();
			}

			ngeArr[i] = stck.isEmpty() ? -1 : stck.peek();
			stck.push(arr[i]);
		}
		return ngeArr;

	}

	static void printRepeating(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1)
				System.out.print(i + " ");
		}
	}

	public static void printRepeating2() {
		int numRay[] = { 8, 4, 7, 3, 2, 7, 8, 2, 3, 1, 8, 7, 7 };

		for (int i = 0; i < numRay.length; i++) {
			numRay[numRay[i] % numRay.length] = numRay[numRay[i] % numRay.length] + numRay.length;
		}
		System.out.println("dups: ");
		for (int i = 0; i < numRay.length; i++) {
			System.out.print(numRay[i] + " ");
		}
		System.out.println();
		System.out.println("\nThe repeating elements are : ");
		for (int i = 0; i < numRay.length; i++) {
			if (numRay[i] >= numRay.length * 1) {
				System.out.print(i + " ");
			}
		}
	}

	static void printfrequency() {
		int arr[] = { 8, 4, 7, 3, 2, 7, 8, 2, 3, 1, 8, 7, 7 };
		int n = arr.length;
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		for (int j = 0; j < n; j++)
			arr[j] = arr[j] - 1;
		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++)
			arr[arr[i] % n] = arr[arr[i] % n] + n;

		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++)
			System.out.println(i + 1 + "->" + arr[i] / n);
	}

	/***
	 * Remove Duplicates from Sorted Array
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 ***/
	public static int removeDuplicates(int[] nums) {
		// int arr[] = {0,0,1,1,1,2,2,3,3,4}
		int p1 = 0;
		int p2 = 1;

		while (p1 < nums.length && p2 < nums.length) {

			if (nums[p1] == nums[p2]) {
				p2++;
			} else {
				p1++;
				nums[p1] = nums[p2];
				p2++;
			}
		}

		return p1 + 1;
	}

	/** https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii **/
	public static int removeDuplicatesV2(int[] nums) {

		int p1 = 0;
		int p2 = 1;
		int cnt = 1;

		while (p1 < nums.length && p2 < nums.length) {

			if (nums[p1] == nums[p2] && cnt < 2) {
				p1++;
				nums[p1] = nums[p2];
				p2++;
				cnt++;
			} else if (nums[p1] == nums[p2]) {
				p2++;

			} else {
				p1++;
				nums[p1] = nums[p2];
				p2++;
				cnt = 1;

			}
		}
		return p1 + 1;
	}

	/**
	 * https://www.codingninjas.com/codestudio/problems/3-sum-smaller_3161884?leftPanelTab=1
	 */
	public static int threeSumSmaller(int n, int[] nums, int target) {
		// { 1, 5, 2, 3, 4, 6, 7 }
		Arrays.sort(nums); // 1,2,3,4,5,6,7
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int p1 = i + 1;
			int p2 = nums.length - 1;
			while (p1 < p2) {
				int sum = nums[i] + nums[p1] + nums[p2];
				if (sum < target) {
					res = res + p2 - p1;// 4-1,4-2,4-3
					p1++;
				} else {
					p2--;

				}
			}
		}
		return res;
	}

	public static int threeSumClosest(int[] nums, int target) {
		int res = 0;
		nums = new int[] { -4, -1, 1, 2 };
		target = 1;
		// -4,-1,1,2, tr=1
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int p1 = i + 1;
			int p2 = nums.length - 1;

			while (p1 < p2) {
				int sum = nums[i] + nums[p1] + nums[p2];
				int abs = Math.abs(target - sum);
				if (abs < diff) {
					diff = abs;
					res = sum;
				} else if (sum < target) {
					p1++;
				} else {
					p2--;
				}
			}
		}
		return res;

	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int sum = 0;
		int cnt = 0;

		for (int i = 0; i < nums.length; i++) {

			int prod = 1;
			for (int j = i; j < nums.length; j++) {

				prod = prod * nums[j];
				if (prod >= k) {
					break;
				}
				cnt++;
			}

		}
		return cnt;
	}

	public static int closestnum(int arr[], int k) {
		arr = new int[] { 1, 2, 5, 9, 17 };
		k = 19;
		int n = arr.length;
		int p1 = 0;
		int p2 = n - 1;
		int diff = Integer.MAX_VALUE;
		int ans = 0;
		int abs = 0;
		while (p1 < n && p2 >= 0) {
			abs = Math.min(Math.abs(k - arr[p1]), abs);
			if (abs < diff) {
				diff = abs;
				ans = arr[p1];
			} else if (arr[p1] < k) {
				abs = Math.abs(k - arr[p1]);
				p1++;
			} else {
				abs = Math.abs(k - arr[p2]);
				p2--;
			}
		}
		System.out.println("closestnum ans " + ans);
		return ans;
	}
}
