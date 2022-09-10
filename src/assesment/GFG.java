package assesment;

// Java program to find the count of
// all unique sub-Strings with
// non-repeating characters
import java.util.*;

class GFG {

// Function to count all unique
// distinct character subStrings
    static int distinctSubString(String P, int N) {
	// Hashmap to store all subStrings
	HashSet<String> S = new HashSet<String>();

	// Iterate over all the subStrings
	for (int i = 0; i < N; ++i) {

	    // Boolean array to maintain all
	    // characters encountered so far
	    boolean[] freq = new boolean[26];

	    // Variable to maintain the
	    // subString till current position
	    String s = "";

	    for (int j = i; j < N; ++j) {

		// Get the position of the
		// character in the String
		int pos = P.charAt(j) - 'a';

		// Check if the character is
		// encountred
		if (freq[pos] == true)
		    break;

		freq[pos] = true;

		// Add the current character
		// to the subString
		s += P.charAt(j);

		// Insert subString in Hashmap
		S.add(s);
	    }
	}

	return S.size();
    }

// Driver code
    public static void main(String[] args) {
	String S = "xxxxx";
	int N = S.length();

	System.out.print(distinctSubString(S, N));
    }
}

// This code is contributed by Rajput-Ji
