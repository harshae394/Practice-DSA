package threadstest;

import java.util.Arrays;

class PrintOddEvenThreadTest implements Runnable {

	public int MAX_NUMBER = 10;
	static int number = 1;
	int rem;
	static Object lock = new Object();

	PrintOddEvenThreadTest(int remainder) {
		this.rem = remainder;
	}

	@Override
	public void run() {
		while (number < MAX_NUMBER) {
			synchronized (lock) {
				while (number % 2 != rem) { // wait
					// System.out.println("thread - "+Thread.currentThread().getName() +" is on");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notify();
			}
		}
	}
}

public class PrintOddEvenNumbersTest {
	public static void main(String[] args) {

		/*
		 * PrintOddEvenThreadTest oddRunnable = new PrintOddEvenThreadTest(1);
		 * PrintOddEvenThreadTest evenRunnable = new PrintOddEvenThreadTest(0);
		 * 
		 * Thread t1 = new Thread(oddRunnable, "T1"); Thread t2 = new
		 * Thread(evenRunnable, "T2");
		 * 
		 * t1.start(); t2.start();
		 */
		for (int i = 0; i <= 1; i++) {
			Thread obj = new Thread(new PrintOddEvenThreadTest(i), "T" + i);
			obj.start();
		}

	}

}