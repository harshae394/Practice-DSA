package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CodeForces {

    public static void main(String[] args) {
	//waterMelonEqualparts(10);
	//teamsProbmsSolving();
	//beautifulMatrix();
	getWordcase("Lock");
    }
    
    public static void waterMelonEqualparts(int num) {
	if( num %2==0) {
	    waterMelonEqualparts(num/2);
	    return;
	}else {
	    System.out.println("NO");
	}
    }

    public static void waterMelonEqualpartsRecursion(int num) {
	if(num==0 || (num-1)==0) {
	    System.out.println("NO");
	    return;
	}
	if(num%2==0) {
	    System.out.println("YES");
	    return;
	} else {
	    num= num-1;
	}
	waterMelonEqualpartsRecursion(num);
    }
    
    public static void teamsProbmsSolving() {
	//231A
	Scanner sc = new Scanner(System.in);
        int tc =  sc.nextInt();
            int ans = 0;
            for(int i= 0; i<tc; i++){
                int cnt=0;
                for(int j= 0; j<3; j++){
                    int pr =  sc.nextInt();
                    if(pr==1) {
                	cnt++;
                	if(cnt > 1) { 
                	    if(cnt > 1 && cnt==2)
                	    ans = ans+1;
                	}
                    }
                    
                }
            }
         System.out.println(ans);     
        }
    
	public static void beautifulMatrix() {
	    // 263A
	    Scanner sc = new Scanner(System.in);
	    int ans = 0;
	    boolean flag= false;
	    for (int i = 0; i < 5; i++) {
		for (int j = 0; j <5; j++) {
		   int num=  sc.nextInt();
	            if(num==1) {
	        	ans=Math.abs(i-2)+Math.abs(j-2);
	        	//flag =true;
	            }
		}
		//if(flag) break;
	    }
	    System.out.println(ans);
	}
	    /*
	    for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
		    
		    if (arr[i][j] == 1) {
			if (i == 2 && j == 2) {
			    System.out.println(0);
			   return;
			} else {
			    if (i < 3 || j<3) {
				if(j==2) {
				   if(i==0)
				       System.out.println(j);
				   else System.out.println(i);
				}
				else if(i==2) {
				    System.out.println(4-j-i);
				}
				else {
				    System.out.println(8-j-i);
				}
			    }
			    return;
			}
		    }
		}
	    }*/
	private static void getWordcase(String word) {
	    char array[] = word.toCharArray();
	    String result ="";
	    if(verifycapsLock(array)) {
		 if(!(array[0]<91 && array[0]>64)) {
			int asci = word.charAt(0)-32;
			result =  Character.toString((char)asci);
		    }
		for(int i=1; i<array.length; i++) {
			 if(!(array[i]<123 && array[i]>96)) {
			     result += (char) (array[i]+32); 
			 }
		    }
		System.out.print(result);
	    }else {
		System.out.print(word);
	    }
	    
	}
	
	private static boolean verifycapsLock(char array[]) {
	  int lcnt = 0; int ucnt = 0;
	    for(int i=1; i<array.length; i++) {
		 if((array[i]<123 && array[i]>96)) {
		     lcnt++;
		 }else {
		     ucnt++;
		     if(ucnt>=1 && lcnt>=1) return false;
		 }
	    } 
	     return true;
	}
}

	


