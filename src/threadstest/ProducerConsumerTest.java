package threadstest;

import java.util.LinkedList;
import java.util.Queue;

class ProducerEntity implements Runnable{
	
	final Queue<Integer> queue ;
	ProducerEntity(final Queue<Integer> queue ){
		this.queue = queue;
	}
	@Override
	public void run() {
		System.out.println("producer started...");
		for (int i = 1; i<5; i++) {
			synchronized (queue) {
				while(queue.size()>=1) {
					try {
						queue.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				queue.add(i);
				System.out.println("producing :: "+ queue.peek());
				queue.notify();
			}
		}
	}
}
class ConsumerEntity implements Runnable{
	
	final Queue<Integer> queue ;
	ConsumerEntity(final Queue<Integer> queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		System.out.println("consumer started...");
		while(true) {
			synchronized (queue) {
				while(queue.size()==0) {
					try {
//						System.out.println("queue is empty::  Consumer waits..");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("consuming :: "+ queue.poll());
				queue.notify();
			}
		}
	}
	
}
public class ProducerConsumerTest {

	public static void main(String[] args) {
		final Queue<Integer> queue  = new LinkedList<Integer>();
		Thread t1 = new Thread(new ProducerEntity(queue));
		Thread t2 = new Thread(new ConsumerEntity(queue));
		t1.start();
		t2.start();
	}

}
