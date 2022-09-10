package otherChallenges;

public class TestChallenge {

    //just answer software enginer challenge 
    //https://assessment.hackerearth.com/challenges/hiring/justanswer-software-engineer-hiring-challenge/problems/664d98ac3e124f9693391291f0d2fc2d/
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	//int queries[][] = {{1,1,11},{2,4,5},{2,1,1},{1,3,8}};
	int queries[][] = {{2,1,72},{2,5,50},{2,3,21},{1,2,22},{2,5,16},{1,5,17},{1,4,79}};
	int res = findSum(5,7,queries);
	System.out.println(res);

    }
    
    static int findSum(int N, int q, int[][] queries){
	int res = 0;
	int arr[][] = new int[N][N];
	
	for(int i =0; i<q; i++) {
	    //1 1 11
	    System.out.println("row : "+(i+1));
	    if (queries[i][0] == 1) {
		fillRow(queries[i][1], queries[i][2], arr, N);
		//printData(arr, N);
		
	    } else {
		fillColumn(queries[i][1], queries[i][2], arr, N);
	    	//printData(arr, N);
	    }
	}
	
	return printData(arr, N);
    }
    static int printData(int arr[][], int N) {
	int res = 0;
	int mod =1000000007;
	for(int k =0; k<N; k++) {
	    for(int l =0; l<N; l++) {
		res = res+(arr[k][l]%mod);
		System.out.print(arr[k][l] +" ");
	    }
	    System.out.println();
	}
	return res;
    }
    static void fillRow(int rowNo, int value, int arr[][], int N) {
	System.out.println("fillRow : "+rowNo +", val: "+value);
	for(int i=0; i<N;i++) {
	    arr[rowNo-1][i]=value;
	}
    }

    static void fillColumn(int colNo, int value,int arr[][], int N) {
	System.out.println("fillColumn : "+colNo +", val: "+value);
	for(int i=0; i<N;i++) {
	    arr[i][colNo-1]=value;
	}
    }
}
