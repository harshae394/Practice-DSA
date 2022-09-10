package interviewTest;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
	int res = 0;
	//res = numRabbits(new int[] {2,2,2, 2,2,2, 2, 1,1,1,1,1});
	res = numRabbits(new int[] {3,3,3,3,3,10});
	System.out.println(res);
    }

    /** DPWorld **/
    /** https://www.geeksforgeeks.org/minimum-number-of-rabbits-that-must-be-present-in-the-forest/**/
    public static int numRabbits(int[] answers) {
	Map<Integer, Integer> map = new HashMap<>();
	int n = answers.length;
	int res = 0;
	for (int i = 0; i < n; i++) {
	    int x = answers[i];
	    if (x == 0) {
		res++;
		continue;
	    }
	    if (!map.containsKey(x)) {
		res = res + (x + 1);
		map.put(x, 0);
	    } else {
		map.put(x, map.getOrDefault(x, 0) + 1);
		if (map.get(x) == x) {
		    map.remove(x);
		}
	    }
	}
	return res;
    }
}
