package assignment8;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class Assignment8 {

    public static void main(String[] args) throws Exception{
	//equalStacks();
	//collectingMongoes();
	// TODO Auto-generated method stub
	//List<String> operations = new ArrayList<String>();
	/*operations.add("1 97");
	operations.add("2");
	operations.add("1 20");
	operations.add("2");
	operations.add("1 26");
	operations.add("1 20");
	operations.add("2");
	operations.add("3");
	operations.add("1 91");
	operations.add("3");*/
	//List<Integer> res = getStackMaxValueV1(operations);
	//System.out.println("\n"+res);
	/*List<Integer> stack = new ArrayList<Integer>();
	stack.add(1);stack.add(4);stack.add(2);stack.add(3);stack.add(6);
	System.out.println(stack);
	stack.remove(2);
	System.out.println(stack);
	stack.remove(2);
	System.out.println(stack);
	stack.remove(2);
	int a[] = {1,3,4,6,8};
	for(int i =0; i<a.length; i++)
	    System.out.print(a[i]+" ");
	System.out.println();
	
	//for(int i =1; i<=1; i++) {
	    int tmp=2;
	    System.out.println("removed "+a[tmp--]);
	    System.out.println("removed "+a[tmp]);
	    System.out.println("removed "+a[tmp--]);
	    System.out.println("removed "+a[tmp]);
	    System.out.println("removed "+a[tmp--]);
	    System.out.println("removed "+a[tmp]);
	
	for(int i =0; i<a.length; i++)
	    System.out.print(a[i]+" ");
	System.out.println();*/
	//List<Integer> stack = new ArrayList<Integer>();
	//stack.add(0, 19);
	//System.out.println("stack : "+stack);
	/*Assignment8 assign = new Assignment8();
	Solution obj= assign.new Solution();
	obj.push(10);
	System.out.println("after push stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.push(20);
	System.out.println("after push stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.push(15);
	System.out.println("after push stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.push(8);
	obj.push(8);
	System.out.println("after push stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.pop();
	System.out.println("after pop stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.pop();
	System.out.println("after pop stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.pop();
	
	System.out.println("after pop stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	//obj.pop();
	//obj.pop();
	obj.push(4);
	
	System.out.println("stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	obj.pop();
	obj.pop();
	obj.pop();
	obj.pop();
	System.out.println("stack: "+ obj.stack +", topIndx : "+obj.top +", peek : "+obj.top() +", minStack "+obj.minStack +",minTopIndx: "+obj.minTop);
	*/
	
	windowMaximum();
    }

    /*public static List<Integer> getMax(List<String> operations) {
	// Write your code here
	int stack[] = new int[operations.size()];
	int stack2[] = new int[operations.size()];
	int top = -1;
	int cnt = 0;
	int it = 0;
	int max = 0;
	List<Integer> res = new ArrayList<Integer>();
	for (String str : operations) {

	    String inp[] = str.split(" ");
	    if (inp.length > 0) {
		stack[++top] = Integer.parseInt(inp[1]);
		it = top;
		if (cnt == 0)
		    stack2[0] = stack[top];

		while (it-- != 0) {
		    int ele = stack[it];
		    max = Math.max(ele, max);
		}
		if (cnt > 0)
		    stack2[cnt] = max;
	    } else if (Integer.parseInt(inp[0]) == 2) {
		int ss = stack[top--];
	    } else if (Integer.parseInt(inp[0]) == 3) {
		res.add(stack2[cnt]);
		int tmp = cnt;
		tmp = stack2[tmp--];
	    }
	    cnt++;
	}
	return res;

    }*/
    
    /*public static List<Integer> getStackMaxValue(List<String> operations) {
	int stack[] = new int[operations.size()];
	int top = -1;
	int it = 0;
	int max = 0;
	boolean maxTo=false;
	List<Integer> res = new ArrayList<Integer>();
	for (String str : operations) {
	    String inp[] = str.split(" ");
	    if (inp.length > 1) {
		stack[++top] = Integer.parseInt(inp[1]);
		System.out.println("push : "+stack[top] +" top : "+top);
	    } else if (Integer.parseInt(inp[0]) == 2) {
		System.out.println("pop : "+stack[top--]+" top : "+top);
	    } else if (Integer.parseInt(inp[0]) == 3) {
		/*it = top;
		 System.out.println("top : "+top);
		while (it--!= 0) {
		    int ele = stack[it];
		    max = Math.max(ele, max);
		    maxTo =true;
		    //it--;
		}
		//if(maxTo) res.add(max);
	    }
	}
	for(int i= 0; i<stack.length; i++) {
	    System.out.print(stack[i] +" ");
	}
	return res;

    }*/
    public static List<Integer> getStackMaxValueV1(List<String> operations) {
	List<Integer> res = new ArrayList<Integer>();
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> maxStack = new Stack<Integer>();
	
	for (String str : operations) {
	    String inp[] = str.split(" ");
	    if (inp.length > 1) {
		int pushEle = Integer.parseInt(inp[1]);
		stack.push(pushEle);
		if(maxStack.isEmpty() || pushEle >= maxStack.peek()) 
		   maxStack.add(pushEle);
		
	    } else if (Integer.parseInt(inp[0]) == 2) {
		
		int maxEle = stack.pop();
		if(maxEle == maxStack.peek()) maxStack.pop();
		
	    } else if (Integer.parseInt(inp[0]) == 3) {
		res.add(maxStack.peek());
	    }
	}
	
	for(int i= 0; i<stack.size(); i++) {
	    System.out.print(stack.get(i) +" ");
	}
	
	return res;

    }
    
    private static void collectingMongoes() throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tests = Integer.parseInt(br.readLine());
	    for (int it = 0; it < tests; it++) {
	        int queries = Integer.parseInt(br.readLine());
	        String res = "";
	        Stack<Integer> stack = new Stack<Integer>();
	        Stack<Integer> maxStack = new Stack<Integer>();
	        bw.write("Case " + (it + 1) + ":\n");
	        for (int q = 0; q < queries; q++) {
	        String inp = br.readLine();
	         if (inp.equals("R")) {
	            if(!stack.isEmpty()) {
	                int maxEle = stack.pop();
	                if (maxEle == maxStack.peek())
	                    maxStack.pop();
	            }
	        } else if (inp.equals("Q")) {
	            if(maxStack.isEmpty()) {
	                bw.write("Empty\n");
	                res = res +"Empty\n";
	            }
	            else bw.write(maxStack.peek() + "\n");
	        }
	        else {String arr[] = inp.split(" ");
	            int pushEle = Integer.parseInt(arr[1]);
	            stack.push(pushEle);
	            if (maxStack.isEmpty() || pushEle >= maxStack.peek())
	            maxStack.add(pushEle);
	          } 
	        }
	        
	    }
	    bw.flush();
	    }
    private static void windowMaximum() throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tests = Integer.parseInt(br.readLine());
	    String sizeNWid[] = br.readLine().split(" ");
	    
	    for (int it = 0; it < tests; it++) {
	        int n = Integer.parseInt(sizeNWid[0]);
		int k = Integer.parseInt(sizeNWid[1]);
		
		String inp[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for(int i =0; i<n; i++)
		    arr[i] = Integer.parseInt(inp[i]);
		
		
		int res = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        Stack<Integer> maxStack = new Stack<Integer>();
	        
	        for(int i = 0; i<k; i++) {
	            int pushEle = arr[i];
	            stack.push(pushEle); //4 10 54 11 8 7 9 
	            if(maxStack.isEmpty()) {
	        	maxStack.push(pushEle);
	            }
	            else {
	        	if(pushEle>= maxStack.peek()) {
	        	    maxStack.pop();
	        	    maxStack.push(pushEle);
	        	}
	            }
	        }
	        System.out.println("stack : "+stack +", maxstack "+maxStack);
	        res = maxStack.peek();
	        for(int i=1; i<n-k+1; i++) {
	            int pushEle = arr[i];
	            if(pushEle>= maxStack.peek()) {
	        	    maxStack.pop();
	        	    maxStack.push(pushEle);
	            }
	            System.out.println("maxstack "+maxStack);
	            res = res + maxStack.peek();
	        }
	        
	        
	        
	        
	        /*for (int i = 0; i < n; i++) {
	            
	            
	            
	         if (inp.equals("R")) {
	            if(!stack.isEmpty()) {
	                int maxEle = stack.pop();
	                if (maxEle == maxStack.peek())
	                    maxStack.pop();
	            }
	        } else if (inp.equals("Q")) {
	            if(maxStack.isEmpty()) {
	                bw.write("Empty\n");
	                res = res +"Empty\n";
	            }
	            else bw.write(maxStack.peek() + "\n");
	        }
	        else {String arr[] = inp.split(" ");
	            int pushEle = Integer.parseInt(arr[1]);
	            stack.push(pushEle);
	            if (maxStack.isEmpty() || pushEle >= maxStack.peek())
	            maxStack.add(pushEle);
	          } 
	        }*/
	        
	    }
	    bw.flush();
	    }

    public static void equalStacks() throws Exception  {
	   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n1 = Integer.parseInt(firstMultipleInput[0]);

	        int n2 = Integer.parseInt(firstMultipleInput[1]);

	        int n3 = Integer.parseInt(firstMultipleInput[2]);

	        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        int result = equalStacksV1(h1, h2, h3);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();
	        	
	        bufferedReader.close();
	        bufferedWriter.close();
	
    }
   
    
    public static int equalStacksV1(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
	    // Write your code here
	    Stack<Integer> st1 = new Stack<Integer>();
	    Stack<Integer> st2 = new Stack<Integer>();
	    Stack<Integer> st3 = new Stack<Integer>();
	    int s1=0; int s2= 0; int s3= 0;
	    for(int i = h1.size()-1; i>=0; i--) {
	        int s = h1.get(i);
	        s1 = s1+s;
	        st1.push(s1);
	    }
	    for(int i = h2.size()-1; i>=0; i--) {
	        int s = h2.get(i);
	        s2 = s2+s;
	        st2.push(s2);
	    }
	    for(int i = h3.size()-1; i>=0; i--) {
	        int s = h3.get(i);
	        s3 = s3+s;
	        st3.push(s3);
	    }
	    
	    int max = 0;
	    while(!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty() ){
		int stack1Height = st1.peek();
		int stack2Height = st2.peek();
		int stack3Height = st3.peek();
		      
	        if(stack1Height == stack2Height && stack2Height == stack3Height){
	            max =  st1.peek();
	            return max;
	        }
	        if(stack1Height >stack2Height || stack1Height>stack3Height)
	            st1.pop();
	            if (stack1Height ==-1 || stack2Height==-1 || stack3Height==-1) return 0;
	            
	        if(stack2Height> stack1Height || stack2Height > stack3Height)
	            st2.pop();
	        if (stack1Height ==-1 || stack2Height==-1 || stack3Height==-1) return 0;
	            
	        if( stack3Height > stack2Height || stack3Height > stack1Height)
	            st3.pop();
	        if (stack1Height ==-1 || stack2Height==-1 || stack3Height==-1) return 0;
	    }
	    return max;
	    
	    }
    
    class Solution {
	Solution(){
	    
	}
	/** 
push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.**/
	public int top = -1;
	private List<Integer> stack = new ArrayList<Integer>();
	private List<Integer> minStack = new ArrayList<Integer>();
	public int minTop = -1;
	    public void push(int x) {
		top = top+1;
		stack.add(top, x);
		System.out.println("pushed: "+x+", "+stack);
		if(minStack.isEmpty() ||  x <minStack.get(minTop)) {
		    /*
		     * if(minTop!=-1 && (x <minStack.get(minTop)) ){ minStack.remove(minTop); minTop
		     * = minTop-1; }
		     */
		    	minTop = minTop+1;
			minStack.add(minTop,x);
		}
	    }

	    public void pop() {
		//int removedEle = stack.get(top);
	        if(top== -1) {
	            System.out.println("Empty");
	            return;
	        }
		int removedEle = stack.remove(top);
	        top = top-1;
		if(minTop!=-1 && removedEle == minStack.get(minTop)) {
		  minStack.remove(minTop);
		  minTop = minTop-1;
		}
	    }

	    public int top() {
		if(top==-1) return top;
		return stack.get(top);
	    }

	    public int getMin() {
		if(minTop == -1) return -1;
		return minStack.get(minTop);
	    }
	    
	}
    
    class Solution2 {
	Solution2(){
	    
	}
	/** 
push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.**/
	public int top = -1;
	private List<Integer> stack = new ArrayList<Integer>();
	private List<Integer> minStack = new ArrayList<Integer>();
	public int minTop = -1;
	    public void push(int x) {
		top = top+1;
		stack.add(top, x);
		//System.out.println("pushed: "+x+", "+stack);
		if(minStack.isEmpty() ||  x <minStack.get(minTop)) {
		    /*
		     * if(minTop!=-1 && (x <minStack.get(minTop)) ){ minStack.remove(minTop); minTop
		     * = minTop-1; }
		     */
		    	minTop = minTop+1;
			minStack.add(minTop,x);
		}
	    }

	    public void pop() {
		//int removedEle = stack.get(top);
	        if(top== -1) {
	           // System.out.println("Empty");
	            return;
	        }
		int removedEle = stack.remove(top);
	        top = top-1;
		if(minTop!=-1 && removedEle == minStack.get(minTop)) {
		  minStack.remove(minTop);
		  minTop = minTop-1;
		}
	    }

	    public int top() {
		if(top==-1) return top;
		return stack.get(top);
	    }

	    public int getMin() {
		if(minTop == -1) return -1;
		return minStack.get(minTop);
	    }
	    
	}
    
    public static void distinctEleInWindow() throws Exception{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int tests = Integer.parseInt(br.readLine());
         for (int i = 0; i < tests; i++) {
             String inputs[] = br.readLine().split(" ");
             int n = Integer.parseInt(inputs[0]);
             int k = Integer.parseInt(inputs[1]);
             String array[] = br.readLine().split(" ");
             String res = sumOfPairsUtilV1(array,n,k);
             bw.write(res+"\n");
             bw.flush();
         }
    }
    static String sumOfPairsUtilV1(String array[], int n,int k) {
        //-2 -4 -2 4 -2 
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ele = 0;
        String ans= "";
        for(int st = 0; st<k; st++){
            ele = Integer.parseInt(array[st]);
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        ans = ans +" "+map.size(); 
        //  System.out.println(map);
        
        for(int i = 1; i<n-k+1; i++){
            
            int prevEle = Integer.parseInt(array[i-1]) ;
            int nextEle = Integer.parseInt(array[i+k-1]);
           // System.out.println(prevEle +", "+nextEle);
            removeEle(map,prevEle);
            map.put(nextEle,map.getOrDefault(nextEle,0)+1);
            ans = ans+" "+map.size(); 
        }
       return ans.trim();
    }
    static void removeEle(Map<Integer,Integer> map,int ele){
        int cnt = map.get(ele);
        if(cnt>1) {
            map.put(ele, cnt-1);                                                        
        }else map.remove(ele);
    }

    static String windowMaximum(String array[], int n,int k) {
        //-2 -4 -2 4 -2 
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ele = 0;
        String ans= "";
        for(int st = 0; st<k; st++){
            ele = Integer.parseInt(array[st]);
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        ans = ans +" "+map.size(); 
        //  System.out.println(map);
        
        for(int i = 1; i<n-k+1; i++){
            
            int prevEle = Integer.parseInt(array[i-1]) ;
            int nextEle = Integer.parseInt(array[i+k-1]);
           // System.out.println(prevEle +", "+nextEle);
            removeEle(map,prevEle);
            map.put(nextEle,map.getOrDefault(nextEle,0)+1);
            ans = ans+" "+map.size(); 
        }
       return ans.trim();
    }    
    public int maxSlidingWindow(int[] a, int k) {
        
	      /* int ret [] = new int[a.length-k+1];
	        int max = Integer.MIN_VALUE;
			int cnt = 0;
			for(int i =0; i<a.length-k+1; i++) {
	            
	            max = Integer.MIN_VALUE;
	            for(int j = i ; j < i+k; j++){
	                
	                max =Math.max(max,a[j]);
	            }
				
	            ret[cnt]= max;
	            cnt++;
			}
	        return ret;*/
	        
	         int res = 0;
	     //[1,3,-1,-3,5,3,6,7] ,1,2,3,4,5,6,8
	       Deque<Integer> queue = new ArrayDeque<Integer>();
	       for(int i= 0; i<k; i++) {
	    	   while(!queue.isEmpty() && a[i]>=a[queue.getLast()]) {
	    		   queue.removeLast();
	    	   }
	    	   queue.addLast(i);
	       }
	       
	       res = a[queue.getFirst()];
	       for(int i=k; i<a.length; i++) {
	    	   
	    	   if(i-k==queue.getFirst()) {
	    		   queue.removeFirst();
	    	   }
	    	   while(!queue.isEmpty() && a[i]>=a[queue.getLast()]) {
	    		   queue.removeLast();
	    	   }
	    	   queue.addLast(i);//1,2,3
	    	   res = res+ a[queue.getFirst()];
		}
	        return res;//3,3
	    }
}


