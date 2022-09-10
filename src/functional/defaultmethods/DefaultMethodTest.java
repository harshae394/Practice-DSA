package functional.defaultmethods;

interface InterfaceA {
	default void printSomething() {
		System.out.println("I am inside A interface");
	}
}

interface InterfaceB {
	default void printSomething() {
		System.out.println("I am inside B interface");
	}
}

public class DefaultMethodTest implements InterfaceA, InterfaceB {
	@Override
	public void printSomething() {
		// Option 1 -> Provide our own implementation.
		System.out.println("I am inside Main class");
		// Option 2 -> Use existing implementation from interfaceA or interfaceB or
		// both.
		InterfaceA.super.printSomething();
	}

	public static void main(String args[]) {
		DefaultMethodTest main = new DefaultMethodTest();
		main.printSomething();
	}
}
