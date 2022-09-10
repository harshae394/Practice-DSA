package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PattersTest {

	public static void main(String[] args) throws Exception {
		//piramidPatternNum();
		//righAngledTriangle();
		//hollowDiamond();
		//printPattern(15);
		//printPattern2(5);
	    //hollowDiamondV1();
	    triangleRec2(4,0);
	/*  *
	    **
	    ***
	    *****/
		
	} 
	static void triangleRec(int row, int col) {
	    if(row ==0) { 
		return;
	    }
	    if(col < row) {
		System.out.print("* ");
		triangleRec(row, col+1);
	    }else {
		System.out.println();
		triangleRec(row-1, 0);
	    }
	}
	
	static void triangleRec2(int row, int col) {
	    if(row ==0) { 
		return;
	    }
	    if(col < row) {
		triangleRec2(row, col+1);
		System.out.print("* ");
	    }else {
		triangleRec2(row-1, 0);
		System.out.println();
	    }
	}
	
	static void triangle(int row) {
	    int it = row;
	    for(int i = 0;i<row;i++) {
		for(int j=0;j<it;j++) {
		    System.out.print("* ");
		}
		it--;
		System.out.println();
	    }
	}
	static void piramidPatternNum() {
		int n =6;
		for(int i=n; i>=0;i--) {
			/*
			for(int j=n-i ; j>0;j--) {
				System.out.print(" ");	
			}*/
			for(int j = 0; j <=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void pascalpattern() {
		 Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the number of rows: ");
	 
	        int rows = sc.nextInt();        
	        for (int i= 0; i<= rows-1 ; i++)
	        {
	            for (int j=0; j<=i; j++) { 
	            	System.out.print("*"+ " "); 
	            } 
	            	System.out.println(""); 
	            } 
	        for (int i=rows-1; i>=0; i--)
	        {
	            for(int j=0; j <= i-1;j++)
	            {
	                System.out.print("*"+ " ");
	            }
	            System.out.println("");
	        }
	        sc.close();
	    }
	static void piramidPattern() {
		int n =5;
		
		for(int i=0; i<n;i++) {
			
			for(int j=2*(n-i) ; j>2;j--) {
				System.out.print(" ");	
			}
			for(int j = 0; j <=i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
			
		}
	}
	static void righAngledTriangle() {
		int n =6;
		for(int i=0; i<n;i++) {
			
			for(int j=n-i ; j>1;j--) {
				System.out.print(" ");	
			}
			for(int j = 0; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
static void hollowDiamond() {
	int n =5;
	int st = n/2;
	int cnt = 0;
	boolean flag =false;
	int spc= 0 ;
	for(int it = st; it>0 ; it--) {
        	for(int i = it; i >0; i--) {
        	    System.out.print(" ");
        	    cnt = it;
        	}
        	System.out.print("*");
        	for(int j= 0; j<(st-cnt);j++) {
        	    flag=true;
        	    spc =j;
        	  System.out.print(" ");
        	}
        	if(spc>0)
        	    for(int k =0; k<spc;k++)
        	    System.out.print(" ");
        	if(flag) System.out.print("*");
        	System.out.println();
        	
	}
	//bottmhollowDiamond(n);
  }

static void bottmhollowDiamond(int n ) {
	int st = n/2+1;
	int cnt = 0;
	boolean flag =false;
	int spc= 0 ;
	for(int it = 0; it<st ; it++) {
    	for(int i = it; i >0; i--) {
    	    System.out.print(" ");
    	    cnt = it;
    	}
    	System.out.print("*");
    	for(int j= 0; j<(st-cnt);j++) {
    	    flag=true;
    	    spc =j;
    	  System.out.print(" ");
    	}
    	if(spc>0)
    	    for(int k =0; k<spc;k++)
    	    System.out.print(" ");
    	if(flag) System.out.print("*");
    	System.out.println();
	}
}

static void printPattern(int n){
    n =n/2 +1;
    for(int i=1; i<=n; i++)
    {
       for(int j=i; j<n; j++)
       {
         System.out.print(" ");
       }
       for(int k=1; k<=2*i-1; k++)
       {
         if(k==1 || k==(2*i-1)) System.out.print("*");
         else System.out.print(" ");
       }
       System.out.println();
    }

    for(int i=n-1; i>=1; i--)
    {
       for(int j=n; j>i; j--)
       {
	   System.out.print(" ");
       }
       for(int k=1; k<=2*i-1; k++)
       {
         if(k==1 || k==2*i-1) System.out.print("*");
         else System.out.print(" ");
       }
       System.out.println();
    }
   
    
}

static void hollowDiamondV1() throws Exception{
  
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int t = 1;
    for(int k=1; k<=t; k++) {
	sb.append("Case #" + k + ":\n");
        int n = 5;
        for(int i=0; i<n; i++) {
            int index = Math.abs(i - n/2);
            for(int j=0; j<index; j++) {
        	sb.append(" ");
            }

            for(int j=index; j<n-index; j++) {
                if (j == index || j== n-index-1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

}



	


