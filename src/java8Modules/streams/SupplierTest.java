package java8Modules.streams;

import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierTest {

    static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate) {
	return predicate.test(supplier.get());
    }

    public static void main(String[] args) {

	 Supplier<Person> supplier = () -> new Person("Alex", 23);
	 supplier = new Supplier<Person>() {
    	     @Override
    	     public Person get() {
    		 return new Person("Alex", 23);
    	     }
	 };
	 IntSupplier intSup = ()->10;
	 intSup.getAsInt();
	 Predicate<Person> predicate = (p) -> p.age > 18;
	 System.out.println(supplier.get());
	 boolean eligible = isPersonEligibleForVoting(supplier, predicate);
	 System.out.println("Person is eligible for voting: " + eligible);
	 
	 IntSupplier intSupplier = () -> (int)(Math.random() * 10); 
	 System.out.println(intSupplier.getAsInt());
    }

}
