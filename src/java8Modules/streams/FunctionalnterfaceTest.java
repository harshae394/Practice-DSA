package java8Modules.streams;

@FunctionalInterface
interface IFunctionalInterface {
    int multiply(int a, int b);

}

interface Greeting {
    void greet();
}

interface GreetingManner {
    void greet();
}

interface DressManner {
    void dress(String format);
}

interface FoodStyle {
    void foodStyle(String rice,String curry);
}

class IndianTradition  {

    public static void main(String[] args) {
	GreetingManner gree = () -> {
	    System.out.println("Indian-greeting!!!");
	};
	gree.greet();
	
	DressManner dressManner = (format) -> {
	    System.out.println("indian- traditional--wear - " +format);
	};
	dressManner.dress("saree-dhoti");
	
	FoodStyle foodStyle = (receipe1, receipe2) -> {
	    System.out.println("indian- foodStyle :: " + receipe1 + " " + receipe2);
	};
	foodStyle.foodStyle("rice", "dal");
    }



}

class WellWisher {

    public static void wish1(Greeting greeting) {
	greeting.greet();
    }

    // Passing a lambda expression to wish method.
    public static void main(String args[]) {

	Greeting greeting = new Greeting() {
	    @Override
	    public void greet() {
		System.out.println("###Namaste###");
	    }
	};

	greeting.greet();

	wish1(() -> {
	    System.out.println("hell1....");
	    System.out.println("helloo!!!!!!");
	});
    }
}

public class FunctionalnterfaceTest {

    public static void main(String[] args) {
	IFunctionalInterface Ifunctional = (a, b) -> {
	    System.out.println("multiply of " + a + ", " + b);
	    return a * b;
	};
	System.out.println(Ifunctional.multiply(10, 2));

    }

}
