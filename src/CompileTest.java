
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee{
     String name;
     String dept;
    public Employee() {
    }
    public Employee(String name, String dept) {
	super();
	this.name = name;
	this.dept = dept;
    }
    @Override
    public String toString() {
	return "[name=" + name + ", dept=" + dept + "]";
    }
   
}

public class CompileTest {

    public static void main(String[] args) {
	/* Map<String,String> map = new HashMap<>();
	 map.put("A", "Mercedes");map.put("B", "Aadi");map.put("C", "Ford"); map.put("D", "Volkswagen");
	 List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
	 
	 Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
	     public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
		 return (o1.getValue()).compareTo(o2.getValue());
	     }
	 });
	 
	 System.out.println("list: "+list);*/
	
	List<Employee> emList = new ArrayList<>();
	emList.add(new Employee("Harish", "Dev"));emList.add(new Employee("Pavan", "Architect"));
	emList.add(new Employee("Sai", "QA"));emList.add(new Employee("Venky", "DBA"));
	Collections.sort(emList, new Comparator<Employee>() {
	    @Override
	    public int compare(Employee o1, Employee o2) {
		return o1.dept.compareTo(o2.dept);
	    }
	});
	System.out.println("Order BY Dept : "+ emList);
	Collections.sort(emList, new Comparator<Employee>() {
	    @Override
	    public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	    }
	});
	System.out.println("Order BY name : "+ emList);
	
	Collections.sort(emList, new Comparator<Employee>() {
	    @Override
	    public int compare(Employee o1, Employee o2) {
		int res = o1.name.compareTo(o2.name);
		return( (res==0)? (o1.dept.compareTo(o2.dept)):1);
	    }
	});
	System.out.println("Order By both : "+ emList);
	/*Collections.sort(emList, new Comparable<Employee>() {

	    @Override
	    public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	    }
	});*/
    }
    String st ;
}
