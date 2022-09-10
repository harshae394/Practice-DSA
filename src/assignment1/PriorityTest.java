package assignment1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Ticket implements Comparable<Ticket>{
    int id;
    String desc;
    int priority;
    public Ticket(int id, String desc, int priority) {
	super();
	this.id = id;
	this.desc = desc;
	this.priority = priority;
    }
    
    @Override
    public String toString() {
	return "[" + id + ", " + desc + ", " + priority + "]";
    }
    @Override
    public int compareTo(Ticket curr) {
	//return (curr.priority > priority) ? 1 : ( (curr.priority ==priority)? 0 :-1 );
	if(curr.priority < this.priority) return -1;
	else if(curr.priority > this.priority) return 1;
	else return 0;
    }
}
public class PriorityTest {

    public static void main(String[] args) {
	Set<Ticket> ticketList = new TreeSet<>();
	ticketList.add(new Ticket(1,"ten",10));
	ticketList.add(new Ticket(2,"two",2));
	ticketList.add(new Ticket(11,"eleven",11));
	ticketList.add(new Ticket(13,"eleven",19));
	ticketList.add(new Ticket(14,"two1",21));
	ticketList.add(new Ticket(15,"two2",21));
	System.out.println("ticketList : "+ticketList);
    }

}
