package javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TestClass {
	static {
		System.out.println("rrer");
		String s ="()})";
		
		String first = s.substring(0,s.length()/2);
        String half = s.substring((s.length()/2),s.length());
        
        System.out.println(first);
        System.out.println(half);
        
        char p ='(';
        if(p=='(')
        	System.out.println("open");
        Character c =new Character('n');
        if("n".equals(c.toString())) 
        	System.out.println("character");
        
        System.out.println(s.charAt(0)!=s.charAt(1));
        	for(int i = 0; i<10;i=i+2) {
        		System.out.println("i : "+i);
        	}
        
	{
		System.out.println("heloo");
	}
	}
	static String getMatch(String c){
		return "(";
	}
	
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		
		/*final int a[] = { 2, 19, 8, 15, 4,133 };
		a[1]=12;
		int b[] = new int[a.length];
		for (int i=0; i<a.length ; i++) {
			b[i] =a[i];
		}
		{
			System.out.println("hhel");
		}*/
	/*	rvereseArray(a, 0, a.length-1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}*/
		//MatricsSum();
		//matricsColSum();
		/*String s ="A";
		char c[]  = s.toCharArray();
		int asc = c[0];
		System.out.println(s.charAt(0)==61);*/
		//getOnlyVowles();
		//getVowlesConsCount();
		//verifyAllAlphabetsFound();
		//getToggledCase();
		//System.out.println(sumofDigitsRecurs(1896));
		//sumofDigitsV1();
		
		/* int trans[][] = //new int[2][2];
		   {{1,2},{3,4}};
		 for(int i = 0;i<2; i++){
             for( int j = 0; j<2; j++){
            	 	
                 // trans[j][i] = i+j;
                  System.out.print(trans[j][i] +" ");
          }
           System.out.println();*/
		//transpose();
		countArry();
      }
		
		/*String x ="123";
		int count = 0;
		for (int i = 0; i < x.length(); i++) {
			count =count + x.charAt(i);
			System.out.println(count);
			}*/
		
		//System.out.println(count);
		//reverse(b,b.length);
		/*int b[] = new int[a.length];
		int j = 1;
		
		for (int i = 0; i < a.length; i++) {
			// if(size-j<0) break;
			System.out.print(a[a.length - j] + " ");
			//b[i] = a[size - j];
			j ++;

			// System.out.print(b[i] +" ");

		}*/

static int[] arraysum() {
	int i=0; int j=10;
	 return new int[]{i,j};
}	
	
	 static void rvereseArray(int arr[],
             int start, int end)
		{
		 int temp;
		   
		 while (start < end)
		 {
		     temp = arr[start];
		     arr[start] = arr[end];
		     arr[end] = temp;
		     start++;
		     end--;
		 }
} 
	 static void reverse(int a[],int size){
         if(size==0) return;
         System.out.print(a[size-1] +" ");
         reverse(a,size-1);
    }

	 static void MatricsSum() {
		System.out.println("\nMatricsSum..");
	       int rows =2;
	       int cols = 2;
	       int a[][] = {{5,-1},
	    		   		{19,18}
	       				};
	       int colsCount =0 ;
	       for(int i = 0;i<rows; i++){
	    	   colsCount =0;
	    	   for(int j = 0; j<cols; j++){
	    		   colsCount = colsCount+a[i][j];
	    	   }
	    	   System.out.println(colsCount);
	       }
	      
	 }
	 static void matricsColSum() {
		  Scanner sc = new Scanner(System.in);
	       int rows = sc.nextInt();
	       int cols = sc.nextInt();
	       int a[][] = new int[rows][cols];
	        int count;
	        for(int i = 0;i<cols; i++){
	        	count =0;
	           for( int j = 0; j<rows; j++){
	                a[j][i] = sc.nextInt();
	                System.out.println("a["+j+"]["+i+"] = " +a[j][i]);
	                count =count+a[i][j];
	           }
	           System.out.println(count);
	         }
	        
	       /* int count =0;
	        for(int k = 0;k<rows; k++){
	              count =0;
		           for( int l = 0; l<cols; l++){
		               count= count+a[l][k];
		           }j 
		         }*/
     }
	 static void getOnlyVowles() {
		 Scanner sc = new Scanner(System.in);
	        String str = sc.next();
	        if(str==null || str=="") System.out.println("No");
	        int count= 0;
	      for(int i=0;i<str.length(); i++) {
	    	  count++;
	    		if(!(str.charAt(i)==97 || str.charAt(i)==101 || str.charAt(i)==105 ||  str.charAt(i)==111 ||  str.charAt(i)==117 || 
	        			 str.charAt(i)==65 || str.charAt(i)==69 || str.charAt(i)==73 ||  str.charAt(i)==79 ||  str.charAt(i)==85)) {
	        		 System.out.println("No");
	        		 break;
	        	}
	        	else {
	        		if(count==str.length()) System.out.println("Yes");
	        	}
	        }
	 }
	 
	 static void getVowlesConsCount() {
		 Scanner sc = new Scanner(System.in);
	        String str = sc.next();
	        if(str==null || str=="") {
	        	System.out.println("No");
	        	return;
	        }
	        int vcount = 0, ccount= 0;
	      for(int i=0;i<str.length(); i++) {
	    	 
	    	  if((str.charAt(i)>96 && str.charAt(i)<123) || (str.charAt(i)>64 && str.charAt(i)<91) ) {
		    		if(str.charAt(i)==97 || str.charAt(i)==101 || str.charAt(i)==105 ||  str.charAt(i)==111 ||  str.charAt(i)==117 || 
		        			 str.charAt(i)==65 || str.charAt(i)==69 || str.charAt(i)==73 ||  str.charAt(i)==79 ||  str.charAt(i)==85) {
		    			vcount++;
		        	}
		        	else {
		        		ccount++;
		        	}
	    	  }
	        }
	      System.out.println(vcount+ " "+ccount);
	 }
	 
	 static void verifyAllAlphabetsFound() {
		 Scanner sc = new Scanner(System.in);
	        String str = sc.next();
	        if(str==null || str=="") {
	        	System.out.println("No");
	        	return;
	        }
	        List<Character> alphabets = new ArrayList<Character>();

	        alphabets.add('a');
	        alphabets.add('b');
	        alphabets.add('c');
	        alphabets.add('d');
	        alphabets.add('e');
	        alphabets.add('f');
	        alphabets.add('g');
	        alphabets.add('h');
	        alphabets.add('i');
	        alphabets.add('j');
	        alphabets.add('k');
	        alphabets.add('l');
	        alphabets.add('m');
	        alphabets.add('n');
	        alphabets.add('o');
	        alphabets.add('p');
	        alphabets.add('q');
	        alphabets.add('r');
	        alphabets.add('s');
	        alphabets.add('t');
	        alphabets.add('u');
	        alphabets.add('v');
	        alphabets.add('w');
	        alphabets.add('x');
	        alphabets.add('y');
	        alphabets.add('z');
	        
	        str = str.toLowerCase();
	        char[] strChar = str.toCharArray();

	        for (int i = 0; i < strChar.length; i++) {

	            char inp = strChar[i];

	            if (alphabets.contains(inp)) {
	                alphabets.remove(inp);
	            }
	        }

	        if (alphabets.isEmpty())
	            System.out.println("String contains all alphabets");
	        else
	            System.out.println("String DOESN'T contains all alphabets");
	 }
	 
	 static void getDigitsInString() {
			 Scanner sc = new Scanner(System.in);
		        String str = sc.next();
		        if(str==null || str=="") {
		        	System.out.println("No");
		        	return;
		        }
		        int count= 0;
		      for(int i=0;i<str.length(); i++) {
		    	 
		    	  if((str.charAt(i)>47 && str.charAt(i)<58)) {
		    		  count++;
		    	  }
		        }
		      if (count==str.length())
		      System.out.println("Yes");
		      else System.out.println("No");
		 }
	 
	 static void getToggledCase() {
		 Scanner sc = new Scanner(System.in);
	     String str = sc.next();
	     String res="";
	      for(int i=0;i<str.length(); i++) {
	    	 
	    	  if((str.charAt(i)>96 && str.charAt(i)<123)) {
	    		  int asci = str.charAt(i)-32;
	    		  res = res + Character.toString((char)asci);
	    	  }
	    			  
	    	  else if (str.charAt(i)>64 && str.charAt(i)<91)  {
	    		  int asci = str.charAt(i)+32;
	    		  res = res + Character.toString((char)asci);
	    	  }
	        }
	      System.out.println(res);
	 }
	 
	 static void compressString() {
		 Scanner sc = new Scanner(System.in);
	     String str = sc.next();
	     String res="";
	     int num = 0;
	     int count = (num<0? num*-1:num);
	     String arr[] =  str.split("");
	     for(int i=0;i<arr.length; i++) {
	    	 
	     }
	 }
	static void sumofDigits() {
		 Scanner sc = new Scanner(System.in);
         int num = sc.nextInt();
         if(num == 0) {
        	 System.out.println(num);
        	    return;
         }
         if(num < 10) {
                System.out.println(num); 
                return;
            }
         int ct= 0;
        int res=0;
         while (num>0){
        	 int x =num%10; //100
        	 if(x>0) {
        		 if(num%10==num) {
        			res =num;
        			 if(!(ct>res)) break;
        		 }
        		 ct = ct+x;
        		 num =num/10;
        	 }else {
	        	 num=num/10; //100
	         }
         }
         if(ct>res)
         System.out.println("count : "+ct);
         else  System.out.println("num: "+ res);
         
	}
	
	static void sumofDigitsV1() {
		 Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 0) {
       	 System.out.println(num);
       	    return;
        }
        int xxx =999999999;
        if(num < 10) {
               System.out.println(num); 
               return;
           }
        int cnt = 0;
        int xx = num%10;
        if(!(xx>0)) {
        	while(num>0) {
        		num= num/10;
        		 System.out.println("single count : "+num);
        	}
        	
        	
        	return;
        }
        for(int i=num;i>0;i=i/10){     
        	cnt +=i%10;
        }
       
        System.out.println("count : "+cnt);
       
        
	}
	
	static int sumofDigitsRecurs(int num) {
         if(num == 0) {
        	    return 0;
         }
         int count =0;
         count= count+ num%10 +sumofDigitsRecurs(num/10);
         return count;
	}
	static void transpose() {
		  Scanner sc = new Scanner(System.in);
	       int rows = sc.nextInt();
	       int cols = sc.nextInt();
	       int a[][] = new int[rows][cols];
	       
	      
	       for(int i = 0;i<rows; i++){
               for( int j = 0; j<cols; j++){
                    a[j][i] = sc.nextInt();
                    System.out.print(a[j][i] +" ");
                    
               }
        }
	       
	}
	static void countArry() {
		 int[]a = {1,0,2,0,0,1,2,1};
		 int[]freq = new int[3];
		 
	        for(int val : a)
	        {
	        	System.out.print("preInc: val:"+val+", "+ freq[val] +"; ");
	            freq[val]++;
	            System.out.println("postInc:"+ freq[val] +" ");
	        }
	        System.out.println(freq[0]+","+freq[1]+","+freq[2]);
	}
	
 		/*int x = 9;
		int y= 4;
		int total=36;
		
		int up =x;
		int down  =y;
		int days= 1;
		int current_post =0;
		current_post = up;
		
		while(true) {
			days = days+1;
			current_post =current_post-down+up;//5,7,9,11,13,15,17,19,21
			if((current_post == total) || (current_post > total)) {
				break;
			}
		}
		System.out.println(days);*/
		
		/*int n=8;
		int total= n;
		int count = 0;
		int sum =0;
		if(n > 0 && n-1 >0) {
			for(int i=total; i>0;i--) {
				for(int j = 1; j<total; j++) {
					sum = i-j;
					if(sum>0) {
						count = count+sum;
					}
					total--;
					break;
				}
			}
			
		}
		System.out.println(count);
		*/
	/*	3+1	15		7/3,5,7,9,11,13,15
		5+1	6		2
		5+3	20		9*/


//3,6
		//121
	
		/*SampleTest1 obj = new SampleTest1();
		System.out.println(obj.sum(4,10));
		SampleTest1.m2(null);*/
	    
	
	static void m1(String first) {
		System.out.println("m1: "+first);
	}
	
	static void m2(String first) {
		System.out.println("m2: "+first);
		String dc ="ae";
		first =dc;
		m1(first);
	}

	private int sum(int n, int S) {
		int Z = 0;int count = 0;
			if(n!=0) {
				int temp = 1;
				for(int y = 1; y<n; y++) {
					temp = temp*10;
				}
				Z = temp*10-1;
				int x = 0;
				for(int i=temp ; i<=Z; i++) {
					int sum = 0;
					x = i;
					while(x!=0) {
						sum = sum+x%10;
						x= x/10;
					}
					//System.out.println(sum);
					if(sum == S) {
						count = count+1;
					}
				}
				return count;
			}
			return count;
		}
	
	class Solution {
	    public boolean isValid(String s) {
	        
	        if(s!=null && s!=""){
	            
	            if(s.length()==2){
	                if(s.substring(0,1).equals("}") || s.substring(0,1).equals(")") || s.substring(0,1).equals("]")) return false;
	                if(s.substring(1,2).equals(getMatch(s.substring(0,1)))){
	                    return true;
	                }else return false;
	            }
	            else{
	                if(s.length()%2==0){
	                    String first = s.substring(0,s.length()/2);
	                    String half = s.substring((s.length()/2),s.length());
	                    if(half.substring(0,1).equals("{") || half.substring(0,1).equals("(") || half.substring(0,1).equals("[")) return false;
	                    //System.out.println(first+", "+half);
	                    String halfRev[] =half.split("");
	                    half ="";
	                    for(int j = halfRev.length-1;j>-1;j--){
	                        half= half+getMatch(halfRev[j]);
	                    }
	                     
	                    //half = half.replace("]","[").replace(")","(").replace("}","{");
	                   //System.out.println("not sym: in "+half +", "+first);
	                    if(first.equals(half)){
	                        return true;
	                    }
	                    else{
	                     //   System.out.println("not sym: in ");
	                        int count = 0;
	                        for(int i= 0; i<s.length(); i=i+2){
	                            
	                           // System.out.println(s.charAt(i+1)+","+getMatch(s.charAt(i)+""));
	                            if((s.charAt(i)+"").equals("{") || (s.charAt(i)+"").equals("(") || (s.charAt(i)+"").equals("[")){
	                             if(((s.charAt(i+1)+"").equals(getMatch(s.charAt(i)+"")))){
	                                 count=count+1;
	                                             System.out.println("matched");
	                                 if(count==s.length()/2) return true;
	                                //return false;         
	                            }else{
	                                 return false;
	                             }
	                            
	                        } else
	                                 return false;
	                     }
	                    }
	                    
	                }else{
	                    return false;
	                }
	            }
	            
	        }
	        return false;
	    }
	    
	    
	    public String getMatch(String pat){
	        
	        if("(".equals(pat)) return ")";
	        if("{".equals(pat)) return "}";
	        if("[".equals(pat)) return "]";
	        if(")".equals(pat)) return "(";
	        if("}".equals(pat)) return "{";
	        if("]".equals(pat)) return "[";
	        return "";
	    }
	}
}
