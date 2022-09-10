package java8Modules.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
	private String name;
	private int age;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Employee other = (Employee) obj; if (age != other.age) return false;
	 * if (name == null) { if (other.name != null) return false; } else if
	 * (!name.equals(other.name)) return false; return true; }
	 */

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name!=null ? name.toLowerCase(): name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	  @Override public String toString() { return "[ "+name +
	  ", "+ age + "]"; }
	 
	public static void main(String[] args) {
		Employee emp1 = new Employee("harish", 23);
		Employee emp2 = new Employee("Kumar", 29);
		Employee emp3 = new Employee("Harsha", 22);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);empList.add(emp2);empList.add(emp3);
		
		List<Employee> nameSorted = empList.stream().sorted((x,y)->x.getName().compareTo(y.getName())).collect(Collectors.toList());
		//Comparator.comparing(Employee::getName)
		nameSorted = empList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		
		List<Employee> ageSorted = empList.stream().sorted((a,b)->a.getAge().compareTo(b.getAge())).collect(Collectors.toList());
		System.out.println("sortlist-ByName: " + nameSorted);
		System.out.println("sortlist-ByAge: " + ageSorted);
		
		System.out.println("emp1: " + emp1);
		System.out.println("emp2: " + emp2);
		System.out.println(emp1.equals(emp2));
		Map<Employee, String> map = new HashMap<>();
		map.put(emp1, "emp1");
		map.put(emp2, "emp2");
		map.put(emp1, "emp5");
		System.out.println(map);
	}

}