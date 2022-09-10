package java8Modules.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Emp{
    int age;
    String gender;
    public Emp(int age,String gender) {
	this.age=age;
	this.gender=gender;
    }
}

public class StreamsTest {
    public static List<Emp> getDataV2() {
	List<Emp> emplist = new ArrayList<>();
	emplist.add(new Emp(28,"Male"));
	emplist.add(new Emp(27,"Female"));
	emplist.add(new Emp(29,"Male"));
	return emplist;
    }
    
    public static void main(String[] args) {
	List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
	String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
	System.out.println("G7Countries :"+G7Countries);
	List<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2,4,5,6,8,9}));
	Integer sum = arr.stream().reduce(0, (x,y)->x+y);
	/*
	 * Function<List<Integer>, Integer> sum1 = new Function<List<Integer>,
	 * Integer>() {
	 * 
	 * @Override public Integer apply(List<Integer> t) { Integer ans= 0; for()
	 * return null; } };
	 */
	System.out.println("sum: "+sum);
	mapReduce();
	//streamsMaps();
    }

    public static void getFilteredItems() {
	List<Emp> empList = getDataV2();
	Integer arr[] = new Integer[2];
	//List<Emp> collect = empList.stream().filter(e->e.gender.equalsIgnoreCase("Male"))
		//collect(Collectors.toList());
    }
    public static List<Employee> getData() {
	List<Employee> emplist = new ArrayList<>();
	emplist.add(new Employee("harish", 28));
	emplist.add(new Employee("pavan", 29));
	emplist.add(new Employee("bujji", 22));
	return emplist;
    }
    private static void streamsMaps() {
	
	
	List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
	  
        // Finding sum of all elements
        int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2);
	List<List<String>> list = new ArrayList<>();
	list.add(Arrays.asList("a", "b", "c"));
	list.add(Arrays.asList("d", "e", "f"));
	list.add(Arrays.asList("g", "h", "i"));
	list.add(Arrays.asList("j", "k", "l"));

	Stream<List<String>> stream1 = list.stream();
	// filter() method do not work on stream of collections
	
	// This will not print anything
	//stream1.forEach(System.out::println);
	//Stream<List<String>> stream2 = stream1.filter( x -> "a".equals(x.toString()) );
	stream1.forEach(System.out::println);
	List<String> collect3 = list.stream().flatMap(e->e.stream()).collect(Collectors.toList());
	System.out.println(collect3);
	
	List<Employee> emplist = getData();
	List<Employee> collect = emplist.stream().filter(p -> p.getAge() > 27).map(e -> {
	    e.setName(e.getName().toUpperCase());
	    return e;
	}).collect(Collectors.toList());
	
	List<Employee> collect4 = emplist.stream().filter(e->e.getName().equalsIgnoreCase("bujji")).
		map(p->{
		    //p.setName("##"+p.getName()+"##");
		    return p;
		})
		.collect(Collectors.toList());
	BinaryOperator<String> bo = new BinaryOperator<String>() {
	    
	    @Override
	    public String apply(String t, String u) {
		// TODO Auto-generated method stub
		return null;
	    }
	};
	Stream.of(10,20,22,12,14).reduce(Integer::sum);
	System.out.println("collect4 : "+collect4);
	Optional<Employee> findFirst = emplist.stream().filter(e->e.getName().equalsIgnoreCase("bujji")).findFirst();
	
	List<String> collect2 = emplist.stream().filter(p -> p.getAge() > 27).map(e -> {return e.getName().toUpperCase();}).collect(Collectors.toList());
		//map(e->e.getName().toUpperCase()).collect(Collectors.to)
	System.out.println(collect);
	  emplist.stream().filter(p -> p.getAge() > 27).map(e -> {return e.getName().toUpperCase();}).collect(Collectors.toList());
    }
// return new Employee(e.getName().toUpperCase(), e.getAge());
    
    public static void mapReduce() {
	List<Employee> emplist = getData();
	Optional<Integer> reduce = emplist.stream().filter(e->e.getAge()>26).map(p->p.getAge()).reduce( (x,y)->x+y);
	System.out.println(reduce.get());
	List<String> list = new ArrayList<>();
	list.add("done");
	list.add("far");
	list.add("away");
	list.add("done");

	Map<String, Integer> nameMap = emplist.stream().map(e->e.getName()).collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1));
	System.out.println(nameMap);
	
    }
    
}
