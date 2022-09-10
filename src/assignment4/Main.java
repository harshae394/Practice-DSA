package assignment4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String resut= alterWord(str);
		System.out.println(resut);
		
	}
	
	private static String alterWord(String str) {
		String res ="";
		char c[] = str.toCharArray();
		boolean cpp= false;
		String error ="Error!";
		for(int i = 0; i<c.length ; i++) {
		    if(c[i]!='\0') {
			 if(c[i]==95) {
			     if(c[0]==95 || c[c.length-1]==95) return error;
	           	      if(! (c[i-1]>96 && c[i-1]<123) &&  (c[i+1]>96 && c[i+1]<123) ) {
	           		  return error;
	           	      }else {
	           		  res = res+((char)(c[i+1]-32));
	           		  i= i+2;
	           		  cpp = true;
	           	      }
	       	   	}
			 else { 
			     	if(cpp) return error;
	        		if(c[i]>64 && c[i]<91) {
	        		    res = res+"_"+((char)(c[i]+32));
	        		    i= i+1;
	        		}
			 }
			 res = res+""+c[i];
		    }
		}
		return res;
    }
}