package javaproject;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		enQueue(pQueue);
		printQueue(pQueue);
		
		pQueue = new PriorityQueue<Integer>((a,b)->b.compareTo(a));
		enQueue(pQueue);
		printQueue(pQueue);
		
		 PriorityQueue<String> pq = new PriorityQueue<>();
	        pq.add("Geeks");
	        pq.add("For");
	        pq.add("GeeksPr");
	        System.out.println("PriorityQueue: " + pq);
	  
	        // Using the peek() method
	        String element = pq.peek();
	        System.out.println("Accessed Element: " + element);
		
	}
	public static void enQueue(PriorityQueue<Integer> pQueue ) {
		
		pQueue.add(71);
		pQueue.add(8);
		pQueue.add(7);
		//pQueue.add(3);
	}
	public static void printQueue(Queue<Integer> pQueue ) {
		Iterator<Integer> it = pQueue.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
}
