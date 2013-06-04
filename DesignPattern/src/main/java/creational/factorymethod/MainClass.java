package creational.factorymethod;

import creational.factorymethod.factory.FruitFactory;
import creational.factorymethod.factoryimpl.AppleFactory;
import creational.factorymethod.factoryimpl.BananaFactory;
import creational.factorymethod.factoryimpl.PearFactory;
import creational.factorymethod.product.Apple;
import creational.factorymethod.product.Banana;
import creational.factorymethod.product.Pear;

/**
 * 
 * @author Jerval
 * @date 2011-4-11
 */
public class MainClass {

	public static void main(String[] args) {
		//get appleFactory
		FruitFactory appleFactory = new AppleFactory();
		//get apple object by appleFactory
		Apple apple = (Apple) appleFactory.getFruit();
		apple.get();
		
		//get bananaFactory
		FruitFactory bananaFactory = new BananaFactory();
		//get banana object by bananaFactory
		Banana banana = (Banana) bananaFactory.getFruit();
		banana.get();
		
		//get pearFactory
		FruitFactory pearFactory = new PearFactory();
		//get pear object by pearFactory
		Pear pear = (Pear) pearFactory.getFruit();
		pear.get();
	}
}
