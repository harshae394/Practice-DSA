package java8Modules.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionTest {

    static void functionTest1() {
	Function<String, Integer> lengthFunction = (str -> str.length());
	    System.out.println("String length: " + lengthFunction.apply("This is awesome!!"));
	    
	    
	    Function<Emp, Map<String,Integer>> fn= new Function<Emp, Map<String,Integer>>() {
		Map<String,Integer> map = new HashMap<>();
		@Override
		public Map<String,Integer> apply(Emp t) {
		    if(t.gender.equalsIgnoreCase("MALE"))
		    map.put("MALE", map.getOrDefault("MALE",0)+1);
		    
		    if(t.gender.equalsIgnoreCase("FEMALE"))
			map.put("FEMALE", map.getOrDefault("FEMALE",0)+1);
		    return map;
		}
	    };
    }
    
    static void test2(){
	 Function<Integer, Integer> increment = x -> x + 10;
	        // Function which doubles the given element.
	 Function<Integer, Integer> multiply = y -> y * 2;
	  // Since we are using compose(), multiplication will be done first and then increment will be done.
	 System.out.println("compose result: " + increment.compose(multiply).apply(3));
	 System.out.println("andThen result: " + increment.andThen(multiply).apply(3));
	 
	 BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; 
	 System.out.println("Sum = " + add.apply(9, 3)); 
	 unaryOperator();
	        
    }
    static void unaryOperator() {
	Person person = new Person();
	UnaryOperator<Person> operator = (p) -> {
	            p.name = "John";
	            p.age = 34;
	            return p;
	        };
	        operator.apply(person);
	        System.out.println("Person Name: " + person.name + ", Person Age: " + person.age);
    }
    public static void main(String[] args) {
	functionTest1();
	test2();
    }

}
