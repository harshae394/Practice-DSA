package transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformTest1 {

    
    public static void main(String[] args) {
	//System.out.println(fillData());
	List<User> res= transformData(fillData());
	System.out.println("res: "+res);
    }
    
    public static List<User> fillData() {
	User obj1 = new User();
	Map<String,String> action = new HashMap<String,String>(); 
	List<User> users = new ArrayList<User>();
	 obj1 = new User("Lekha", "Type1", true, action); users.add(obj1);
	 obj1 = new User("Lekha", "Type1", true, action);users.add(obj1);
	 obj1 = new User("Vamsi", "Type3", false, action);users.add(obj1);
	 obj1 = new User("Harish", "Type2", true, action);users.add(obj1);
	 obj1 = new User("Harish", "Type2", true, action);users.add(obj1);
	 obj1 = new User("Harish", "Type2", true, action);users.add(obj1);
	 obj1 = new User("Harish", "Type2", true, action);users.add(obj1);
	return users;
	
    }
    
    public static  List<User> transformData(List<User> users){
	List<User> finalOutput = new ArrayList<User>();
	Map<String,Integer> countMap = new HashMap<String,Integer>();
	String key = null;
	for(User user : users) {
	    
	    if(user.isFlag()) {
		key = user.getName()+"_"+user.getType();
		if(countMap.containsKey(key)) {
		    countMap.put(key,countMap.getOrDefault(key, 0)+1);
		}else countMap.put(key,1);
		
	    }else {
		finalOutput.add(user);
	    }
	}
	if(countMap!=null && !countMap.isEmpty()) {
    	  for(Map.Entry<String,Integer> allSet : countMap.entrySet()) {
    	      String nameTypes[] = allSet.getKey().split("_");
    	      Map<String,String> actions = new HashMap<String,String>();
    	      actions.put("count",allSet.getValue()+"");
    	      User obj = new User(nameTypes[0],nameTypes[1],true,actions);
    	      finalOutput.add(obj);
    	  }
	}
	countMap =null;
	return finalOutput;
    }

}
