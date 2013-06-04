package creational.abstractfactory.factory;

import creational.abstractfactory.components.IButton;
import creational.abstractfactory.components.ILabel;
import creational.abstractfactory.components.vista.VistaButton;
import creational.abstractfactory.components.vista.VistaLabel;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class VistaStyleFactory implements IStyleFactory{

	@Override
	public IButton getButton() {
		return new VistaButton();
	}

	@Override
	public ILabel getlILabel() {
		return new VistaLabel();
	}

}
