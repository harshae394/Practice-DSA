package threadstest;

import java.util.Arrays;

class PrintPrimeNumbers implements Runnable {

	static Integer[] primes = PrintPrimeNumbersTest.getPrimeNumbersSieveOfErot(30);
	static int number = 1;
	static int indx = 0;
	int rem;
	static Object lock = new Object();

	public PrintPrimeNumbers(int rem) {
		this.rem = rem;
	}

	@Override
	public void run() {
		while (number < primes.length) {
			synchronized (lock) {
				while ((rem == 2 && number >= 1 && number <= 10) || (rem == 1 && number <= 20 && number >= 11)) { // wait
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (number < primes.length && primes[number] != 0)
					System.out.println(Thread.currentThread().getName() + " - " + primes[number]);
				number++;
				lock.notify();
			}
		}
	}
}

public class PrintPrimeNumbersTest {

	static Integer[] getPrimeNumbersSieveOfErot(int num) {
		Integer primes[] = new Integer[num + 1];

		for (int i = 0; i <= num; i++) {
			primes[i] = 1;
		}
		primes[0] = 0;
		primes[1] = 0;

		for (int i = 2; i * i <= num; i++) {
			if (primes[i] == 1) {
				for (int j = 2; i * j <= num; j++) {
					primes[i * j] = 0;
				}
			}
		}
		for (int i = 2; i < primes.length; i++)
			if (primes[i] != 0)
				primes[i] = i;
		System.out.println("PrimesArray : " + Arrays.asList(primes));
		return primes;

	}

	public static void main(String[] args) {

		for (int i = 1; i <= 2; i++) {
			Thread obj = new Thread(new PrintPrimeNumbers(i), "T" + i);
			obj.start();
		}

	}
}