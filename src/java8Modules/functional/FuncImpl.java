package java8Modules.functional;

public class FuncImpl {
    
    public static void main(String[] args) {
	FunctionalInterface2 obj =null;
	new FunctionalInterface2() {
	    
	    @Override
	    public void method1() {
		System.out.println("FunctionalInterface2-method");
	    }
	};
	//obj.method1();
	FunctionalInterface2.staticM1();
	
    }
}
