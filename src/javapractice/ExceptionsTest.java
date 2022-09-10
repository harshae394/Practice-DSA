
package javapractice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

class A {
    void m1() throws Exception  {
	System.out.println("In m1 A");
    }
}

class B extends A {
    void m1() throws Exception, NullPointerException {
	System.out.println("In m1 B");
    }
    /**As IOException and Exception are checked exception, 
     * so you can not broaden the scope of Exception while method overriding.**/
}

public class ExceptionsTest {

    public void recursive(int num) {
	if(num==0) return;
	System.out.println(num);
	recursive(num--);
    }
    public void recursive2(int num) {
	if(num==0) return;
	System.out.println(num);
	recursive2(--num);
    }
    public void memoryError() {
	long cnt=0;
	while(true) {
	    Custom req = new Custom("harish",cnt+"");
	    cnt++;
   	}
    }
    public static int finalReturnTest() {
	int ans = 0;
	Object obj = new Object();
	obj.toString();
	try {
	    System.out.println("try method : ");
	    int x = 10/0;
	}catch(Exception e) {
	    ans = -1;
	    System.out.println("exception  occured: "+ans);
	   return -1;
	}finally {
	    ans = 2;
	    System.out.println("final exception occurred : "+ans);
	    return -200;
	}
	//return ans;
    }
    public static void main(String[] args) throws Exception{
	System.out.println("finalReturnTestO/P : "+ finalReturnTest());
	A a = new B();
	a.m1();
	
	ExceptionsTest obj = new ExceptionsTest();
	try {
	   // obj.recursive(12);
	   // obj.memoryError();
	}catch(Exception e) {
	    System.out.println("exception "+e.getMessage()+ "handled");
	}
	System.out.println("post errors echo...");
	//obj.recursive2(10);
    }
}

class Custom{
    private String name;
    private String id;
    
    public Custom(String name, String id) {
	super();
	this.name = name;
	this.id = id;
    }
    public Custom() {
	super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
	return "Custom [name=" + name + ", id=" + id + "]";
    }

}