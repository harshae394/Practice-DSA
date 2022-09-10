import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassLoadingTest {

    class ClassLoadingTestInner {
	{
	    System.out.println("ClassLoadingTestInner-static");
	}
    }
   public ClassLoadingTest(){
	System.out.println("default-cons ClassLoadingTest");
    }
    static {
	System.out.println("ClassLoadingTest-static");
    }

    public static void main(String[] args) throws Exception {
	System.out.println("ClassLoadingTest-main");
	Class clazz = Class.forName("ClassLoadingTest");
	Constructor<ClassLoadingTest> ctr= clazz.getDeclaredConstructor();
	ctr.setAccessible(true);
	System.out.println("bfore creating...");
	ClassLoadingTest s3 = ctr.newInstance();
	System.out.println("Hashcode of Object s3: " +s3.hashCode());
    }
}

class SubClass {
    static {
	System.out.println("SubClass-static");
    }

    public static void main(String[] arg) {
	System.out.println("SubClass-main2");
    }
}