package designPatterns.StrategyPattern;

public class StrategyMulti implements StrategyPattern {

    public StrategyMulti() {
	System.out.println("StrategyMulti");
    }

    @Override
    public int operation(int x, int y) {
	return x * y;
    }

}
