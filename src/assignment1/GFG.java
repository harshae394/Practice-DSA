package assignment1;
// Java Program to Illustrate remove() Method

// of PriorityQueue class
// Where Elements are of Integer type

// Importing required classes
import java.util.*;

// Main class
// PriorityQueueDemo
public class GFG {

    // Main driver method
    public static void main(String args[]) {

	// Creating an empty PriorityQueue by
	// creating an object of integer type
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

	// Adding custom input elements
	// using add() method
	queue.add(11);
	queue.add(10);
	queue.add(22);
	queue.add(5);
	queue.add(12);
	queue.add(2);

	// Displaying the PriorityQueue
	//System.out.println("Initial PriorityQueue: " + queue);

	// Removing elements from the PriorityQueue
	// using remove() method
	while(queue.isEmpty()==false) {
	    System.out.printf("%d",queue.remove());
	    System.out.println("\n");
	}

	// Displaying the PriorityQueue elements
	// after removal
	System.out.println("PriorityQueue after removing " + "elements: " + queue);
    }
}
