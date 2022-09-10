package java8Modules.functional;

@FunctionalInterface
interface FunctionalInterface2 extends FunctionalInterface1 {

    void method1();

    static void staticM1() {
	System.out.println("FunctionalInterface2-staticM1");
    }
}
