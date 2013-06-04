package creational.abstractfactory.factory;

import creational.abstractfactory.components.IButton;
import creational.abstractfactory.components.ILabel;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public interface IStyleFactory {

	public IButton getButton();
	public ILabel getlILabel();
}
