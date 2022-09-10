package designPatterns.singleton;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		SingletonClass obj3 = SingletonClass.getInstance();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);

		Deque<String> deq = new LinkedList<String>();
		deq.add("A");
		deq.add("B");
		deq.addFirst("A0");
		deq.addFirst("A-1");
		System.out.println(deq);
		Map<String, String> map = null;
		HashMap<String, String> hmap = null;

		hmap = new HashMap<String, String>(3);
	}

}
