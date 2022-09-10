package threadstest;

public class RaceConditionDemo implements Runnable {
	private int c = 0;

	public synchronized void increment() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int getValue() {
		return c;
	}

	@Override
	public void run() {
		this.increment();
		System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
		this.decrement();
		System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
	}

	public static void main(String args[]) {
		RaceConditionDemo counter = new RaceConditionDemo();
		Thread t1 = new Thread(counter, "Thread-1");
		Thread t2 = new Thread(counter, "Thread-2");
		Thread t3 = new Thread(counter, "Thread-3");
		t1.start();
		t2.start();
		t3.start();
	}
}
