package cache.LRUV1;

import java.util.HashMap;
import java.util.Map;

class Node {
	int value;
	int key;
	Node left;
	Node right;
}

class LRUCache {

	Map<Integer, Node> map; // it contains key and the pointer to the nodes of double linked list.
	Node start = null, end = null; // start and end pointer of doubly linked list
	int lru_cap;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Node>();
		lru_cap = capacity;
	}

	public int get(int key) {

		if (map.containsKey(key)) {

			Node temp = map.get(key);
			removeFromList(temp);
			addAtFront(temp);

			return temp.value;
		}

		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) { // if the key already exist then we need to update the value only and need to
									// move the node to fron of the doubly linked list
			Node temp = map.get(key);
			temp.value = value;
			removeFromList(temp);
			addAtFront(temp);

		} else {
			// make the node first
			Node temp = new Node();
			temp.value = value;
			temp.key = key;
			temp.left = null;
			temp.right = null;

			// if key is not present then 2 cases. one is that cache is full and other is
			// that it has some space
			if (map.size() == lru_cap) {
				map.remove(end.key);
				removeFromList(end);
				addAtFront(temp);
				map.put(key, temp);
			} else {

				addAtFront(temp);
				map.put(key, temp);
			}
		}
	}

	public void removeFromList(Node node) {
		if (node.left == null && node.right == null) {
			start = end = null;
		} else if (node.left == null) {
			start = node.right;
			start.left = null;
		}

		else if (node.right == null) {
			end = node.left;
			end.right = null;
		} else {
			node.left.right = node.right;
			node.right.left = node.left;
		}
	}

	public void addAtFront(Node node) {
		if (start == null) {
			start = node;
			end = node;
		} else {
			node.right = start;
			start.left = node;
			node.left = null;
			start = node;
		}

	}
}