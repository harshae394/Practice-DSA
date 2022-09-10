package test;

import java.util.Stack;

public class StackTest {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		push(3);
		push(1);
		push(4);
		push(-4);
		push(5);
		push(9);
		push(-5);
		System.out.println("minEle " + stack2.peek());
		push(0);
		pop();
		System.out.println("minEle " + stack2.peek());
		pop();
		pop();
		pop();
		pop();
		System.out.println("minEle " + stack2.peek());
	}

	private static void pop() {
		if(stack2.peek()==stack1.peek()) {
			stack2.pop();
		}
		stack1.pop();
	}

	private static int getMin() {
		return stack2.peek();
	}
	private static void push(int ele) {
		stack1.push(ele);

		if (stack2.isEmpty()) {
			stack2.push(ele);
		}
		if (stack2.peek() >= ele) {
			stack2.push(ele);
		}
	}

}
