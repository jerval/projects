package creational.simplefactory;

import creational.simplefactory.factory.FruitFactory;
import creational.simplefactory.fruit.Apple;
import creational.simplefactory.fruit.Banana;

/**
 * 
 * @author Jerval
 * @date 2011-4-11
 */
public class MainClass {

	public static void main(String[] args) {
		Apple apple = (Apple) FruitFactory.getFruit("apple");
		Banana banana = (Banana) FruitFactory.getFruit("banana");
		apple.eat();
		banana.eat();
	}
}
