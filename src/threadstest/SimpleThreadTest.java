package threadstest;

import java.util.HashMap;
import java.util.Map;

class ThreadClass extends Thread {

	// static Map<String,Integer> map = new HashMap<String,Integer>();
	// int value = 0;
	@Override
	public void run() {
		// value++;
		// map.put(Thread.currentThread().getName(), value);
		System.out.println(System.currentTimeMillis() + "-thread running-" + Thread.currentThread().getName());
	}
}

public class SimpleThreadTest {
	static int size = 5;

	private static Thread[] threads = new ThreadClass[size];

	static ThreadClass obj = new ThreadClass();

	public static void main(String[] args) {
		for (int i = 0; i < size; i++) {
			threads[i] = new Thread(obj);
			threads[i].start();
		}
		// System.out.println(ThreadClass.map);
		/*
		 * threads[2].start(); System.out.println(ThreadClass.map); threads[3].start();
		 */
	}

}
