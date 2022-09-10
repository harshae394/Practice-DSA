package designPatterns.abstrctFactory;

import designPatterns.FactoryPattern.Shape;

public class AbstractFactoryPatternDemo {
   public static void main(String[] args) {
	   
      AbstractFactory shapeFactory = FactoryProducer.getFactory(false);//Rounded factory
      Shape shape1 = shapeFactory.getShape("RECTANGLE");
      shape1.draw();

      Shape shape2 = shapeFactory.getShape("SQUARE");
      shape2.draw();

      AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);//Non rounded factory
      Shape shape3 = shapeFactory1.getShape("RECTANGLE");
      shape3.draw();

      Shape shape4 = shapeFactory1.getShape("SQUARE");
      shape4.draw();
      
   }
}