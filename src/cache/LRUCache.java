package cache;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
	public static void main(String[] args) {
		final int capacity = 3;
		LRUCache cache = new LRUCache(capacity);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		System.out.println(cache.get(4));
	}

	Map<Integer, Node> map = null;

	MyLinkedList nodes = null;

	int size = 0;
	int capacity = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);
		nodes = new MyLinkedList();

	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node xx = map.get(key);
			Node newN = new Node(xx.key, xx.value);
			map.remove(key);
			map.put(key, newN);
			nodes.remove(xx);
			nodes.add(newN);

			return xx.value;
		}
		return -1;

	}

	public void put(int key, int value) {

		if (size == capacity) {
			Node xx = map.get(key) != null ? map.get(key) : nodes.head;
			map.remove(key);
			Node newN = new Node(key, value);
			map.put(key, newN);
			nodes.remove(xx);
			nodes.add(newN);

		} else {
			if (map.containsKey(key)) {
				Node xx = map.get(key);
				map.remove(key);
				Node newN = new Node(key, value);
				map.put(key, newN);
				nodes.remove(xx);
				nodes.add(newN);
			} else {
				Node newN = new Node(key, value);
				map.put(key, newN);
				nodes.add(newN);
				size++;
			}

		}

	}

	class MyLinkedList {
		Node head;
		Node tail;

		void add(Node node) {
			if (head == null) {
				head = node;
				tail = head;
			} else {// 1->4->5->7<->11
				node.prev = tail;
				tail.next = node;
				tail = tail.next;
			}
		}

		public void remove(Node node) {
			if (node == null)
				return;
			if (node.prev != null) {
				node.prev.next = node.next; // 1<->5<->7<->9
			} else {
				this.head = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				this.tail = node.prev;
			}
			node.next = null;
			node.prev = null;
		}
	}

}

class Node {
	Node next;
	Node prev;
	int key;
	int value;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}