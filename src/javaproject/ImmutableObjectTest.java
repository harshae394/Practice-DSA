package javaproject;

class Address implements Cloneable{
    int num ;
    String name ;
    @Override
    protected Object clone() throws CloneNotSupportedException 
    {
      return super.clone();
    }
    public Address() {
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address(int num, String name) {
	super();
	this.num = num;
	this.name = name;
    }
    @Override
    public String toString() {
	return "Address [num=" + num + ", name=" + name + "]";
    }
    
}
final class Employee{
    final int no;
    final Address address;
    
    Address newAdd1;
    
    public int getNo() {
        return no;
    }
    public Address getAddress() {
	System.out.println("curr: "+this.address);
	
	newAdd1 = new Address(address.getNum(),address.getName());
	System.out.println(newAdd1==this.address);
	
        System.out.println("newOb: "+newAdd1);
        
        return newAdd1;
        
    }
    public Employee(int no, Address address) {
	super();
	this.no = no;
	this.address = address;
    }
    @Override
    public String toString() {
	return "["+ no + ", "+address + "]";
    }
    
}
public class ImmutableObjectTest {

    public static void main(String[] args) throws CloneNotSupportedException {
	
	Employee e1 = new Employee(10,new Address(2,"T1"));
	System.out.println(e1);
	e1.getAddress().setName("T2");
	System.out.println(e1);
	System.out.println(e1.newAdd1);
	Object clone = e1.getAddress().clone();
	System.out.println(clone);
    }

}
