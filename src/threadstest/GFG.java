package threadstest;

//Java implementation of the above approach
import java.util.*;

class GFG {

	// Function to find the sum
	// of minimum of all subarrays
	static int findKth(int arr[], int n, int k) {

		HashSet<Integer> missing = new HashSet<>();
		int count = 0;

		// Insert all the elements in a set
		for (int i = 0; i < n; i++) {
			missing.add(arr[i]);
		}

		// Find the maximum and minimum element
		int maxm = Arrays.stream(arr).max().getAsInt();
		int minm = Arrays.stream(arr).min().getAsInt();

		// Traverse from the minimum to maximum element
		for (int i = minm + 1; i < maxm; i++) {
			// Check if "i" is missing
			if (!missing.contains(i)) {
				count++;
			}

			// Check if it is kth missing
			if (count == k) {
				return i-1;
			}
		}

		// If no kth element is missing
		return -1;
	}

	/* This code contributed by PrinciRaj1992 */

//This code is contributed by sanjoy_62

// Driver code
	public static void main(String[] args) {
		int[] arr = { 7, 5, 7, 1 };
		int k = 3;

		// Function Call
		System.out.println("Missing kth number = " + findKth(arr,arr.length, k));
	}
}

// This code is contributed by divyesh072019.
