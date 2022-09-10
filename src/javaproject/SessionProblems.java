package javaproject;

public class SessionProblems {

	public static void main(String[] args) {
		int a[] = {0,1,0,1,1,1,1,0,1,0};
		/*sortArray(a);
		for(int i = 0; i<a.length ; i++) {
			System.out.print(a[i]+" ");
		}*/
		int n=5;
		int count=0,min=0; 
		while(n>0) { 
		if(n%2==1) { 
			count++; 
			if(count>=min) {
				min=count; 
			} 
		} else {
			count=0; 
		} n=n/2; 
		  
		}
		System.out.println(min);
	}
	

	private static void sortArray(int a[]) {

		int zerosCount = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				zerosCount++;
		}
		int cnt = 0;
		for (int j = 0; j < a.length; j++) {
			cnt++;
			if (zerosCount >= cnt)
				a[j] = 0;
			else
				a[j] = 1;
		}
	}

}
