package java8Modules.streams;
public class Person {
    String name;
    int age;

    Person(String name, int age) {
	this.name = name;
	this.age = age;
    }

    public Person() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
	return "Person [name=" + name + ", age=" + age + "]";
    }
    
}