package threadstest;

class ThreadDemoTest implements Runnable {

    @Override
    public void run() {
	Thread childThread = Thread.currentThread();
	for (int i = 0; i < 5; i++) {
	    System.out.println("Inside Child Thread :" + childThread.getName());
	    try {
		m1();
		m2();
		Thread.sleep(200);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    synchronized void m1() {
	System.out.println("In m1 A");
    }

    synchronized void m2() {
	System.out.println("In m2 A");
    }
}

public class ThreadsTest {

    public static void main(String[] args) {
	 System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
	Thread t1 = new Thread(new ThreadDemoTest());
	Thread t2 = new Thread(new ThreadDemoTest());
	t1.start();
	t2.start();

    }

}
