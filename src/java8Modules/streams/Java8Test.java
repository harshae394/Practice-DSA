package java8Modules.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

 interface IVehicle {

    void cleanVehicle();

     default void startVehicle() {
        System.out.println("Vehicle is starting");
    }
}
interface IAbs{
    
}
abstract class Abs implements Callable<Abs>{
    int a;
    Abs(){
	a =10;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    
}
class AbsImpl extends Abs{

    @Override
    public Abs call() {
	// TODO Auto-generated method stub
	System.out.println("callable");
	return null;
    }
    
}
public class Java8Test {

    public static void main(String[] args) {
	Abs ab = new AbsImpl();
	ab.setA(12);
	System.out.println(ab.getA());
	duplicateTest();
	System.out.println(solution(15958));
	deleteMax();
	
	ArrayList<Integer> list = new ArrayList<>();
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);

	Iterator<Integer> it = list.iterator();
	list.add(50);
	while(it.hasNext()) {
	      System.out.print(it.next() + " ");
	}
	
    }

    public static void duplicateTest() {
	Hashtable ht = null;
	 List<String> cars = new ArrayList<>(Arrays.asList("Mercedes", "Toyota","Nissan","Volkswagen",
                 "Ford","Maclaren","Mercedes","Nissan", "Ford"));
	 List<String> distinct = cars.stream().distinct().collect(Collectors.toList());
	 List<String> dup =  cars.stream().filter(e->Collections.frequency(cars, e)>1).collect(Collectors.toList());
	 System.out.println("duplcates : "+ dup);
	 System.out.println("distinct : "+ distinct);
	 Comparator<String> sortF = new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	    }
	     
	};
	List<String> sortedOp = cars.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
	System.out.println("sortedOp : "+sortedOp);
	 System.out.println(distinct);
	 Map<String,String> map = new HashMap<>();
	 map.put("A", "Mercedes");map.put("X", "Aadi");map.put("C", "Ford"); map.put("P", "Volkswagen");
	 Set<String> keySet = map.keySet();
	 keySet.add("111");
	// System.out.println("keySet: "+keySet);
	 List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
	 
	 Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
	     public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
		 return (o1.getValue()).compareTo(o2.getValue());
	     }
	 });
	 
	 System.out.println("list: "+list);
	 Map<String, String> sortValuesMap = 
		 map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).
		 collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	 System.out.println("sortValuesMap: "+sortValuesMap);
	 
	Map<String, String> collect = map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).
		 collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	
	System.out.println("collect : "+collect);
	
	Map<String, String> collect1 = map.entrySet().stream().sorted(Entry.comparingByValue()).
		 collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,  e2) -> e1, LinkedHashMap::new));
	System.out.println("collect1 : "+collect1);
	
	List<Integer> nums =Arrays.asList(new Integer[] {1,4,4,2,2,8,9,1});
//	/nums.sort((a,b)->a.compareTo(b));
	List<Integer> numsSorted = nums.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
	System.out.println(" numsSorted : "+numsSorted);
	 List<Integer> collect2 = nums.stream().map(e->{return e*e*e;}).collect(Collectors.toList());
	 IntStream sorted = collect2.stream().filter(e->e>100).mapToInt(Integer::intValue);
	 System.out.println("instream : "+sorted.toString());
	 
	 System.out.println("cubes : "+collect2);
	Map<Integer, Long> result = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
	System.out.println("result : "+result);
    }
    private static int solution(int N) {
        int flag = N >= 0 ? 1 : -1;
        N = Math.abs(N);
        String numStr = N + "";
        String[] numarr = numStr.split("");
        ArrayList<String> result = new ArrayList<>();
        boolean inserted = false;

        for (String tmpStr : numarr) {
            int tmp = Integer.parseInt(tmpStr);
            inserted = flag == 1 ? tmp < 5 : tmp > 5;
            if(inserted){
                result.add(50 + tmp + "");
                break;
            }
            result.add(tmpStr);
        }

        result.addAll(Arrays.asList(numarr).subList(result.size(), numarr.length));
        if (!inserted) result.add("5");
        return flag * Integer.parseInt(String.join("", result));
    }
    /**returns the maximum possible value obtained by deleting one '5' digit**/
    public static void deleteMax(){
	int num = -5859;
	    int sign = num > 0 ? 1 : -1;
	    int value = Math.abs(num);
	    int maxValue = Integer.MIN_VALUE;
	    String stringValue = Integer.toString(value);

	    for (int i = 0; i < stringValue.length(); i++) {

	      final String digit = stringValue.substring(i, i + 1);

	      if (digit.equals("5")) {
	        String stringToCheck = stringValue.substring(0, i) + stringValue.substring(i + 1);
	        int intToCheck = Integer.parseInt(stringToCheck) * sign;
	        maxValue = Math.max(intToCheck, maxValue);
	      }

	    }
	    System.out.println(maxValue);
	}
    
}
