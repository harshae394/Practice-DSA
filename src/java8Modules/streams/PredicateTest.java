package java8Modules.streams;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

class Task {
	
}
public class PredicateTest {

	CompletableFuture<Task> future = new CompletableFuture<>();
    static boolean isNumberLessThanTen(Predicate<Integer> predicate) {
	return predicate.test(9);
    }

    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
	return predicate.test(person);
    }

    static boolean isPersonEligibleForMembership(Person person, Predicate<Person> predicate) {
	return predicate.test(person);
    }

    static boolean negateTest(Predicate<Integer> predicate, int value) {
	return predicate.negate().test(value);
    }

    static boolean isPersonEligibleForVoting(Person person, Integer minAge, BiPredicate<Person, Integer> predicate) {
	return predicate.test(person, minAge);
    }

    public static void main(String[] args) {
	Person person = new Person("person1", 59);
	// System.out.println("hello");
	Predicate<Integer> predicate = new Predicate<Integer>() {

	    @Override
	    public boolean test(Integer t) {
		// TODO Auto-generated method stub
		return t>20;
	    }
	    
	};
	System.out.println(isNumberLessThanTen(predicate));

	// #####################
	Predicate<Person> predicate2 = (p) -> p.age > 10;
	System.out.println(isPersonEligibleForVoting(person, predicate2));

	// #####################
	Predicate<Person> greaterThanEighteen = (p) -> p.age > 18;
	Predicate<Person> lessThanSixty = (p) -> p.age < 60;
	Predicate<Person> predicate3 = greaterThanEighteen.and(lessThanSixty);
	System.out.println(isPersonEligibleForMembership(person, predicate3));

	// #####################
	Predicate<Person> lessThanFifty = (p) -> p.age < 49;
	Predicate<Person> orPredicate = greaterThanEighteen.or(lessThanFifty);
	System.out.println(isPersonEligibleForMembership(person, orPredicate));

	// ######################
	System.out.println(negateTest(predicate, 9));
	// ######################

	// ######################
	Predicate<String> equalPredicate = Predicate.isEqual("Hello");
	System.out.println(equalPredicate.test("Welcome"));
	
	// ######################
	BiPredicate<Person, Integer> biPredicate = ((p , minAge) -> {
	    return (p.age > minAge);
	});
	System.out.println("biPredicate : " + isPersonEligibleForVoting(person, 18, biPredicate));
    }

}
