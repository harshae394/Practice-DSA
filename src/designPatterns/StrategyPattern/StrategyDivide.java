package designPatterns.StrategyPattern;

public class StrategyDivide implements StrategyPattern {

    public StrategyDivide() {
	System.out.println("StrategyDivide");
    }

    @Override
    public int operation(int x, int y) {
	return x / y;
    }

}
