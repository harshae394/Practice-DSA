package javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedCollections {

	public static void main(String[] args) {
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		
		Hashtable<Integer,Integer> htable;
		HashMap<Integer,Integer> hamp;
		ConcurrentHashMap<Integer, Integer> champ;
		
		int x=-32;
		System.out.println(32 >>> 1);
		ReentrantLock rtlock;
	}

}
