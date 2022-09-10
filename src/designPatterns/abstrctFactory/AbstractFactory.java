package designPatterns.abstrctFactory;

import designPatterns.FactoryPattern.Shape;

public abstract class AbstractFactory {
	abstract Shape getShape(String shapeType);
}