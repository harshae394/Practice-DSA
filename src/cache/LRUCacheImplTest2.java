package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Cache{
    String key ;
    String value;
    public Cache(String key, String value) {
	super();
	this.key = key;
	this.value = value;
    }
    @Override
    public String toString() {
	return "Cache [key=" + key + ", value=" + value + "]";
    }
}

public class LRUCacheImplTest2 {

    int MAX_SIZE = 4;
    int size = 0;
    Deque<Cache> LRUCache = new LinkedList<>();;
    Map<String,Cache> cacheMap = new HashMap<>(MAX_SIZE);
    
    private void initialize() {
	
    }
    private void put(String key,String value) {
	Cache newObj = new Cache(key, value);
	if(size == MAX_SIZE) {//1 4 5 6==>next ip->7,s0-->rmove 1->
	    Cache cacheVal = cacheMap.get(key);
	    if(cacheVal!=null) {
		cacheMap.remove(cacheVal.key);
		LRUCache.remove(cacheVal);
	    }else {
		
	    }
	    
	    Cache firstObj = LRUCache.removeFirst();
	    cacheMap.remove(firstObj.key);
	}else {
	    
	    
	}
	if(cacheMap.containsKey(key)) {
	    Cache removObj = cacheMap.remove(key);
	    LRUCache.remove(removObj);
	}
	LRUCache.addLast(newObj);
	cacheMap.put(key, newObj);
	
    }
    private void evictIfNeeded(String key) {
	
    }
    private String get(String key) {
	Cache cachedVal = cacheMap.get(key);
	if(cachedVal!=null) {
	    Cache newObj = new Cache(cachedVal.key, cachedVal.value);
	    cacheMap.remove(key);
	    LRUCache.remove(cachedVal);
	    
	    LRUCache.addLast(newObj);
	    cacheMap.put(key, newObj);
	    return cachedVal.value;
	}
	
	return null;
    }
    
    public static void main(String[] args) {
	

    }

}
