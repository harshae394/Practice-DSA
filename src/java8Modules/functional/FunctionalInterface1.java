package java8Modules.functional;

@FunctionalInterface
public interface FunctionalInterface1 {

    void method1();

    default void methodDef() {
	System.out.println("methodDEfault");
    }
    static void staticM1() {
	System.out.println("FunctionalInterface1-staticM1");
    }
}
