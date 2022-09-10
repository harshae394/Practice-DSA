package hashMapTest;

import java.util.HashMap;

public class HashMapArray<T> {

    private Entry entry[];
    private int bucketSize;
    
    public int size =0;
    public HashMapArray() {
	this.bucketSize = 10;
	initializeBuckets(bucketSize);
    }
    
    public HashMapArray(int size) {
	this.bucketSize = size;
	initializeBuckets(bucketSize);
	
    }
    private void initializeBuckets(int bucketSize) {
	this.entry = new Entry[bucketSize];
	for(int i = 0; i<bucketSize ; i++)
	    entry[i] = new Entry();
    }
    
    public int getHashCode(String key) {
	return Integer.parseInt(key)%bucketSize;
    }
    
    public void put(String key, Object value) {
	int hashIndex = getHashCode(key);
	//System.out.println("hashIndex for key :"+key+","+ hashIndex);
	 Entry entryVal = entry[hashIndex];
	 Entry newVal = new Entry(key, value);
	 if(entryVal.key==null) {
	     entry[hashIndex] = newVal;
	 }
	 else { 
	     newVal.next =entryVal.next;
	     entryVal.next= newVal;
	 }
	 size++;
    }
    
    public T get(String key) {
	T value = null;
	int hashIndex = getHashCode(key);
	Entry entryVal = entry[hashIndex];
	
	while(entryVal!=null) {
	   // System.out.println("get-iter : "+ entryVal.key);
	    if(key.equalsIgnoreCase(entryVal.getKey())){
		value = (T)entryVal.getValue();
		break; 
	    }
	    
	    entryVal =entryVal.next;
	    
	}
	return value;
	
    }
    
    public T remove(String key) {
	if(key!=null) {
	    int hashIndex = getHashCode(key);
	    Entry entryVal = entry[hashIndex];
	    Entry prev =null;
	    while(entryVal!=null) {//1->4->6->8->11
		   // System.out.println("remove-iter : "+ entryVal.key);
		    if(key.equalsIgnoreCase(entryVal.getKey())){
			Entry removed = entryVal;
			if(prev!=null) {
			    prev.next =  entryVal.next;
			    size--;
			    return (T) removed.value;
			}
			
		    }
		    prev = entryVal;
		    entryVal =entryVal.next;
		}
	}
	return null;
    }
    public String hmaptoString() {
	HashMap aa;
	if(size == -1) return "{}";
	String map ="{";
	for(int i =1 ; i<=size ; i++) {
	    Entry nextNodes = entry[i];
	    while(nextNodes!=null ) {
		map = map+nextNodes.key+"="+nextNodes.value +",";
		nextNodes = nextNodes.next;
	    }
	}
	map = map +"}";
	return map;
    }
}
