package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MatrixMulti {

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int tests = Integer.parseInt(br.readLine());

	for (int it = 0; it < tests; it++) {
	    String first = br.readLine();
	   // System.out.println("first : "+first);
	    String Asize[] = first.split(" ");
	    
	    int A_ROWS = Integer.parseInt(Asize[0]);
	    int A_COLS = Integer.parseInt(Asize[1]);
	    
	    int firstMtrx[][] = new int[A_ROWS][A_COLS];
	    String AROW_ELE_STR = "";
	    for (int i = 0; i < A_ROWS; i++) {
		AROW_ELE_STR = br.readLine();;//1 2: 3 -1
		String AROW_ELE_ARRY[] = AROW_ELE_STR.split(" ");//1 2
		 for (int j = 0; j < A_COLS; j++) {
			firstMtrx[i][j] = Integer.parseInt(AROW_ELE_ARRY[j]);
		    }
	    }
	    
	    String second = br.readLine();
	    String Bsize[] = second.split(" ");
	    int B_ROWS = Integer.parseInt(Bsize[0]);
	    int B_COLS = Integer.parseInt(Bsize[1]);
	    /** -------------------------------------- **/
	    int secondMtrx[][] = new int[B_ROWS][B_COLS];
	    String BROW_ELE_STR = "";
	    for (int i = 0; i < B_ROWS; i++) {
		BROW_ELE_STR = br.readLine();
		String BROW_ELE_ARRY[] = BROW_ELE_STR.split(" ");
		    for (int j = 0; j < B_COLS; j++) {
			secondMtrx[i][j] = Integer.parseInt(BROW_ELE_ARRY[j]);
			//System.out.print(secondMtrx[i][j]+" ");
		    }
		    //System.out.println();
	    }
	    
	    int A[][] = {{1,2,3},{2,3,3},{1,4,8}};
	    int B[][] = {{4,2,1},{4,3,1},{1,4,8}};
	    int res[][] = new int[A_ROWS][B_COLS];

	    int r1 = firstMtrx.length;
	    int c1 = firstMtrx[0].length;
	    int r2 = secondMtrx.length;
	    int c2 = secondMtrx[0].length;
	    for (int i = 0; i < r1; i++) {
		for (int j = 0; j < B_COLS; j++) {
		    for (int k = 0; k < r2; k++)
			res[i][j] += firstMtrx[i][k] * secondMtrx[k][j];
		}
	    }
	    for (int i = 0; i < A_ROWS; i++) {
		for (int j = 0; j < B_COLS; j++) {
		    //System.out.print(res[i][j] + " ");
		    bw.write(res[i][j] +" ");
		}
		//System.out.println();
		bw.write("\n");
	    }
	    bw.flush();
	}
    }
}