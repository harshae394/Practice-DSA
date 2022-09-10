package binaryTrees;

public class BinaryTreePratice {

	public static void main(String[] args) {
		
	}
	
	  public Node invertTree(Node root) {
	        if(root==null) return null;
	        Node temp = root.left;
	        root.left = invertTree(root.right);
	        root.right = invertTree(temp);
	        return root;
	    }
	    
}
