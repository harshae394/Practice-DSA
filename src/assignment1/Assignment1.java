package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
interface XX{
    int xx =10;
}
class aa  implements XX{
   int yy = XX.xx; 
   
}
public class Assignment1 {

    public static void main(String[] args) throws Exception {
	generateSubArrays();
	byte a= 9;
	
	String s ="saveChangesInTheEditor";
	char c[] = s.toCharArray();
	int cnt=1;
	for(int i =0; i<c.length;i++) {
	    if(c[i]>64 && c[i]<91) {
		cnt++;
	    }
	}
	//System.out.println(cnt);
	//contiguousSubsequence();
	int x[] = {1,3,2};
	int y[] = {1,2,3};
	distanceArrayEle(x, y);
	int arr [] = {3,1,4,5,6, 8, 7};
	int[] res = nextMaxEle(arr);
	List<Integer> list = new ArrayList<Integer>();
	for(Integer val : res) list.add(val);
	System.out.println(list);
	System.out.println(isValidParentheses("{"));
	
    }
    
    public static void contiguousSubsequence() throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tests = Integer.parseInt(br.readLine());
        for (int it = 0; it < tests; it++) {
            int size = Integer.parseInt(br.readLine());
            String inputs[] = br.readLine().split(" ");
            int arr[] = new int[size];
            for(int i =0; i<size; i++ ) {
        	arr[i]= Integer.parseInt(inputs[i]);
            }
            Arrays.sort(arr);
            for (int i=0; i<arr.length; i++)
        	System.out.print(arr[i]+" ");
            System.out.println();
            int cnt=1;
            //int max = 0;
           /* for(int i = 0; i<size-1;i++) {
        	if(arr[i+1]-arr[i]==1) {
        	    cnt = cnt+1;
        	}else {
        	    cnt = 0;
        	}
        	 max = Math.max(cnt,max);
            }*/
            int max = maxContigousSubbarayySize(arr,size);
            System.out.println("**"+(max));
        }
        }
    private static int maxContigousSubbarayySize(int arr[],int n) {
	 	if(n==1){
	            return 0;
	        }
	        int i=0, j=1;
	        int max = 0;
	        while(j<n){
	            if(arr[j] - arr[j-1] == 1 ){
	                j++;
	            } else {
	                if(j-i != 1){
	                    max = Math.max(max, j-i);
	                }
	                
	                i = j;
	                    j++;
	            }
	        }
	        if(j-i != 1){
	            max = Math.max(max, j-i);
	            return max;
	        }
	        return max;
	    
    }
    private static void distanceArrayEle(int x[], int y[]) {
	int res[] = new int[x.length];
	for(int  i = 0; i<x.length; i++) {
	    for(int j = i+1; j<x.length ;j++) {
		res[i] = Math.max(Math.abs(x[j]-x[i]),Math.abs(y[j]-y[i]));
		System.out.println(res[i]);
	    }
	}
	
	
    }
    
    private static int[] nextMaxEle(int arr[]) {
	//3,1,4,5,6, 8, 7
	//4,4,5,6,8,-1,-1
	Stack<Integer> st = new Stack<Integer>();
	int res [] = new int[arr.length];
	for(int i =arr.length-1;i>=0;i--) {
	    while(!st.isEmpty() && st.peek()<=arr[i]) {
		st.pop();
	    }
	    res[i] =st.isEmpty()?-1: st.peek(); 
	    st.push(arr[i]);
	}
	return res;
    }
    public static boolean isValidParentheses(String arr) {
	
	// {[()]}
	// {}]
	Stack<Character> st = new Stack<Character>();
	for (Character c : arr.toCharArray()) {
	    if (c == '{' || c == '(' || c == '[') {
		st.push(c);
	    } else {
		if (st.isEmpty())
		    return false;
		char top = st.peek();
		if ( (c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[') ) {
		    st.pop();
		}else return false;
	    }
	}
	return st.isEmpty();
    }
    
    public static void generateSubArrays() {
	List<String> res = new ArrayList<>();
	Map<Integer,String> map = new HashMap<>();
	map.put(2,"abc");map.put(3,"def");map.put(4,"ghi");
	String inpNum= "23";
	//generate all substrings of length given inpNum
	String arr[][] = new String[3][3];
	for(int i = 2; i<=4; i++) {
	    String ele = map.get(i);
	    for(int j =0; j<ele.length(); j++) {
		arr[i-2][j] = ele.charAt(j)+"";
	    }
	    System.out.println(Arrays.toString(arr[i-2]));
	}
	 List<String> resArray = new ArrayList<>();
	 generateSubArraysUtilV1(arr, resArray);
	 // generateSubArraysUtil(arr, 0, 0,3, resArray);
	// System.out.println("postGC : "+resArray);
    }
    static void generateSubArraysUtil(String arr[][], int x, int y, int z,List<String> resArray){
	if(x+1 == arr.length|| y+1==arr.length) {
	    return ;
	}
	String ch = arr[x][y];
	
	for(int i = 0; i<z;i++) {
	    ch += arr[y][z]; 
	}
	x++;
	resArray.add(ch);
	//generateSubArraysUtil(arr, x+1, y+1, resArray);
    }
    static void generateSubArraysUtilV1(String arr[][],List<String> resArray){
	int eachCol = 0;
	/*for(int i = 0; i<arr.length && eachCol<arr[0].length; i++) {
   	 String ch = arr[i][eachCol];
   	    for(int j =arr[0].length-1; j>=0; j--) {
   		
   		for(int k =2; k<arr[0].length;k++) {
   		    ch+=arr[j][k];
   		    resArray.add(ch);
   		}
   	    }
   	 eachCol++;
   	}
       }*/
	String ch = "";
	int col = 0;
	for(int  i =0; i<arr[0].length; i++) {
	    ch = arr[i][col];
	    for(int j =1; j+1<arr[0].length; j++) {
		ch += arr[j][i];
		for(int k =arr[0].length-1; k>=0; k--) {
		    int m =0;
		    while(m < arr[0].length) {
			String ch1 = ch;
    		    ch1 = ch+ arr[k][m];
    		    resArray.add(ch1);
    		    m++;
		    }
		}
	    }
	    col++;
	}
	System.out.println("generateSubArraysUtilV1 : "+resArray);
    }
}
