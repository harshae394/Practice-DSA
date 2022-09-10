package javaproject;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;

enum Directions {
    NORTH, SOUTH, EAST, WEST
}

class ParentClass {

    int id;
    String name;

    ParentClass() {
	this(10, "java");
	System.out.println("ParentClass-default-cons");
    }

    ParentClass(int id, String name) {
	System.out.println("ParentClass-args-cons");
	this.id = id;
	this.name = name;
    }

    @Override
    public String toString() {
	return "ParentClass [id=" + id + ", name=" + name + "]";
    }
}

class SubClass extends ParentClass {

    SubClass(){
	System.out.println("subclass-default-cons");
    }
	//super(11, "child");
    //}
    public static void main(String[] args) {
	SubClass ob = new SubClass();
    }
 
}

public class SampleTests {

    public static void main(String[] args) {
	Instant past = Instant.now();
	// now.minus(691200000, ChronoUnit.SECONDS);
	past = past.minusSeconds(691200);
	Instant now = Instant.now();
	System.out.println("past : " + now);
	System.out.println("now : " + past);

	long diff = (now.getEpochSecond() - past.getEpochSecond()) / 86400;
	System.out.println("diff : " + diff);
	Directions north = Directions.EAST;
	System.out.println(north.ordinal());
	north.equals(north);
	System.out.println(Directions.NORTH.equals(north));
	String ss = "";
	ss.equals(ss);
	varArgMethod("new", "221", "12311");
    }

    public static void varArgMethod(String... args) {
	System.out.println("args size : " + args.length);
	String string = args[1];
	Object ob = new Object();

    }

}
