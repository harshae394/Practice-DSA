package java8Modules.streams;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerClassTest {

    public static void main(String[] args) {
	Consumer<String> consumer = ((country) -> System.out.println(country));
	consumer.accept("Heyyy");
	
	 consumer = ( (country) -> {   
	     country = country.toUpperCase();
	     System.out.println(country);   
	 } );
	consumer.accept("HeyyyFromLowerCase");
	
	////
	Consumer<String> consumer3 = System.out::println;
	consumer3.accept("consumer3: hey Method referrence");
	
	Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");

        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");

        consumer1.andThen(consumer2).accept("Hello. ");
        
        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("Hello", "World");

    }

}
