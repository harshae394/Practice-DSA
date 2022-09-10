package threadstest;

class PrintOddEven implements Runnable {
    int max = 10;
    static int num = 1;
    int remainder = 0;
    static Object lock = new Object();

    public PrintOddEven(int remainder) {
	this.remainder = remainder;
    }
    @Override
    public void run() {
        while (num < max) {
            synchronized (lock) {
                while (num % 2 != remainder) { // wait
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + num);
                num++;
                lock.notify();
            }
        }
    }
}
public class PrintOddEvenTest {
    public static void main(String[] args) {
	PrintOddEven oddRunnable = new PrintOddEven(1);
	PrintOddEven evenRunnable = new PrintOddEven(0);

	Thread t1 = new Thread(oddRunnable, "T1");
	Thread t2 = new Thread(evenRunnable, "T2");

	t1.start();
	t2.start();
    }

}
