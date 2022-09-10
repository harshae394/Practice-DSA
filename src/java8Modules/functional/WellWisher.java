package java8Modules.functional;

@FunctionalInterface
interface Greeting {
	void greet();
}

public class WellWisher {

	// Passing a lambda expression to wish method.
	public static void main(String args[]) {
		Greeting ob = () -> {
			System.out.println("welcome");
		};
		ob.greet();
	}
}