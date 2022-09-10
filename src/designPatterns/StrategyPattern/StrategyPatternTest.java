package designPatterns.StrategyPattern;

public class StrategyPatternTest {

    public static void main(String[] args) {

	StrategyContext st11 = new StrategyContext(new StrategyAdd());
	st11.execute(10, 12);
	
	 st11 = new StrategyContext(new StrategyMulti());
	st11.execute(10, 12);
	
	 st11 = new StrategyContext(new StrategyDivide());
	st11.execute(10, 12);
    }

}
