package datastructures;

// Java program to implement
// the above approach
import java.util.*;

public class GFG {

// Function to count total
// number of valid subStrings
    // https://www.geeksforgeeks.org/count-of-substrings-having-all-distinct-characters/
    static int countSub(String str) {
	int n = (int) str.length();
	int ans = 0;

	int[] cnt = new int[26];

	int i = 0, j = 0;

	while (i < n) {

	    if (j < n && (cnt[str.charAt(j) - 'a'] == 0)) {

		cnt[str.charAt(j) - 'a']++;

		ans += (j - i + 1);

		j++;
	    }

	    else {

		cnt[str.charAt(i) - 'a']--;

		i++;
	    }
	}

	// Return the final
	// count of subStrings
	return ans;
    }

// Driver Code
    public static void main(String[] args) {
	String str = "bcada";

	System.out.print(countSub(str));
    }
}

// This code is contributed by amal kumar choubey
