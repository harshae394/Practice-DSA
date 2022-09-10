package javaproject;

// Java program for the above approach
import java.io.*;
import java.lang.*;
import java.util.*;
abstract class  ABClass{
    
 public void getM1() {
       return ;
   } 
}
class ABImpl extends ABClass{
    
    public final void getM1() {
	       return ;
	   } 
    
    public static void main(String[] args) {
	
    }
}
class GFG {

// Function to find the smallest
// substring occurring only once
    static int smallestSubstring(String a) {

	// Stores all occurences
	ArrayList<String> a1 = new ArrayList<>();

	// Generate all the substrings
	for (int i = 0; i < a.length(); i++) {
	    for (int j = i + 1; j <= a.length(); j++) {

		// Avoid multiple occurences
		if (i != j)

		    // Append all substrings
		    a1.add(a.substring(i, j));
	    }
	}
	System.out.println("a1 : " + a1);
	// Take into account
	// all the substrings
	TreeMap<String, Integer> a2 = new TreeMap<>();
	for (String s : a1)
	    a2.put(s, a2.getOrDefault(s, 0) + 1);
	System.out.println("a2 : " + a2);
	ArrayList<String> freshlist = new ArrayList<>();
	// Iterate over all
	// unique substrings
	for (String s : a2.keySet()) {

	    // If frequency is 1
	    if (a2.get(s) == 1)

		// Append into fresh list
		freshlist.add(s);
	}
	System.out.println("freshlist : " + freshlist);
	// Initialize a dictionary
	TreeMap<String, Integer> dictionary = new TreeMap<>();

	for (String s : freshlist) {

	    // Append the keys
	    dictionary.put(s, s.length());
	}
	System.out.println("dictionary : " + dictionary);
	ArrayList<Integer> newlist = new ArrayList<>();

	// Traverse the dictionary
	for (String s : dictionary.keySet())
	    newlist.add(dictionary.get(s));
	System.out.println("newlist : " + newlist);
	int ans = Integer.MAX_VALUE;

	for (int i : newlist)
	    ans = Math.min(ans, i);

	// Return the minimum of dictionary
	return ans == Integer.MAX_VALUE ? 0 : ans;
    }

// Driver Code
    public static void main(String[] args) {
	String S = "zyzyzyzz";

	System.out.println(smallestSubstring(S));
    }
}

// This code is contributed by Kingash
