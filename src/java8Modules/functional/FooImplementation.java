package java8Modules.functional;

import java.util.function.Consumer;

@FunctionalInterface
interface Foo {

    // Default Method - Optional can be 0 or more
    public default String HelloWorld() {
	return "Hello World";
    }

    // Static Method - Optional can be 0 or more
    public static String CustomMessage(String msg) {
	return msg;
    }

    // Single Abstract Method
    public void bar(String messg);
}

public class FooImplementation implements Foo {
// Default Method - Optional to Override
    @Override
    public String HelloWorld() {
	return "Hello Java 88";
    }

    @Override
    public void bar(String messg) {
	System.out.println("Hello World");
	Foo c =null; /*new Foo() {
	    @Override
	    public void bar() {
		
	    }
	};*/
	c = (msg)->System.out.println("22");
	
    }

    public static void main(String[] args) {

	Foo fi = new FooImplementation();
	System.out.println(fi.HelloWorld());
	System.out.println(Foo.CustomMessage("Hi"));
	///fi.bar();
    }
}
//. Can a functional interface extend/inherit another interface?
@FunctionalInterface
interface Parent {
    public static int parentMethod() {
	return 1;
    }
    public void absM1();
}

//@FunctionalInterface // This cannot be FunctionalInterface 
interface Child extends Parent {
    
    public default int parentMethod() {
	Parent.parentMethod();
	return 0;
	
    }
    
// It will also extend the abstract method of the Parent Interface 
// Hence it will have more than one abstract method 
// And will give a compiler error 
}

class FunctionImpl implements Child{

    @Override
    public void absM1() {
	// TODO Auto-generated method stub
	
    }
    public static void main(String[] args) {
	//Parent obj = new FunctionImpl();
	//System.out.println(obj.parentMethod());
    }
}

interface Parent1 {
    public default  void parentMethod() {
	System.out.println("Hello");
    }
}

//@FunctionalInterface 
interface Child1 extends Parent {
    public int childMethod();
}
