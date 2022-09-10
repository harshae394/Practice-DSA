package transform;

import java.util.Map;

public class User {

    private String name;
    private String type;
    private boolean flag;
    private Map<String,String> action;
    
    public User() {
	super();
    }
    public User(String name, String type, boolean flag, Map<String, String> action) {
	super();
	this.name = name;
	this.type = type;
	this.flag = flag;
	this.action = action;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public Map<String, String> getAction() {
        return action;
    }
    public void setAction(Map<String, String> action) {
        this.action = action;
    }
    @Override
    public String toString() {
	return "User [name=" + name + ", type=" + type + ", flag=" + flag + ", action=" + action + "]";
    }
    
}
