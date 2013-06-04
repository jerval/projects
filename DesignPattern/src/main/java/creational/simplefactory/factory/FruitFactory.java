package creational.simplefactory.factory;

import creational.simplefactory.fruit.Apple;
import creational.simplefactory.fruit.Banana;
import creational.simplefactory.fruit.IFruit;

/**
 * 
 * @author Jerval
 * @date 2011-4-11
 */
public class FruitFactory {

	/**
	 * generate fruit factory
	 * 
	 * @param clazz
	 * @return
	 */
	public static IFruit getFruit(String fruitName){
		if("apple".equalsIgnoreCase(fruitName)){
			return new Apple();
		}else if("banana".equalsIgnoreCase(fruitName)){
			return new Banana();
		}else{
			System.out.println("can not find the fruit named:"+fruitName);
		}
		return null;
	}
}

