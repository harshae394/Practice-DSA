package TestAss;
// Java program to count triplets with given

// product m

import java.util.HashMap;

class GFG {

    static int countSubStringOfUniqChars(String str) {
	//abca
	int n = (int) str.length();
	int ans = 0;
	int[] cnt = new int[26];
	int i = 0, j = 0;
	while (i < n) {
	    if (j < n && (cnt[str.charAt(j) - 'a'] == 0)) {
		cnt[str.charAt(j) - 'a']++;
		ans += (j - i + 1);
		j++;
	    }else {
		cnt[str.charAt(i) - 'a']--;
		i++;
	    }
	}
	return ans;
    }

    static int countTriplets2(int arr[], int n, int m) {
	int cnt = 0;

	// Consider all triplets and count if
	// their product is equal to m
	for (int i = 0; i < n - 2; i++)
	    for (int j = i + 1; j < n - 1; j++)
		for (int k = j + 1; k < n; k++)
		    if (arr[i] + arr[j] + arr[k] == m)
			cnt++;

	return cnt == 0 ? m : cnt;
    }

    // Method to count such triplets
    static int countTriplets(int arr[], int n, int m) {
	// Store all the elements in a set
	HashMap<Integer, Integer> occ = new HashMap<Integer, Integer>(n);
	for (int i = 0; i < n; i++)
	    occ.put(arr[i], i);

	int count = 0;

	// Consider all pairs and check for a
	// third number so their product is equal to m
	for (int i = 0; i < n - 1; i++) {
	    for (int j = i + 1; j < n; j++) {
		// Check if current pair divides m or not
		// If yes, then search for (m / arr[i]*arr[j])
		if ((arr[i] * arr[j] <= m) && (arr[i] * arr[j] != 0) && (m % (arr[i] * arr[j]) == 0)) {
		    int check = m / (arr[i] * arr[j]);

		    occ.containsKey(check);

		    // Check if the third number is present
		    // in the map and it is not equal to any
		    // other two elements and also check if
		    // this triplet is not counted already
		    // using their indexes
		    if (check != arr[i] && check != arr[j] && occ.containsKey(check) && occ.get(check) > i
			    && occ.get(check) > j)
			count++;
		}
	    }
	}

	// Return number of triplets
	return count;
    }

    // Driver method
    public static void main(String[] args) {
	int arr[] = { 2, 3, 1, 6 };
	int m = 24;
	System.out.println(countSubStringOfUniqChars("abca"));
	System.out.println(countTriplets2(arr, arr.length, 3));
    }
}
