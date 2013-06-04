package creational.factorymethod.factory;

import creational.factorymethod.father.Fruit;

/**
 * 
 * @author Jerval
 * @date 2011-4-11
 */
public interface FruitFactory {

	/**
	 * generate fruit factory interface
	 * 
	 * @return Fruit
	 */
	public Fruit getFruit();
}

