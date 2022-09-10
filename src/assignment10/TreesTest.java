package assignment10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreesTest {
	static Node root = null;

	public static void buildTree() {
		root = new Node(1); // 1 3 10 5 7 9 N 5 5 9 2 10
		root.left = new Node(3);
		root.right = new Node(10);

		root.left.left = new Node(5);
		root.left.right = new Node(7);

		root.right.left = new Node(9);
		root.right.right = null;

		root.left.left.left = new Node(5);
		root.left.left.right = new Node(5);

		root.left.right.left = new Node(9);
		root.left.right.right = new Node(2);

		root.right.left.left = new Node(10);
	}

	public static void leftView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Node> eachLevl = new ArrayList<>();
			for(int i = 1; i<=size; i++) {
				Node currentNode = queue.remove();
				if(i==1) 
					System.out.println(currentNode.data +" ");
				if(currentNode.left!=null) {
					queue.add(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.add(currentNode.right);
				}
				eachLevl.add(currentNode);
			}
			//System.out.println("each level : "+ eachLevl);
		}
	}

	public Node createBinaryTree() {
		Map<Integer, Node> map = new HashMap<>();
		map.put(0, new Node(0));
		map.put(1, new Node(1));
		map.put(2, new Node(2));
		map.put(3, new Node(3));
		map.put(4, new Node(4));
		map.put(5, new Node(5));
		map.put(6, new Node(6));
		Map<Integer, Node> temp = new HashMap<>();
		int p = 0;
		for (int i = 0; i < map.size(); i++) {
			map.get(p);
		}
		return null;
	}

	public static void main(String[] args) {
		buildTree();
		// inOrderRec(root);
		System.out.println(heigthOfTree(root));
		System.out.println(minDepthOfTree(root));
		// levelOrderTraversal();
		getMaxTreeWidth(root);
		List<List<Integer>> levelOrder = levelOrderTraversal2();
		System.out.println("level : " + levelOrder);
		int arr[] = { -1, 0, 0, 1, 1, 3, 5 };
		int n = 7;
		// int arr[] = {2,0,-1};
		constructFromParentArray(arr, n);
		System.out.println("\nbalanced: " +isBalanced(buildTree2()));
		// sumRootToLeaf();
		// System.out.println("rootToLeaf = "+rootToLeafSum(root, 0));

	}
	public static Node buildTree2() {
		root = new Node(1); // 1 3 10 5 7 9 N 5 5 9 2 10
		root.left = new Node(2);
		root.right = new Node(4);

		root.left.left = new Node(3);
		root.left.left.left = new Node(9);
		
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);
		root.right.right.right.right = new Node(8);
		return root;
		
	}
	static boolean isBalanced(Node root){
	    return (balancedHeight(root)!=-1);
    }
    
    static int balancedHeight(Node root){
        if(root==null) return 0;
        int left = balancedHeight(root.left);
       // if(left==-1) return -1;
        //System.out.println("right: "+root.right);
        int right = balancedHeight(root.right);
        if(right==-1) return -1;
        
        if(Math.abs(right-left)>1) return -1;
        return Math.max(left,right)+1;
    }

	public Node invertTree(Node root) {//mirrorTree
		if (root == null)
			return null;
		Node temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}
	
	public boolean isBST(Node root) {
		return false;
	}

	boolean isIdentical(Node root1, Node root2)// not BST but BT
	{
		return compareTrees(root1, root2);
	}

	boolean compareTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 != null && root2 != null) {
			return (root1.data == root2.data && compareTrees(root1.left, root2.left)
					&& compareTrees(root1.right, root2.right));
		}
		return false;
	}
	public static boolean isSymmetric(Node root)
    {
        if(root==null) return true;
        return symmetricUtil(root.left,root.right);
       
    }
    static boolean symmetricUtil(Node left, Node right){
        if(left==null && right==null) return true;
        if(left!=null && right!=null){
            return ( (left.data==right.data) && symmetricUtil(left.left,right.right) &&  symmetricUtil(left.right, right.left));
        }
        return false;
        
    }

	public static void InOrderIterative(Node root) {

		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node tmp = root;
		while (!stack.isEmpty() || tmp != null) {
			if (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			} else {
				tmp = stack.pop();
				System.out.print(tmp.data + " -> ");
				tmp = tmp.right;
			}
		}
	}

	public static void preOrderIterative(Node root) {

		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			System.out.print(tmp.data + " -> ");
			if (tmp.right != null)
				stack.push(tmp.right);

			if (tmp.left != null)
				stack.push(tmp.left);

		}
		return;
	}

	public static void inOrderRec(Node root) {
		if (root == null)
			return;
		inOrderRec(root.left);
		System.out.print(root.data + " -> ");
		inOrderRec(root.right);
	}

	public static void inOrderIter(Node root) {

		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp + " -> ");
				temp = temp.right;
			}
		}
		// 4 -> 2 -> 5 -> 1 -> 6 -> 3 -> 7 ->
		// 4 -> 2 -> 5 -> 1 -> 6 -> 3 -> 7
	}

	public static int heigthOfTree(Node root) {
		if (root == null)
			return 1;

		int leftHight = heigthOfTree(root.left);
		int rightHight = heigthOfTree(root.right);
		int ans = Math.max(leftHight, rightHight) + 1;
		return ans;
	}

	public static int minDepthOfTree(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int leftHight = (root.left != null ? heigthOfTree(root.left) : Integer.MAX_VALUE);
		int rightHight = (root.right != null ? heigthOfTree(root.right) : Integer.MAX_VALUE);
		return Math.min(leftHight, rightHight) + 1;
	}

	static List<List<Integer>> levelOrderTraversal2() {
		Queue<Node> queue = new LinkedList<Node>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		queue.add(root);
		if (root == null) {
			System.out.println("Tree does not exists !");
			return null;
		}
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> width = new ArrayList<Integer>(size);
			for (int i = 0; i < size; i++) {
				Node currentNode = queue.remove();
				width.add(currentNode.data);
				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
			max = Math.max(width.size(), max);
			res.add(width);
			// System.out.print(presentNode.data + " ");
		}
		System.out.println("levelOrderTraversal2-maxWidth : " + max);
		return res;
	}

	static int getMaxTreeWidth(Node root) {
		// Your code here
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Node> width = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				root = queue.remove();
				width.add(root);
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			System.out.println("list : " + width);
			max = Math.max(width.size(), max);
		}
		System.out.println("maxWidth : " + max);
		return max;
	}

	static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.data + " ");
			if (presentNode.left != null)
				queue.add(presentNode.left);
			if (presentNode.right != null)
				queue.add(presentNode.right);
		}
	}

	static void sumRootToLeaf() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		List<List<Node>> levelOrderList = new ArrayList<List<Node>>();
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Node> eachLvl = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				Node presentNode = queue.remove();
				// System.out.print(presentNode.data + " ");
				if (presentNode.left != null)
					queue.add(presentNode.left);
				if (presentNode.right != null)
					queue.add(presentNode.right);
				eachLvl.add(presentNode);
			}
			levelOrderList.add(eachLvl);
		}
		System.out.println(levelOrderList);
	}

	public static int rootToLeafSum(Node root, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		if (root.left != null)
			sum = sum + rootToLeafSum(root.left, root.data);
		if (root.right != null)
			sum = sum + rootToLeafSum(root.right, root.data);
		return sum;
	}

	public static Node constructFromParentArray(int arr[], int n) {
		// {-1,0,0,1,1,3,5}
		// Output: 0 1 2 3 4 5 6
		// {0=-1, 1=0, 2=0, 3=1, 4=1, 5=3, 6=5}
		Map<Integer, List<Node>> resMap = new HashMap<>();
		int itr = 0;
		for (int indx : arr) {
			if (resMap.containsKey(indx)) {
				resMap.get(indx).add(new Node(itr++));
			} else {
				List<Node> nodes = new ArrayList<Node>();
				nodes.add(new Node(itr++));
				resMap.put(indx, nodes);
			}
		}
		// {-1=[0], 0=[1, 2], 1=[3, 4], 3=[5], 5=[6]}
		System.out.println(resMap);
		List<Node> prevParents = null;
		Node root = resMap.get(-1).get(0);
		Map<Integer, Node> tempMap = new HashMap<>();
		tempMap.put(0, root);
		System.out.println(tempMap);
		int p = 0;
		for (int i = 0; i < arr.length; i++) {
			Node tmp = tempMap.get(i);
			if (tmp == null)
				continue;
			prevParents = resMap.get(tmp.data);
			if (prevParents != null) {
				tmp.left = prevParents.get(0);
				tempMap.put(++p, tmp.left);

				if (prevParents.size() > 1) {
					tmp.right = prevParents.get(1);
					tempMap.put(++p, tmp.right);
				}
			}
		}
		System.out.println(tempMap);
		levelOrderTraversal(tempMap.get(0));
		return tempMap.get(0);
	}

	static void createTree(Node root, List<Integer> values) {
		int first = 0;
		for (int node : values) {
			if (first == 0)
				root.left = new Node(node);
			else
				root.right = new Node(node);
			first++;
		}
	}
}
