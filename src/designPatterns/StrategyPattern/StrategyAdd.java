package designPatterns.StrategyPattern;

public class StrategyAdd implements StrategyPattern {

    public StrategyAdd() {
	System.out.println("StrategyAdd");
    }

    @Override
    public int operation(int x, int y) {
	return x + y;
    }

}
