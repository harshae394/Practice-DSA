package javaproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class SortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = mergeIntervals();
		System.out.println("***********Result**********");
		for (int i = 0; i < res.length; i++)
			System.out.println("mergeInterval: " + Arrays.toString(res[i]));
		// int interval[][] = { { 300, 800, 300, 630, 600 }, { 312, 810, 1500, 0640, 950
		// } };
		int interval[][] = { { 100, 400 }, { 300, 500 }, { 400, 600 } };
		int ans = minRooms(interval);
		int inp[] = { 3, 1, 0 };
		sortCylicV1(new int[] { 3, 1, 5, 4, 2 });
		missingNumber(inp);
		List<Integer> miss = Arrays.asList(new Integer[] { 1, 3, 5, 4, 5 });
		missingAndRepeating(miss, miss.size());
		insertIntervalsV3();
		distinctSubString("bcada");
	}

	/*** https://leetcode.com/problems/non-overlapping-intervals/ **/// Conflicting Appointments
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < intervals.length; i++)
			System.out.println(Arrays.toString(intervals[i]));

		int res = 0;
		int start = intervals[0][0];
		int end = intervals[0][1];
		// [1,2],[1,3],[2,3],[3,4]
		for (int i = 1; i < intervals.length; i++) {

			if (end > intervals[i][0]) {
				end = Math.min(intervals[i][1], end);
				res++;
			} else {
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}

		return res;

	}

	static int[][] mergeIntervals() {

		Integer[][] intervals = { { 1, 9 }, { 4, 11 }, { 3, 5 }, { 15, 18 } };
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		// Collections.sort(null,comp);
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		// [1, 9],[3, 5],[4, 6], [15, 18]
		// [[1,3],[2,6],[8,10],[15,18]]
		for (int i = 0; i < intervals.length; i++)
			System.out.println(Arrays.toString(intervals[i]));

		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] <= end) {
				end = Math.max(intervals[i][1], end);
			} else {
				res.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			}

		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][0]);

	}

	static int[][] insertIntervals() {
		List<int[]> res = new ArrayList<>();

		int[][] intervals = { { 2, 5 }, { 6, 7 }, { 8, 9 } };
		int n = intervals.length;
		int newInterval[] = { 0, 1 };
		if (intervals == null || intervals.length == 0) {
			return new int[][] { { newInterval[0], newInterval[1] } };
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int start = 0;
		int end = Math.min(intervals[0][1], newInterval[1]);
		int i = 0;
		while (i < n && intervals[i][1] < newInterval[0]) {
			start = intervals[i][0];
			end = intervals[i][1];
			res.add(new int[] { start, end });
			i++;
		}
		int lStart = i;
		boolean nextPart = true;
		while (i < n && intervals[i][0] <= newInterval[1]) {
			start = Math.min(intervals[lStart][0], newInterval[0]);
			end = Math.max(intervals[i][1], newInterval[1]);
			i++;
			nextPart = true;
		}
		if (nextPart)
			res.add(new int[] { start, end });
		while (i < n) {
			res.add(new int[] { intervals[i][0], intervals[i][1] });
			i++;
		}
		if (!nextPart) {
			if (newInterval[0] < res.get(0)[0]) {
				int[] inserted = res.get(0);
				System.out.println("inserted: " + inserted[0] + " , " + inserted[1]);
				res = new ArrayList<>();
				res.add(new int[] { newInterval[0], newInterval[1] });
				res.add(new int[] { inserted[0], inserted[1] });

			} else
				res.add(new int[] { newInterval[0], newInterval[1] });
		}
		for (int k = 0; k < res.size(); k++)
			System.out.println("insertIntervals ans : " + Arrays.toString(res.get(k)));
		return res.toArray(new int[0][0]);
	}

	public static int[][] insertIntervalsV3() {
		// { {1,3},{6,9},{12,25}};
		// {2,5};
		int[][] intervals = { { 2, 5 }, { 6, 7 }, { 8, 9 } };
		int newInterval[] = { 0, 1 };
		if (intervals == null || intervals.length == 0)
			return new int[][] { { newInterval[0], newInterval[1] } };
		if (newInterval == null || newInterval.length == 0)
			return intervals;

		List<int[]> res = new ArrayList<>();
		int n = intervals.length;

		int start = newInterval[0];
		int end = newInterval[1];
		int i = 0;
		while (i < n && intervals[i][1] < start) {
			res.add(new int[] { intervals[i][0], intervals[i][1] });
			i++;
		}
		while (i < n) {
			if (intervals[i][0] <= end) {
				start = Math.min(intervals[i][0], start);
				end = Math.max(intervals[i][1], end);
			} else {
				res.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			}
			i++;
		}
		res.add(new int[] { start, end });
		for (int p = 0; p < res.size(); p++)
			System.out.println("insertIntervalsV3 res :" + Arrays.toString(res.get(p)));
		return res.toArray(new int[res.size()][res.size()]);
	}

	static int[][] insertIntervals2(int[][] intervals, int[] newInterval) {

		// base condition
		if (intervals.length == 0)
			return new int[][] { newInterval };

		// define start and end
		int start = newInterval[0];
		int end = newInterval[1];

		List<int[]> output = new ArrayList<>();

		// to insert any interval in sorted array we need to find the place where it
		// needs to be added
		// to do that we will first add all intervals in output list which has end less
		// than new interval
		int i = 0;
		while (i < intervals.length && intervals[i][1] < start) {
			output.add(new int[] { intervals[i][0], intervals[i][1] });
			i++;
		}

		// once we found the place where new interval should be added using above while
		// loop we will use same logic as merge interval
		// we will compare new interval and current interval. If merging needed we will
		// merge and add it in the list.
		while (i < intervals.length) {
			if (intervals[i][0] <= end) {
				start = Math.min(start, intervals[i][0]);
				end = Math.max(end, intervals[i][1]);
			} else {
				output.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			}
			i++;
		}

		// add last remaining interval
		output.add(new int[] { start, end });

		// convert list to 2d array
		int[][] insertInterval = output.toArray(new int[output.size()][]);

		// return
		return insertInterval;
	}

	/***
	 * https://www.codingninjas.com/codestudio/problems/meeting-room-ii_893289?leftPanelTab=0
	 **/
	public static int minRooms(int[][] intervals) {/// { { 100,400}, { 300, 500},{400,600},{600,700} };
		int n = intervals.length;
		int start[] = new int[n];
		int end[] = new int[n];
		int res = 1;
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i][0];// 100,300,400,600 all start times
			end[i] = intervals[i][1]; // 400,500,600,700
		}
		Arrays.sort(start);
		Arrays.sort(end);
		System.out.println("MinRoomsstart : " + Arrays.toString(start));
		System.out.println("MinRoomsend : " + Arrays.toString(end));
		int i = 1;
		int j = 0;
		int minRoom = 1;
		while (i < n && j < n) {
			if (start[i] < end[j]) {
				minRoom++;
				i++;
			} else if (start[i] >= end[j]) {
				minRoom--;
				j++;
			}
			res = Math.max(res, minRoom);
		}
		System.out.println("minRoomsAns :" + res);
		return res;
	}

	// Cycle sort --cyclic sort
	// Each object, when created, was assigned a unique number from the range 1 to n
	// based on their creation sequence. This means that the object with sequence
	// number 3 was created just before the object with sequence number 4.
	/**
	 * https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY
	 **/
	static void sortCylic(int arr[]) {
		int n = arr.length;
		int i = 0;
		// [3, 1, 5, 4, 2]
		//2 6 4 3 1 5
		while (i < n) {
			if (arr[i] - 1 == i) {
				i++;
			} else {
				int temp = arr[i];
				int k = arr[i] - 1;
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		System.out.println("sortCylicRes : " + Arrays.toString(arr));
	}

	/*** https://leetcode.com/problems/missing-number/ **/
	public static int missingNumber(int[] arr) {
		int i = 0;// 2,3,1,5
		while (i < arr.length) {
			if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
				// swap
				int j = i;
				int k = arr[i];

				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;

			} else {
				i++;
			}
		}
		System.out.println("missingNumberSort : " + Arrays.toString(arr));
		int res = arr.length;
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] != x) {
				res = x;
				break;
			}
		}
		System.out.println("missingNumberRes: " + res);
		return res;
	}

	public static int[] missingAndRepeating(List<Integer> arr, int n) {
		int i = 0;
		int ans[] = new int[] { -1, -1 };
		while (i < n) {// {1, 3,5, 4, 5}
			if (arr.get(i) != arr.get(arr.get(i) - 1)) {
				int j = arr.get(i) - 1;
				int temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			} else {
				i++;
			}
		}
		// System.out.println("sorted: "+ arr);

		for (int p = 0; p < n; p++) {
			if (arr.get(p) != p + 1) {
				ans[0] = p + 1;
				ans[1] = arr.get(p);
				break;
			}
		}
		// System.out.println("missing : "+Arrays.toString(ans));
		return ans;

	}

	// pratice
	static void sortCylicV1(int arr[]) {
		// [3, 1, 5, 4, 2]
		int i = 0;
		while (i < arr.length) {
			if (arr[i] != arr[arr[i] - 1]) {
				int temp = arr[arr[i] - 1];//5
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			} else {
				i++;
			}
		}
		System.out.println("sortCylicV1 : " + Arrays.toString(arr));
	}

	public int firstMissingPositive(int[] arr) {
		int i = 0;

		while (i < arr.length) {
			if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
				int x = i;
				int y = arr[i] - 1;
				int temp = arr[x];
				arr[x] = arr[y];
				arr[y] = temp;
			} else {
				i++;
			}
		}
		System.out.println("res : " + Arrays.toString(arr));
		int res = arr.length;
		for (int p = 0; p < arr.length; p++) {
			if (arr[p] != p + 1) {
				return p + 1;
			}
		}
		return res + 1;
	}

	public static int maximumSumOfNonAdjacentElements(int element[]) {
		int choose = element[0];
		int discard = 0;

		for (int i = 1; i < element.length; i++) {
			int Nchoice = discard + element[i];
			int Ndiscard = Math.max(choose, discard);

			choose = Nchoice;
			discard = Ndiscard;
		}

		int res = Math.max(choose, discard);
		return res;
	}

	public int uniqueLetterString(String s) {
		List<Integer>[] lastSeen = new List[26];

		int ret = 0;
		int idx1, idx2;

		for (int i = 0; i < s.length(); i++) {
			if (lastSeen[s.charAt(i) - 'A'] == null) {
				lastSeen[s.charAt(i) - 'A'] = new ArrayList<>();
			}

			lastSeen[s.charAt(i) - 'A'].add(i);

			for (int k = 0; k < 26; k++) {
				if (lastSeen[k] != null && lastSeen[k].size() >= 2) {
					idx1 = lastSeen[k].get(lastSeen[k].size() - 1);
					idx2 = lastSeen[k].get(lastSeen[k].size() - 2);
					ret += idx1 - idx2;
				} else if (lastSeen[k] != null && lastSeen[k].size() == 1) {
					ret += lastSeen[k].get(0) + 1;
				}
			}
		}
		return ret;

	}

	static int distinctSubString(String S) {
		int count = (S.isEmpty()) ? 0 : 1;
		S = S.toLowerCase();
		HashSet<Character> letters = new HashSet<Character>();
		for (int i = 0; i < S.length(); i++) {
			if (letters.contains(S.charAt(i))) {
				letters.clear();
				count++;
			}
			letters.add(S.charAt(i));
		}
		System.out.println("distinctSubString cont : " + count);
		return count;
	}
}
