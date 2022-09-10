package exceptionsTest;

class ExceptionsTest {

    public static void main(String args[]) throws Exception {
	//throwTest();
	driverException();
	System.out.println("after throw test");
    }

    public static void throwTest() {

	try {
	    //throw new NullPointerException(); // exception 1
	     throw new ArithmeticException(); // exception 2
	} catch (NullPointerException e) {
	    System.out.println("caught NPE :" + e);
	}
	System.out.println("smooth flow...");
    }
    
    public static void driverException() throws Exception {
	try{
	    transferException(0);
	}catch(Exception e) {
	    System.out.println("driverException-catch.."+e);    
	}
	System.out.println("after driverException..");
    }
    public static void transferException(int x ) {
	int y =10;
	try{
	    y = y/x;
	}catch(Exception e) {
	    System.out.println("in catch-transferException");
	    throw new ArithmeticException("cannot be divided....");
	    //System.out.println("in catch-after-transferException");
	}
    }
}