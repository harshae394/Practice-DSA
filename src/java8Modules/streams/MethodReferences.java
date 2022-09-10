package java8Modules.streams;

import java.util.function.Consumer;

public class MethodReferences {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
    
    private static void methodReferences() {
	
	Consumer<String> consumer = new Consumer<String>() {
	    @Override
	    public void accept(String s) {
		 System.out.println(s);
	    }
	};
	consumer.andThen(consumer);
	
    }

}
