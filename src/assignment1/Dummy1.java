package assignment1;

abstract class demo{
    int a; 
    demo(){
	a= 0;
    }
    abstract  public void set (int a);
    
    abstract  public int get();
}
class test extends demo{
    
    @Override
    public void set(int a) {
	this.a =a;
	
    }
    @Override
    public int get() {
	return a;
    }
}
public class Dummy1 {

    public static void main(String[] args) {
	demo d = new test();	
	d.set(101);
	System.out.println(d.get());

	Integer ss= null;
    }

}
