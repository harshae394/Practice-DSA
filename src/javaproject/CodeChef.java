package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class CodeChef {

    public static void main(String[] args) throws IOException {
	//validtraingles();
	//primaryCheck(17);
	//System.out.println(TwoVsTen(18,-1));
	//printMoneyCont();
	//printtuples();
	falseNumber();
    }

    public static void printMoneyCont() {
	 Scanner sc = new Scanner(System.in);
	   // int tc = sc.nextInt();
	    //for(int it =0; it<tc;it++){
	        int D = sc.nextInt();
	        int d = sc.nextInt();
	        int P = sc.nextInt();
	        int Q = sc.nextInt();
	     System.out.println(printMoney(D,d,P,Q));   
	    //}
    }
    
    static long printMoney(int D, int d, int P, int Q){
	    if(D<=0 ) return 0;
	    if(d > 1) {
		P = P*d+Q;
		D = D-2*d;
	    }else {
		D= D-Q;
	    }
	    long res = P+ printMoney(D,d,P+Q,Q-1);
	    return res;
	}
    
    public static int TwoVsTen(int num,int cnt) {
	if(num<9 ) {
	    return -1;
	}
	if(num%10==0) {
	    cnt= cnt+1;
	    return cnt;
	} else {
	    num= num*2;
	}
	return TwoVsTen(num,cnt+1);
    }
    static void primaryCheck(int n) {
	boolean flag = true;
	
	for(int i =2; i<(Math.sqrt(n));i++) {
	    if(n % i==0) {
		flag =false;
		break;
	    }
	}
	if(flag) System.out.println("YES");
	else System.out.println("NO");
    }
    
    static void validtraingles() {
	 Scanner sc = new Scanner(System.in);
	 try {
	 while(sc.hasNextLine()) {
	     
	 int tc = Integer.parseInt(sc.nextLine());
	 System.out.println(tc);
	 int cnt = 0;
	 for(int i=0; i<tc; i++){
        	     
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());
            int c = Integer.parseInt(sc.nextLine());
            if ((a + b + c) ==180)
                System.out.println("YES");
            else
                System.out.println("NO");
           
              cnt++;
              System.out.println("cnt : "+cnt+", i "+tc);
              if(cnt+1==tc)return;
	 }
	
	 }
	 }finally {
	     System.exit(0);
             sc.close();
	 }
    }
    private static void printtuples() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        long res = 0;
        for(int it =0; it<tc;it++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long r = ((1<<n)-1)<<m;
            System.out.println("r : "+r);
            for(int i=0; i<=r; i++){
                for(int j = 0; j<=r;j++){
                    System.out.print(i+","+j+" ");
                    System.out.println("and : "+(i&j));
                    if((i & j)==0){
                	
                	res++;       
                    }
                }
                System.out.println();
            }
            
        }
        System.out.println(res*3);
    }
    
    public static void BALLOONContest() throws Exception{

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tc = Integer.parseInt(br.readLine());
	    
	    for(int it=0; it<tc;it++){
		int a[]= new int[15];
		String values[] = br.readLine().split(" ");
		for(int i = values.length-1; i>0; i--) {
		    
		    if( Integer.parseInt(values[i]) <=7){
			System.out.println(i);
			break;
		    }
		}
	        
	    }
	}
    public static void falseNumber() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String num = br.readLine();
	  if (num.substring(0, 1).equalsIgnoreCase("1")) {
      	    num =  num.substring(0, 1) + 0 + num.substring(1, num.length());
      	} else {
      	    num = "1" + num;
      	}
	System.out.println(num);
    }
    
    
}
