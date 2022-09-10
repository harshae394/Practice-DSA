package testturvo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String arr[][] = { { "Mumbai", "Maharashtra", "+9134567" }, 
				{ "Delhi", "Delhi", "+1234567" },
				{ "Punjab", "+5412312", "Chandigarh" }, 
				{ "Maharashtra", "+5412312", "Pune" },
				{ "Hyderabad", "+1234567", "Telanagana" }};//0,2,3 | 1,4
		Map<String,Set<Integer>> map = new HashMap<>();
		Set<Integer> list = new HashSet<>();
		Set<Integer> matching = new HashSet<>();
		List<Integer> notmatching = new ArrayList<>();
		for(int i = 0; i<arr.length; i++)
				notmatching.add(i);
		for(int i = 0; i<arr.length ; i++) {
			for(int j =0; j<arr[0].length; j++) {
				list = new HashSet<>();
				String ele1 = arr[i][j];
				System.out.println("ele1: "+ele1);
				if(map.containsKey(ele1)) {
					map.get(ele1).add(i);
				}
				else {
					list.add(i);
					map.put(ele1, list);
				}
			}
		}
		System.out.println("map : "+map);
		for(Map.Entry<String, Set<Integer>> vals : map.entrySet()) {
			if(vals.getValue().size()>1) {
				matching.addAll(vals.getValue());
			}
		}
		System.out.println("matching : "+matching);
		List<Integer> res2 = new ArrayList<>();
		for(Integer ob : matching) {
			if(!notmatching.contains(ob)) {
				res2.add(ob);
			}
		}
		System.out.println("notmatching : "+res2);
	}

}
