package threadstest;

@FunctionalInterface
interface Func {
	int cal(int xx);

	static int multi(int xx) {
		return 1 + xx;
	}

	static int multi(int xx, int yy) {
		return 1 + xx + yy;
	}

	default double getVal() {
		return 1.0;
	}
}

interface AdvFunc {
	int cal(int xx);

	static int multi(int xx) {
		return 1 + xx;
	}

	static int multi(int xx, int yy) {
		return 1 + xx + yy;
	}

	default double getVal() {
		return 1.0;
	}
}

class FuncImplAdvance implements Func,AdvFunc {
	
	@Override
	public double getVal() {
		return Func.super.getVal();
	}

	@Override
	public int cal(int xx) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class FuncImplAdv implements Func {
	@Override
	public int cal(int xx) {
		return -1;
	}

}

class FuncImpl implements Func {

	public int cal(int xx) {
		return 00;
	}

	@Override
	public double getVal() {
		System.out.println(Func.super.getVal());
		return 2.0;
	}

	public static void main(String[] args) {
		Func obj = new FuncImpl();
		System.out.println(obj.getVal());
	}
}

class ThreadJoinDemo extends Thread {
	static ThreadJoinDemo thread1;

	public void run() {
		try {
			synchronized (thread1) {
				System.out.println(Thread.currentThread().getName() + " acquired a lock on thread1");
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + " completed");
			}
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] ar) throws Exception {
		thread1 = new ThreadJoinDemo();
		thread1.setName("thread1");
		thread1.start();

		synchronized (thread1) {
			System.out.println("new ? " + Thread.currentThread().getName() + " acquired a lock on thread1");
			Thread.sleep(1000);
			thread1.join();
			System.out.println("new ? " + Thread.currentThread().getName() + " completed");
		}
	}
}
