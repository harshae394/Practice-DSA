package hashMapTest;

public class HashMapTest {

    public static void main(String[] args) {
	HashMapArray<String> hmp= new HashMapArray<String>();
	hmp.put("1", "firstValue");
	System.out.println("after 1 : " +hmp.hmaptoString());
	hmp.put("2", "secondValue");
	System.out.println("after 2 : " +hmp.hmaptoString());
	//hmp.put("4", "4thValue");
	System.out.println("after 4 : " +hmp.hmaptoString());
	hmp.remove("4");
	hmp.put("14", "14thValue");
	System.out.println("after 14 : " +hmp.hmaptoString());
	hmp.put("24", "24thValue");
	System.out.println("size : "+hmp.size);
	System.out.println("getkey : 24 "+ hmp.get("24"));
	String removed = hmp.remove("4");
	System.out.println("removed key 14 :: "+removed +" size : "+hmp.size);
	System.out.println("after removed key 14, value  : "+hmp.get("14"));
	System.out.println(hmp.hmaptoString());
    }
    

}
