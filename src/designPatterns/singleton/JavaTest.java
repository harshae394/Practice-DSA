package designPatterns.singleton;

public class JavaTest {

	public JavaTest() {
		System.out.println("this is default constructor");
	}

	public JavaTest(String arg) {
		System.out.println("this is parametrized constructor : " + arg);
		staticModifier = arg;
		System.out.println("this is parametrized constructor : " + staticModifier);
	}

	static {
		System.out.println("This is static block, Will execute before objects creats");
	}

	private static String staticModifier = "Iam Static Field";

	private static final String finalModifier = "Iam Static Field";

	public static void main(String[] args) {
		JavaTest obj = new JavaTest();
		System.out.println(JavaTest.staticModifier);
		JavaTest obj2 = new JavaTest("newl");
		System.out.println(JavaTest.finalModifier);
		// finalModifier = "assignAgain"; can't reinitialize again //Compile time error

	}

}
