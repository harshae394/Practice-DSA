package testproject;

// Importing util package
import java.util.*;

// Custome class Car implements Comparable interface
class Car implements Comparable<Car> {

    // attributes
    int Modelno;
    String name, city;
    int stock;

    // Car constructor
    public Car(int Modelno, String name, String city, int stock) {
	this.Modelno = Modelno;
	this.name = name;
	this.city = city;
	this.stock = stock;
    }

    // Override the compareTo() method
    public int compareTo(Car c) {
	if (stock > c.stock) {
	    return 1;
	} else if (stock < c.stock) {
	    return -1;
	} else {
	    return 0;
	}
    }

    @Override
    public String toString() {
	return "[" + Modelno + ", " + name + ", " + city + ", " + stock + "]";
    }
    
}

public class GFG {

    // Main driver method
    public static void main(String[] args) {
	// Define an objects of TreeSet class
	TreeSet<Car> set = new TreeSet<Car>();

	// Creating Car objects
	Car c1 = new Car(132, "BMW", "Rajkot", 35);
	Car c2 = new Car(269, "Audi", "Surat", 20);
	Car c3 = new Car(560, "Kia", "Vadodara", 15);
	Car c4 = new Car(109, "Creta", "Ahmedabad", 26);

	// Adding Car objects to TreeSet
	set.add(c1);
	set.add(c2);
	set.add(c3);
	set.add(c4);
System.out.println("set : "+set);
	// Traversing TreeSet
	for (Car c : set) {
	    System.out.println(c.stock + " " + c.name + " " + c.city + " " + c.Modelno);
	}
    }
}
