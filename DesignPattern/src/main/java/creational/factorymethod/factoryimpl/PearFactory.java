package creational.factorymethod.factoryimpl;

import creational.factorymethod.factory.FruitFactory;
import creational.factorymethod.father.Fruit;
import creational.factorymethod.product.Pear;

/**
 * @author Jerval
 * @date 2011-4-13
 */
public class PearFactory implements FruitFactory {

	@Override
	public Fruit getFruit() {
		return new Pear();
	}

}
