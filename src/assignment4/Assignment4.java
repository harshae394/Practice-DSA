package assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment4 {

    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	findAnagrams("cbaebabacd", "abc");
	int arr[] = {0, 4, 3, 2, 7, 8, 2, 3,3,9,9, 1 };
	//rotateArray(arr,arr.length);
	reverseArray(0,arr.length,arr);
	for(int i = 0; i<arr.length; i++)
	    System.out.print(arr[i]+" ");
	//findFistRepeatCharacter();
	//checkAnagrams();
	//strongPassword(11,"Ab1");
	String str ="ab_";
	char st1[] = str.toCharArray();
	//System.out.println((char)(st1[0]-32));
	//javaVsC();
	//for(int i= 0; i<arr.length;i++)
	findDuplicates();
	printRepeating(arr, arr.length);
	  //  System.out.print(arr[i]+" ");

    }

    static void rotateArray(int[] arr, int n) {
	int d=1;
	reverseArray(0,arr.length-1,arr);
	reverseArray(0,d-1,arr);
	reverseArray(d,arr.length-1,arr);
    }
    
    static void reverseArray(int low, int high, int arr[] ) {
	while(low<=high) {
	    int temp = arr[low];
	    arr[low] = arr[high-1];
	    arr[high-1] =temp;
	    high--;
	    low++;
	}
    }
    
    static void distinctWindowElementsCount() throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          int tests = Integer.parseInt(br.readLine());
          for (int i = 0; i < tests; i++) {
              String inputs[] = br.readLine().split(" ");
              int n = Integer.parseInt(inputs[0]);
              int k = Integer.parseInt(inputs[1]);
              String array[] = br.readLine().split(" ");
              
              
              String res = distinctWindowElementsCountUtils(array,n,k);
              
              bw.write(res+"\n");
              bw.flush();
          }
	
    }
    
    static String distinctWindowElementsCountUtils(String array[], int n,int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ele = 0;
        String ans= ""; //1 2 3 2 4 5 3
        for(int st = 0; st<k; st++){
            ele = Integer.parseInt(array[st]);
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        ans = ans +" "+map.size(); 
        
        for(int i = 1; i<n-k+1; i++){
            
            int prevEle = Integer.parseInt(array[i-1]) ;
            int nextEle = Integer.parseInt(array[i+k-1]);
            
            int cnt = map.get(prevEle);
            if(cnt>0) {
                map.put(prevEle,  map.getOrDefault(prevEle, 0));
            }else map.remove(prevEle);
            
            map.put(nextEle,map.getOrDefault(nextEle,0)+1);
            ans = ans+" "+map.size(); 
        }
       return ans.trim();
    }
   /* static void distinctWindowElementsCountUtils(Map<Integer,Integer> map,int ele){
	//1 2 3 2 4 5 3
        int cnt = map.get(ele);
        if(cnt>0) {
            map.put(ele,  map.getOrDefault(ele, 0));
           
        }else map.remove(ele);
    }*/
    
    private static void printWordsVowelsConsonents() throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          int tests = Integer.parseInt(br.readLine());
          for (int i = 0; i < tests; i++) {
              String word = br.readLine();
              word = word.trim();
              int totalWords =0;
              String words[] = word.split(" ");
              for(int k = 0; k<words.length;k++){
                  if(words[k].trim().length()>0) totalWords++;
              }
              String res = "";
              
              res = res + totalWords+"";
              int vCount = 0;
              int consCount = 0;
              int spceCount =0;
              char cc[] = word.toCharArray();
              for(int j = 0; j<cc.length;j++) {
                  if(cc[j]==65||cc[j]==97 ||cc[j]==69 || cc[j]==101 ||cc[j]==73 ||cc[j]==105
                      || cc[j]==79 ||cc[j]==111 ||cc[j]==85 ||cc[j]==117) {
                      vCount++;
                  }
                  if(cc[j]==32) spceCount++;
              }
              consCount = word.length()-vCount-spceCount;
              res = res +" "+ vCount +" "+consCount;
              bw.write(res+"\n");
          }
            bw.flush();
          }
    private static void findFistRepeatCharacter() throws NumberFormatException, IOException {
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int tests = Integer.parseInt(br.readLine());
         for (int it = 0; it < tests; it++) {
             String word = br.readLine();
             int count[] =new int[26];
             char arr[] = word.toCharArray();
             for(int i = 0; i<arr.length;i++) {
        	 count[arr[i]-97]++;
             }
            // for(int j=0; j<count.length;j++)
        	// System.out.print(count[j]+" ");
             //System.out.println();
            //int k = 0;
             boolean repeat =false;
             
             for(int k =0;k<arr.length;k++) {
            	 if(count[arr[k]-97] >1){
                	 repeat = true;
         	     	System.out.println(arr[k]);
         	        break;
            	 }
             }
        	
             if(!repeat) {
        	 System.out.println(".");
        	 //bw.write(".\n");
             }
            bw.flush();
         }
    	}
    
    private static void checkAnagrams() throws NumberFormatException, IOException {
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int tests = Integer.parseInt(br.readLine());
         for (int it = 0; it < tests; it++) {
             String words[] = br.readLine().split(" ");
             String word1 = words[0];
             String word2 = words[1];
             String result ="";
             if(word1.length()!=word2.length()) {
        	 result = "False";
             }
             else{
        	 int count[] =new int[26];
                 char arr1[] = word1.toCharArray();
                 char arr2[] = word2.toCharArray();
                 for(int i = 0; i<arr1.length;i++) {
            	 	count[arr1[i]-97]++;
                 }
                 for(int i = 0; i<arr2.length;i++) {
         	 	count[arr2[i]-97]--;
                 }
                 boolean anagram =true;
                 for(int i = 0; i<count.length;i++) {
                     if(count[i]!=0) {
                	 result = "False";
                	 anagram =false;
                	 break;
                     }
                 }
                 if(anagram) result = "True";
             }
            bw.write(result+"\n"); 
         }
         bw.flush();
    }
    
    private static void strongPassword(int n , String s) {
	int lcount = 0;
	int ucount = 0;
	int spcount = 0;
	int dgtcount = 0;
	String numbers = "0123456789";
	String 	lower_case = "abcdefghijklmnopqrstuvwxyz";
	String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String special_characters = "!@#$%^&*()-+";
	int res = 0;
	s ="#HackerRank";
	String c[] = s.split("");
	for(int i = 0; i<c.length ; i++) {
	    if(lower_case.contains(c[i])){
		lcount++;
	    }
	    if(upper_case.contains(c[i])){
		ucount++;
	    }
	    if(special_characters.contains(c[i])){
		spcount++;
	    }
	    if(numbers.contains(c[i])){
		dgtcount++;
	    }
	}
	//System.out.println(dgtcount);
	//#HackerRank
	//4700
	if(lcount==0)
	    res = res +1; 
	if (ucount==0)
	    res = res +1;
	if (spcount==0 )
	    res = res +1;
	if (dgtcount==0 ) {
	    res = res +1;
	}
	System.out.println("req : "+res);
	//3 //2
	//n=1;
	//Ab1 3
	//3+1
	int addC = 0;
	if(n+res < 7 && n+res!=6) { 
	    addC =  6-(res+n);
	    res = res+addC;
	}
	
	System.out.println(res);
    }
    
    //spoj JAVAC 
    private static void javaVsC() throws Exception{
	

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str =null;
	do{
	str = br.readLine();
	if(str=="" || str==null) System.exit(0);
	String resut= alterWord(str);
	System.out.println(resut);
	}while(str!=null);
    }
    
    private static String alterWord(String str) {
	String res ="";
	char c[] = str.toCharArray();
	boolean cpp= false;
	for(int i = 0; i<c.length ; i++) {
	    if(c[i]!='\0') {
		 if(c[i]==95) {
		     if(c[0]==95 || c[c.length-1]==95) return "Error!";
           	      if((c[i-1]>64 && c[i-1]<91) ||  (c[i+1]>64 && c[i+1]<91) ) {
           		return "Error!";
           	      }else {
           		  res = res+((char)(c[i+1]-32));
           		  i= i+2;
           		  cpp = true;
           	      }
       	   	}
		 else { 
        		 if(c[i]>64 && c[i]<91) {
        		     if(cpp) return "Error!";
        		     res = res+"_"+((char)(c[i]+32));
        		     i= i+1;
        		 }
		 }
		 res = res+""+c[i];
	    }
	}
	return res;
    }
    /**https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/**/
    public static List<Integer> findDuplicates() {
	int nums[]  = new int[] {4,3,2,7,8,2,2,3,9,9,1,5,11};
        List<Integer> ans = new ArrayList();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);
            int idx=val-1;
            if((idx >=0 || idx < n ) && nums[idx]<0){
                ans.add(val);
            }
            else{
                nums[idx]=-nums[idx];
            }
        }
        System.out.println("findDuplicates inp : "+Arrays.toString(nums));	
        System.out.println("findDuplicates : "+ans);	
        return ans;
    }
    static void printRepeating(int arr[], int n)
    {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
	System.out.println("printRepeating input array: "+Arrays.toString(arr));
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] += n;
        }
        System.out.println("printRepeating modified array: "+Arrays.toString(arr));
        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++)
        {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }
    /***https://leetcode.com/problems/find-all-anagrams-in-a-string
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order./**/
    
 public static List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) return result;
        
        Map<Character, Integer> pMap = new HashMap<>();
        
        // getting pattern character count
        for(char ch: p.toCharArray()){
            pMap.put(ch, pMap.getOrDefault(ch, 0)+1);
        }
         int n = p.length();
        int match = 0;
        
        for(int i = 0; i<s.length(); i++){
            //in
            char in = s.charAt(i);
            if(pMap.containsKey(in)){
                //decrement count 
                pMap.put(in, pMap.get(in)-1);
                //all character count exists in window
                if(pMap.get(in) == 0) match++;
            }
            //out
            if(i>=p.length()){
                char out = s.charAt(i-p.length());
                
                if(pMap.containsKey(out)){
                    pMap.put(out, pMap.get(out)+1);
                    
                    if(pMap.get(out) == 1) match--;
                }
            }
            //valid anagram
            if(match == pMap.size()) result.add(i-n+1);
        }
        return result;
        
    }
}
