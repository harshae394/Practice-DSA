package Test2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssesmentTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "listen";
		String str2 = "tenlip";
		System.out.println(chckAnagrams(str1, str2));
	}

	static void sortHashMap(Map<String,String> map) {
		
		// map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).map(e->new LinkedList()).collect(Collectors.toMap(map, valueMapper)
		
		/*Collections.sort(map,new Comparator<Map<String,String>>() {
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
					
				return 0;
			}
		});*/
	}

	static boolean chckAnagrams(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int arr[] = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i) - 'a']++;
		}

		for (int j = 0; j < str2.length(); j++) {
			arr[str2.charAt(j) - 'a']--;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;

	}
}
