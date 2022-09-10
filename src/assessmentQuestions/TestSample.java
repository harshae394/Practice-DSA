package assessmentQuestions;

public class TestSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,3},{2,6}};// 1 3
									// 2 6
		int row = arr.length;
		int col = arr[0].length;
		int x= 3;//arr[0][col-1];//3
		int y = 6;//arr[row-1][col-1];//6
		int res = 0;
		//(1,2)(2,3),(3,4),(3,5),(3,6) via (3,6)(5,7)	
		for(int i = 0; i<arr[0][col-1]; i++) {
			int p1 =0;//1
			int p2 = 0;//2
			while(p1 < row  && p2<col) {
				System.out.println("vl : "+p1+" p2 : "+p2);
				if(Math.abs(arr[p1][p2])< Math.abs(x) ) {
					p1++;
				} if(Math.abs(arr[p1][p2])< Math.abs(y)) {
					p2++;
				}
				if(arr[p1][p2]==x || arr[p1][p2]==y) 
					break;
				res++;
			}
		}
		System.out.println(res);
	}

}
