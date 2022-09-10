package assignment1;
public class PrintMatrixDiagonally {
    public static void main(String[] args) {
       /* int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20}*/
	 int[][] matrix= {
		 {5, 0, 4}, 
		 {2, 8 ,6}, 
		 {3, 7, 1} 
		 };
        printMatrixDiagonally(matrix);
        System.out.println("\nreverseDiagonal");
        printMatrixReverseDiagonally(matrix);
    }
    private static void printMatrixDiagonally(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            int row = i;
            int col = 0;
            while (row >= 0 && col < matrix[0].length) {
                System.out.print(matrix[row][col] + " ");
                col++;
                row--;
            }
            System.out.println();
        }
 
        for (int i = 1 ; i < matrix[0].length ; i++) {
            int row = matrix.length-1;
            int col = i;
 
            while (row >= 0 && col < matrix[0].length) {
                System.out.print(matrix[row][col] + " ");
                col++;
                row--;
            }
            System.out.println();
        }
    }
    private static void printMatrixReverseDiagonally(int[][] matrix) {	
	 
        for (int i = 0 ; i < matrix.length ; i++) {
            int col = (matrix[0].length)-i-1;
            int row = 0;
            int sum = 0;
            while (row >= 0 && col < matrix[0].length) {
        	sum += matrix[row][col];
                System.out.print(matrix[row][col] + " ");
                col++;
                row++;
            }
            //System.out.print(sum + " ");
            System.out.println();
        }
        for (int i = 1 ; i < matrix[0].length ; i++) {
            int col = 0;
            int row = i;
            int sum = 0;
            while (row <matrix.length && col < matrix[0].length-1) {
        	sum += matrix[row][col];
                System.out.print(matrix[row][col] + " ");
        	//System.out.print(sum + " ");
                col++;
                row++;
            }
            //System.out.print(sum + " ");
            System.out.println();
        }
       
    }
 
}