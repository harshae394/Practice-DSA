package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheEntry {
    int key;
    String value;

    CacheEntry(int key, String value) {
	this.key = key;
	this.value = value;
    }

    @Override
    public String toString() {
	return "[key=" + key + ", value=" + value + "]";
    }
    
}

public class LRUCacheImpl {
    Deque<CacheEntry> deq = new LinkedList<>();
    Map<Integer, CacheEntry> map = new HashMap<>();
    int CACHE_SIZE = 3;

    public String getFromCache(int key) {
	if (map.containsKey(key)) {
	    CacheEntry entry = map.get(key);
	    deq.remove(entry);
	    deq.addFirst(entry);
	    return entry.value;
	}

	return null;
    }

    @Override
    public String toString() {
	return "[ "+map+" ]";
    }

    public void putEntryIntoCache(int key, String value) {
	if (map.containsKey(key)) {
	    CacheEntry entry = map.get(key);
	    deq.remove(entry);
	} else {
	    if (deq.size() == CACHE_SIZE) {
		CacheEntry entryToBeRemoved = deq.removeLast();
		map.remove(entryToBeRemoved.key);
	    }
	}

	CacheEntry newEntry = new CacheEntry(key, value);
	deq.addFirst(newEntry);
	map.put(key, newEntry);
    }

    public static void main(String[] args) {

	LRUCacheImpl cache = new LRUCacheImpl();
	cache.putEntryIntoCache(1, "Product-1-Info");
	cache.putEntryIntoCache(2, "Product-2-Info");
	cache.putEntryIntoCache(3, "Product-3-Info");
	cache.putEntryIntoCache(4, "Product-4-Info");

	System.out.println("cache : "+cache);
	
	System.out.println(cache.getFromCache(2));
	System.out.println(cache.getFromCache(1));
	System.out.println("cache : "+cache);

    }
}
