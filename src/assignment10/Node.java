package assignment10;

public class Node {

    public int data;
    public Node left;
    public Node right;

    Node(){
    }
    Node(int data) {
	this.data = data;
	left = right =null;
    }
    
    @Override
    public String toString() {
	return data + " ";
    }

}
