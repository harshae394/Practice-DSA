package java8Modules.streams;

import java.util.List;
import java.util.Set;

class Student {

    Integer id;
    Set<String> subjects;
    List<Integer> marks;
    String[] grades;

    public Student(Integer id, Set<String> subjects, List<Integer> marks, String[] grades) {
	this.id = id;
	this.subjects = subjects;
	this.marks = marks;
	this.grades = grades;
    }
}

public class TestBasic1 {

    public static void main(String[] args) {
	
	Student s = new Student(
		500, null,null,
       // Set.of("Physics","Chemistry","Mathematics"),
	    //List.of(84,65,90),
	    new String[]{"B","C","A"}
	    );
    }

}
