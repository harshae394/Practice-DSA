package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MatrixOperations {

    public static void main(String[] args) throws Exception {
	//matrixDiagonalPrint();
	//searchEleInRowColSortedMatrix();
	spiralPrint();
	//diagonalPrint();
    }
    static void diagonalPrint() {
	int[][] arr = {
		   {1,   2,  3, 4},
		   {5,   6,  7, 8},
		   {9,  10, 11, 12},
		   {13, 14, 15, 16}
		  };
	
	for (int i=0;i<arr.length; i++){
	    int tmp = 0;
		for(int j =0; j<i;j++){
		System.out.print(arr[i][j]+" ");
		    tmp = j;
		}
		System.out.println();
		if(i==(tmp+1)){
			tmp--;
		}
	}

    }
    
    
    static void spiralPrint() {
	int[][] arr = {
		   {1,   2,  3, 4},
		   {5,   6,  7, 8},
		   {9,  10, 11, 12},
		   {13, 14, 15, 16}
		  };
	
	int m = arr.length;
	int n = arr[0].length;
	int k=0;//rows
	int l=0; //cols
	int it = 0;
	while(k<m && l< n) {
	    for(it = l; it< n;++it) {
		System.out.print(arr[k][it]+" ");
	    }
	    k++;
	    for(it = k; it < m; ++it) {
		System.out.print(arr[it][n-1]+" ");
	    }
	    n--;
	    if(k<m) {
    	    	for(it = n-1; it>=l; --it) {
    	    	    System.out.print(arr[m-1][it]+" ");
    	    	}
    	    	m--;
	    }
	    if(l<n) {
		for(it = m-1; it>=k; --it) {
		    System.out.print(arr[it][l]+" ");
		}
		l++;
	    }
	}
    }
    public static void searchEleInRowColSortedMatrix() throws Exception{
	 int[][] arr = {
		   {1,   2,  3, 4},
		   {5,   6,  7, 8},
		   {9,  10, 11, 12},
		   {13, 14, 15, 16}
		  };
	 int k = 9;
	 int col =arr[0].length-1;
	 int r = 0;
	 int c= col;
	 while(true) {
	     if(r==arr.length && c>0) {
		 break;
	     }
	     //System.out.println(r +" : c : "+c);
	     if(arr[r][c]==k) {
		 System.out.println("found"); return;
	     }
	     else if(arr[r][c]<k) {
		 r++;
	     }else {
		 c--;
	     }
	 }
	 System.out.println("ele not found");
	 
    }
    public static void rotateMatrixBy90Degrees() throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());

	for (int it = 0; it < tests; it++) {
	    bw.write("Test Case #"+(it+1)+":\n");
	    int size = Integer.parseInt(br.readLine());
	    int matrx[][] = new int[size][size];
	    for (int i = 0; i < size; i++) {
		String AROW_ELE_STR = br.readLine();
		String AROW_ELE_ARRY[] = AROW_ELE_STR.split(" ");
		for (int j = 0; j < size; j++) {
		    matrx[i][j] = Integer.parseInt(AROW_ELE_ARRY[j]);
		}
	    }
	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    int temp = 	matrx[i][j];
		     matrx[i][j] = matrx[j][i];
		     matrx[j][i] = temp;
		}
	    }
	    for (int j = 0; j <size; j++) {
		for (int i = size-1; i >= 0; i--) {
		    bw.write(matrx[i][j] + " ");
		}
		bw.write("\n");
	    }
	    bw.flush();
	}
    }
    
    static void matrixDiagonalPrint() {
	int[][] arr = {
		   {1,  2, 3},
		   {4,  5, 6},
		   {7,  8, 9}
		  };
      /*1 2 3 
	4 5 6
	7 8 9
	
	1
	4 2
	7 5 3
	8 6
	9 

	00
	10 01
	20 11 02
	21 12
	22
	
	*/
	int cols = arr[0].length;
	int rows = arr.length;
	for(int i = 0; i<rows ; i++) {
	    int c = 0;
	    int r = i;
	    while(c <cols && r >-1  )  {
		System.out.print(arr[r][c]+" ");
		c++;
		r--;
	    }
	    System.out.println();
	    
	}
	for(int i = 1; i<cols ; i++) {
	    int c = i;
	    int r = rows-1;
	    while(c <cols && r >-1  )  {
		System.out.print(arr[r][c]+" ");
		c++;
		r--;
	    }
	    System.out.println();
	    
	}

    }
}