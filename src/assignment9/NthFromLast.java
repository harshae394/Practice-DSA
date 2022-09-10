package assignment9;

// Importing required functions
import java.util.*;

class NthFromLast {
	public static Node findNthFromLast(Node head, int n) {
		// Return None if linked list is empty or value of n is less than 1
		if (head == null || n < 1) {
			return null;
		}

		// We will use two pointers head and tail
		Node tail = head;

		// Making tail 'n' nodes apart from the head
		while (tail != null && n > 0) {
			tail = tail.next;
			--n;
		}

		// Check out-of-bounds
		if (n != 0) {
			return null;
		}

		// When tail pointer reaches the end of
		// list, head is pointing at nth node.
		while (tail != null) {
			tail = tail.next;
			head = head.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Integer[][] inputList = { { -1, 2, 3, 4 }, { 10 }, { 1, 1, 2, 3, 4, 5 }, { 28, 21, 14, 7 } };
		int[] inputs = { 1, 2, 3, 4 };

		/*for (int i = 0; i < inputList.length; i++) {
			LinkedList obj = new LinkedList();
			obj.createLinkedList(Arrays.asList(inputList[i]));
			System.out.print((i + 1) + ". Original list:  ");
			obj.displayLinkedList();
			Node nthNode = findNthFromLast(obj.head, inputs[i]);
			String actualOutput = "null";
			if (nthNode != null) {
				actualOutput = String.valueOf(nthNode.data);
			}
			System.out.println("   Node no. " + inputs[i] + " from the last node: " + actualOutput);
			System.out.println(
					"-------------------------------------------------------------------------------------------------------");
		}*/
	}
}