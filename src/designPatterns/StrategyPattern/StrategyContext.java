package designPatterns.StrategyPattern;

public class StrategyContext {

    private StrategyPattern strategy;

    public StrategyContext(StrategyPattern strategy) {
	super();
	this.strategy = strategy;
    }

    public void execute(int x, int y) {
	int operation = strategy.operation(x, y);
	System.out.println("strategy: " + strategy + ", res: " + operation);
    }

    public StrategyPattern getStrategy() {
	return strategy;
    }

    public void setStrategy(StrategyPattern strategy) {
	this.strategy = strategy;
    }
}
