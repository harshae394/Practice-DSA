package assesment.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PersistentTest {

    public static void main(String[] args) {
	int res = 0;
	int arr [] = {1,4,5,3,7,8};
	res = subArrayMinMax(Arrays.asList(new Integer[]{1,4,5,3,7,8}), 2);
	res = slidingWindowMin(arr,arr.length, 2);
	System.out.println("subArrayMinMax : "+res);
    }
    /**Find minimum element of each subarray of K size & return maximum value among all min subrray values***/
    
    public static int subArrayMinMax(List<Integer> arr, int k) {
	Deque<Integer> Queue = new LinkedList<>();
	int res = Integer.MIN_VALUE;
	for (int i = 0; i < k; i++) {
	    while (!Queue.isEmpty() && arr.get(i) <= arr.get(Queue.peekLast())) {
		Queue.removeLast();
	    }
	    Queue.addLast(i);
	}
	System.out.println("queuefirst : "+Queue);
	res = Math.max(res, arr.get(Queue.getFirst()));
	for (int j = k; j < arr.size(); j++) {
	    if (j - k == Queue.getFirst()) {
		Queue.removeFirst();
	    }
	    while (!Queue.isEmpty() && arr.get(j) <= arr.get(Queue.getLast())) {
		Queue.removeLast();
	    }
	    Queue.addLast(j);
	    res = Math.max(res, arr.get(Queue.getFirst()));
	}
	System.out.println("queueLast : "+Queue);
	return res;
    }

    public static int slidingWindowMin(int arr[], int n, int k) {
	int res[] = new int[n-k+1];
	//-3,-2,5,3,7,8//{1,4,5,3,7,8};
	Stack<Integer> stack = new Stack<Integer>();
	for(int i = 0; i <k ; i++) {
	    while(!stack.isEmpty() &&  stack.peek()>=arr[i]) {
		stack.pop();
	    }
	    stack.push(arr[i]);
	}
	System.out.println("first stack : "+stack);
	int cnt =0;
	for(int i = k; i<n; i++) {
	    if(i-k==stack.peek()) {
		stack.pop();
	    }
	    while(!stack.isEmpty() &&  stack.peek()>=arr[i]) {
		stack.pop();
	    }
	    stack.push(arr[i]);
	}
	System.out.println("stack : "+stack);
	return 0;
    }
}
