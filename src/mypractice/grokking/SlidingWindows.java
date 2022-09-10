package mypractice.grokking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
public class SlidingWindows {

	public static void main(String[] args) {
		// maxSumSubArraySizeUtil();
		// longestkSubstrUtil();
		// minWindow("ADOBECODEBANC", "ABC");
		// longestSubstringOfDistinctCharcs("abcdbea");
		characterReplacement("aabccbb", 2);
		// longestSubarrayV1();
		// longestSubstringOneCharRepeate();
		// longestSubstringWithoutRepeatingCharacters("abcdbea");
		// minWindowSubString("ADOBECODEBANC", "ABC");
		findSubstringUtils();
	}

	static void maxSumSubArraySizeUtil() {
		// Maximum Sum Subarray of Size K (easy)
		int arr[] = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		maxSumSubArraySize(arr, k);
	}

	static int maxSumSubArraySize(int arr[], int k) {
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		int ans = sum;
		for (int i = k; i < arr.length; i++) {
			sum = sum + arr[i] - arr[i - k];
			ans = Math.max(sum, ans);
		}
		System.out.println("maxSumSubArraySize: " + ans);
		return ans;
	}

	static int maxSumSubArraySizeV2(int arr[], int k) {
		// [2, 1, 5, 1, 3, 2], k=3
		int sum = 0;
		int start = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (i >= k - 1) {
				maxSum = Math.max(maxSum, sum);
				sum = sum - arr[start];
				start++;
			}
		}
		System.out.println("maxSumSubArraySizeV2: " + maxSum);
		return maxSum;
	}

	// Smallest Subarray With a Greater Sum (easy)
	// here its O(n)--TC
	public static int smallestSubWithSum(int arr[], int x) {
		// 1 3 4 7 10 10 8 10 x = 10
		int sum = 0;
		int start = 0;
		int width = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			while (sum > x) {
				width = Math.min(width, i - start + 1);
				sum = sum - arr[start];
				start++;
			}

		}
		return width;
	}

	/***
	 * find the length of the smallest contiguous subarray whose sum is greater than
	 * or equal to "S"
	 ***/
	static int findSmallestSubArray(int arr[], int S) {
		int res = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum >= S) {
				res = Math.min(res, i - start + 1);
				sum = sum - arr[start];
				start++;
			}
		}
		if (res == Integer.MAX_VALUE)
			return 0;
		return res;
	}

	static void longestkSubstrUtil() {
		String s = "araaci";// "aabacbebebe";
		int k = 2;
		System.out.println(longestkSubstrV3(s, k));
	}

	/*** Longest Substring with maximum K Distinct Characters (medium) ***/
	// String="araaci", K=2 //The longest substring with no more than '2' distinct
	// characters is "araa".
	public static int longestkSubstr(String s, int k) {
		int res = -1;
		if (s.length() < k)
			return res;
		Map<Character, Integer> map = new HashMap<>();
		int cnt = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
			if (map.get(key) == 1)
				cnt++;
			if (cnt > k) {
				res = Math.max(res, i - start);
				Character newChar = s.charAt(start);
				map.put(newChar, map.get(newChar) - 1);
				if (map.get(newChar) == 0)
					cnt--;
				start++;
			}
		}
		if (cnt == k) {
			res = Math.max(res, s.length() - start);
		}
		return res;

	}

	// String="araaci", K=2
	public static int longestkSubstrV3(String s, int k) {
		String ans = "";
		int res = -1;
		if (s.length() < k)
			return res;
		Map<Character, Integer> map = new HashMap<>();
		int cnt = 0;
		int start = 0;
		int endIndx = 0;// araaci==>araa
		int startIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
			if (map.get(key) == 1)
				cnt++;
			if (cnt > k) {
				Character newChar = s.charAt(start);
				map.put(newChar, map.get(newChar) - 1);
				if (map.get(newChar) == 0)
					cnt--;
				start++;
			}
			endIndx = i;
			if (cnt == k) {
				endIndx = i;
				startIdx = start;
				res = Math.max(res, i - start + 1);
			}
		}

		System.out.println(
				"longestkSubstrV3 : " + map.keySet() + " ans : " + s.substring(startIdx, res) + ", length : " + res);
		return res;
	}

	public int longestkSubstrV2(String s, int k) {
		int n = s.length();
		int count = 0;
		int chars[] = new int[26];
		int max = -1;
		int start = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			chars[c - 'a']++;// araaci
			if (chars[c - 'a'] == 1)
				count++;

			if (count > k) {
				chars[s.charAt(start) - 'a']--;
				if (chars[s.charAt(start) - 'a'] == 0)
					count--;
				start++;
			}
			if (count == k)
				max = Math.max(max, i - start + 1);
		}
		return max;
	}

	/** https://leetcode.com/problems/fruit-into-baskets/ **/
	public int totalFruit(int[] s) {
		int res = 0;
		int k = 2;
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0;
		for (int i = 0; i < s.length; i++) {
			Integer key = s[i];
			map.put(key, map.getOrDefault(key, 0) + 1);
			if (map.size() > k) {
				Integer newChar = s[start];
				map.put(newChar, map.get(newChar) - 1);
				if (map.get(newChar) == 0) {
					map.remove(newChar);
				}
				start++;
			}
			res = Math.max(res, i - start + 1);
		}

		return res;
	}

	/** https://leetcode.com/problems/minimum-window-substring/ **/// NOT WORKING...?
	public static String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();
		String ans = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}
		int k = 0;
		int end = 0;
		int startIdx = 0;
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			char cc = s.charAt(i);
			if (map.get(cc) != null) {
				k++;
			}
			if (startIdx == 0 && k == 1) {
				startIdx = i;
			}

			if (k == n) {
				minLen = Math.min(minLen, (i - startIdx) + 1);
				k = 0;
				end = i;
				start = startIdx;
				startIdx = 0;
			}

		}
		System.out.println("minWindow: start: " + start + " end: " + end);
		if (end + 1 == m)
			end++;
		ans = s.substring(start, end);
		System.out.println("minWindow: " + ans);
		return ans;
	}

	public static int longestSubstringOfDistinctCharcs(String str) {
		int start = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		// aabccbb
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			if (map.containsKey(cc)) {
				start = Math.max(start, map.get(cc) + 1);
			}
			map.put(cc, i);
			maxLen = Math.max(maxLen, i - start + 1);
		}
		System.out.println("longestSubstringOfDistinctCharcs : " + maxLen);
		return maxLen;
	}

	// https://github.com/kishvadde/leetcode/blob/master/16_patterns/sliding_window/hard2.js
	/** https://leetcode.com/problems/longest-repeating-character-replacement/ **/
	public static int characterReplacement(String s, int k) {
		// aabccbb, k=2
		int maxLen = 0;
		int start = 0;
		int maxRepeatCharLen = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character cc = s.charAt(i);
			map.put(cc, map.getOrDefault(cc, 0) + 1);

			maxRepeatCharLen = Math.max(maxRepeatCharLen, map.get(cc));
			int checkLen = i - start - maxRepeatCharLen + 1;
			if (checkLen > k) {
				char remainingChar = s.charAt(start);
				map.put(remainingChar, map.get(remainingChar) - 1);
				start++;
			}
			maxLen = Math.max(maxLen, i - start + 1);
		}
		System.out.println("characterReplacement: " + maxLen);
		return maxLen;
	}

	// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

	public static int longestSubarray(int[] nums) {
		int maxLen = 0;
		// [0,1,1,1,0,1,1,0,1]
		int start = 0;
		int cnt = 0;
		int zeroPosition = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				start = zeroPosition + 1;
				zeroPosition = i;
			}

			maxLen = Math.max(maxLen, (i - start + 1));
		}

		return maxLen - 1;
	}

	public static int longestSubarrayV1() {
		int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };// bbbacc
		int maxLen = 0;
		int start = 0;
		int oneCnt = 0;
		int k = 1;
		int totalCnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				oneCnt++;
			}
			totalCnt = i - start - oneCnt + 1;
			if (totalCnt > k) {
				if (nums[start] == 1)
					oneCnt--;
				start++;
			}
			maxLen = Math.max(maxLen, i - start);
		}

		return maxLen;
	}

	public static void longestSubstringOneCharRepeate() {
		String s = "babacc";
		String queryCharacters = "bcb";
		int[] queryIndices = { 1, 3, 3 };
		longestRepeating(s, queryCharacters, queryIndices);
	}

	public static int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
		int ans[] = new int[queryIndices.length];
		char charArry[] = s.toCharArray();
		for (int i = 0; i < queryIndices.length; i++) {
			charArry[queryIndices[i]] = queryCharacters.charAt(i);

			String newStr = new String(charArry);

			ans[i] = findSubStringLen(newStr);
		}
		System.out.println("longestRepeating: " + Arrays.toString(ans));
		return ans;
	}

	public static int findSubStringLen(String str) {
		int maxLen = 0;
		int cnt = 1;
		int ans = 1;// bbbacc
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				cnt++;
			} else {
				maxLen = Math.max(maxLen, cnt);
				cnt = 1;
			}
		}
		ans = Math.max(maxLen, ans);
		return ans;
	}

	/// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

	// https://www.educative.io/courses/algorithms-ds-interview/m2Y4B8MDkOR
	// Longest Substring without Repeating Characters [Sliding Window
	public static int longestSubstringWithoutRepeatingCharacters(String s) {
		int n = s.length();// aazabccbb
		int longest = 0;
		int l = 0, r = 0;
		Set<Character> window = new HashSet<>();
		while (r < n) {
			if (!window.contains(s.charAt(r))) {
				window.add(s.charAt(r));
				r++;
			} else {
				window.remove(s.charAt(l));
				l++;
			}
			longest = Math.max(longest, r - l);
		}
		return longest;
	}

	public static String minWindowSubString(String s, String p) {
		String ans = ""; // s = "ADOBECODEBANC", p = "ABC"
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < p.length(); i++)
			map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);// A=1,B=1,C=1
		int i = 0;
		int j = 0;
		int max = Integer.MAX_VALUE;
		int count = map.size();
		while (j <= s.length()) {
			if (count != 0) {
				if (j < s.length() && map.containsKey(s.charAt(j))) {
					map.replace(s.charAt(j), map.get(s.charAt(j)) - 1);
					if (map.get(s.charAt(j)) == 0)
						count--;
				}
				j++;
			} else {
				if (j - i < max) {
					max = j - i;
					ans = s.substring(i, j);
				}
				if (map.containsKey(s.charAt(i))) {
					map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
					if (map.get(s.charAt(i)) == 1)
						count++;
				}
				i++;
			}
		}
		System.out.println("minWindowSubString : " + ans);
		return ans;
	}

	// Given a string and a pattern, find out if the string contains any permutation
	// of the pattern.
	// String="oidbcaf", Pattern="abc" ans true
	// The string contains "bca" which is a substringpermutation of the given
	// pattern.
	public static boolean findPermutation(String str, String pattern) {
		int start = 0;
		int match = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++)
			map.put(pattern.charAt(i), map.getOrDefault(map.get(pattern.charAt(i)), 0) + 1);

		for (int i = 0; i < str.length(); i++) {
			char rightChar = str.charAt(i);
			if (map.containsKey(rightChar)) {
				map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
				if (map.get(rightChar) == 0)
					match++;
			}
			if (match == map.size())
				return true;
			if (i >= pattern.length() - 1) {
				char leftChar = str.charAt(i);
				if (map.containsKey(leftChar)) {
					if (map.get(leftChar) == 0)
						match--;
					map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
				}
			}

		}

		return false;
	}

	public static String findSubstring(String str, String pattern) {
		int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char chr : pattern.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			if (charFrequencyMap.containsKey(rightChar)) {
				charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
				if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
					matched++;
			}
			// shrink the window if we can, finish as soon as we remove a matched character
			while (matched == pattern.length()) {
				if (minLength > windowEnd - windowStart + 1) {
					minLength = windowEnd - windowStart + 1;
					subStrStart = windowStart;
				}
				char leftChar = str.charAt(windowStart++);
				if (charFrequencyMap.containsKey(leftChar)) {
					// note that we could have redundant matching characters, therefore we'll
					// decrement the
					// matched count only when a useful occurrence of a matched character is going
					// out of the window
					if (charFrequencyMap.get(leftChar) == 0)
						matched--;
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
				}
			}
		}
		return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
	}

	public static void findSubstringUtils() {
		System.out.println(findSubstring("aabdec", "abc"));
		System.out.println(findSubstring("aabdec", "abac"));
		System.out.println(findSubstring("abdbca", "abc"));
		System.out.println(findSubstring("adcad", "abc"));
	}

}
