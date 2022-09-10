package test;

import java.util.ArrayList;
import java.util.List;

public class Test02 {

	public static void main(String[] args) {
	int arr[] = {25,7,2,12,45,8,27};
	int max = Integer.MIN_VALUE;
	int max2 = Integer.MIN_VALUE;
	//int x = (int a,  b)->a+b;
	for(int i = 0; i<arr.length ;i++) {
		if(arr[i]> max) {
			max2 = max;
			max = arr[i];
		}	
		if(arr[i] > max2 && arr[i]!= max ) {
			max2 = arr[i];
		}
		
		}

	List<Integer> ss= new ArrayList<>();
	ss.add(10);	ss.add(5);	ss.add(9);
	ss.parallelStream().forEach(System.out::println);
	System.out.println("max : "+max +"max2 : "+max2);
	}

	
	
	
}
