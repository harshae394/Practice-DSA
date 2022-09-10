package designPatterns.abstrctFactory;

import designPatterns.FactoryPattern.Shape;

public class RoundedSquare implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside RoundedSquare::draw() method.");
	}
}