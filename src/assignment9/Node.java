package assignment9;

public class Node {
    int data;
    Node next;

    Node(){
	
    }
    Node(int data) {
	this.data = data;
    }
    @Override
    public String toString() {
	return data +"";
    }
    
}