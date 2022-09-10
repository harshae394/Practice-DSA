package test;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String compress = compressV2("aaabbccdedfeff");
		System.out.println(compress);

	}

	public static String compress(String str) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		int count = 0;
		while (i < str.length() - 1) {
			count++;
			if (str.charAt(i) != str.charAt(i + 1)) {
				result.append(str.charAt(i)).append(count);
				count = 0;
			}
			i++;
		}
		result.append(str.charAt(i)).append(count + 1);
		return result.toString();
	}
	public static String compressV2(String str) {
		StringBuilder result = new StringBuilder();
		int arr[] = new int[26];
		
		for(int i = 0; i<str.length(); i++)
			arr[str.charAt(i)-'a']++;
		System.out.println(Arrays.toString(arr));
		System.out.println(arr['e'-'a']);
		for(int i = 0; i<str.length(); i++)
			if(!result.toString().contains(str.charAt(i)+""))
			result.append(str.charAt(i)).append(arr[str.charAt(i)-'a']);
		
		return result.toString();
	}

}
