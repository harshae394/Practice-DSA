package java8Modules.streams;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface Vehicle {

    static void cleanVehicle()
        {System.out.println("I am cleaning vehicle");}
}
class Car implements Vehicle {
    
   //@Override
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    }

    public static void main(String args[]) {
        Car car = new Car();
        car.cleanVehicle();

    }
}
public class FilterTest {

    public static void main(String[] args) {
	List<Employee> list = createEmployeeList();
	List<Employee> ageFiltered = list.parallelStream().filter(e->e.getAge()>20).collect(Collectors.toList());
	System.out.println(ageFiltered);
	List<String> employees = list.parallelStream().filter(e->e.getAge()>20).map(Employee::getName).collect(Collectors.toList());
	System.out.println(employees);
	LocalTime of = LocalTime.of(2, 3);
	LocalTime plus = of.plus(Duration.ofSeconds(21));
    }

    
    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();
 
        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);
 
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
 
        return employeeList;
    }
}
