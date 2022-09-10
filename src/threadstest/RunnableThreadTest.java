package threadstest;
class RunnableClass implements Runnable {

    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName());

    }

}

public class RunnableThreadTest {	

    public static void main(String[] args) {
	System.out.println("main thread is running.."+Thread.currentThread().getName());
	new Thread(new Runnable() {
	    @Override
	    public void run() {
		while(true) {
		// System.out.println("thread is running.."+Thread.currentThread().getName());
		}
	    }
	}).start();
    }

}
