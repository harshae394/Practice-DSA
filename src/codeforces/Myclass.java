package codeforces;

import java.util.Scanner;

public class Myclass{
    
    
    public static void main(String ars[]){
        
        Scanner sc = new Scanner(System.in);
        int len =  sc.nextInt();
        int breadth =  sc.nextInt();
        int sq =  sc.nextInt();
        System.out.println(calc(len,breadth,sq));
        
    }
   
   public static long calc(int len, int breadth, int sq){
       long len1 = len/sq;
       long bred1 = breadth/sq;
       
       
       if(len%sq!=0) {
    	   len1 = len1+1;
       } 
       
        if(breadth%sq!=0) {
        	bred1 =bred1+1;
        }
        
       return len1*bred1;
   } 
    
}