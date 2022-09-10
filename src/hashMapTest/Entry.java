package hashMapTest;

public class Entry {

    public String key;

    public Object value;

    public Entry next;
    
    public Entry(String key, Object value) {
	super();
	this.key = key;
	this.value = value;
    }

    public Entry() {
    }
    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public Object getValue() {
	return value;
    }

    public void setValue(Object value) {
	this.value = value;
    }

    public Entry getNext() {
	return next;
    }

    public void setNext(Entry next) {
	this.next = next;
    }
    @Override
    public String toString() {
	return "Entry [key=" + key + ", value=" + value + "]";
    }


}
