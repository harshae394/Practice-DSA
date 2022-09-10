package assessmentQuestions;

class Node{
	
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}
public class TestTree {

	/**
	 *    1
        /   \
       2     3
      / \   / \
     4   5 6   7
    / \   \   /
   8   9  10 11
      / \   /
     12 13 14
     **/
	public static void main(String[] args) {
		
		Node head = createTree(); 

		boolean res =  checkAncestor(1,4,head);
	}
	
	static boolean checkAncestor(int node1,int node2, Node root) {
		
		if(root==null) return false;
		if(node1==root.data) {
			checkAncestor(node1,node2,root.left);
			checkAncestor(node1,node2,root.right);
		}
		checkAncestor(node1,node2,root.right);
		checkAncestor(node1,node2,root.left);
		
		return false;
	}
	static Node createTree() {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		return node;
		
	}
	

}
