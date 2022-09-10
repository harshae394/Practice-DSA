package functional.defaultmethods;

interface IStatic {
	static void cleanVehicle() {
		System.out.println("I am cleaning IStatic");
	}
}

class StaticImpl implements IStatic {
	static void cleanVehicle() {
		System.out.println("I am cleaning StaticImpl");
	}

	public static void main(String[] args) {
		IStatic ob = new StaticImpl();
		IStatic.cleanVehicle();
	}
}

public class StaticMetodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
