package java8Modules.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CustomData {
    public String name;
    public Integer age;
    public String country;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public CustomData(String name, int age, String country) {
	this.name = name;
	this.age = age;
	this.country = country;
    }

    @Override
    public String toString() {
	return "[" + name + ", " + age + ", " + country + "]";
    }

}

public class ComparatorTest {
    
    public static List<CustomData> getData() {
	List<CustomData> persons = new ArrayList<>();
	persons.add(new CustomData("John", 26, "USA"));
	persons.add(new CustomData("Carl", 23, "Australia"));
	persons.add(new CustomData("Amit", 21, "India"));
	persons.add(new CustomData("Vikram", 22, "Bhutan"));
	persons.add(new CustomData("Kane", 10, "Brazil"));
        return persons;
    }
    public static void sortData() {
	
	List<CustomData> list = getData();
	List<CustomData> collect = list.stream().sorted(Comparator.comparing(CustomData::getAge)).sorted(Comparator.comparing(CustomData::getName)).collect(Collectors.toList());
	System.out.println("collect: "+collect);
	/*Comparator<CustomData> comparator = new Comparator<CustomData>() {
	    @Override
	    public int compare(CustomData o1, CustomData o2) {
		return o1.name.compareTo(o2.name);
	    }
	};
	Collections.sort(list, comparator);*/
	
	Comparator<CustomData> sortComp =  (obj1,obj2)->obj1.country.compareTo(obj2.country); 
	Collections.sort(list, sortComp);
	System.out.println(list);
	
    }
    public static void main(String[] args) {
	sortData();
    }

}
