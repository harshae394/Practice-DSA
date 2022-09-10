package TestAss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    // Function to check if triplet exists in an array with the given sum
    public static boolean isTripletExist(int[] nums, int target) {
	// create an empty map
	Map<Integer, Integer> map = new HashMap<>();

	// insert (element, index) pair into the map for each array element
	for (int i = 0; i < nums.length; i++) {
	    map.put(nums[i], i);
	}

	// consider each element except the last element
	for (int i = 0; i < nums.length - 1; i++) {
	    // start from the i'th element until the last element
	    for (int j = i + 1; j < nums.length; j++) {
		// remaining sum
		int val = target - (nums[i] + nums[j]);

		// if the remaining sum is found, we have found a triplet
		if (map.containsKey(val)) {
		    // if the triplet doesn't overlap, return true
		    if (map.get(val) != i && map.get(val) != j) {
			return true;
		    }
		}
	    }
	}

	// return false if triplet doesn't exist
	return false;
    }

    public static void main(String[] args) {
	int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
	int target = 6;

	if (isTripletExist(nums, target)) {
	    System.out.println("Triplet exists");
	} else {
	    System.out.println("Triplet doesn't exist");
	}
    }
}
