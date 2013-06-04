package creational.abstractfactory.factory;

import creational.abstractfactory.components.IButton;
import creational.abstractfactory.components.ILabel;
import creational.abstractfactory.components.xp.XpButton;
import creational.abstractfactory.components.xp.XpLabel;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class XpStyleFactory implements IStyleFactory{

	@Override
	public IButton getButton() {
		return new XpButton();
	}

	@Override
	public ILabel getlILabel() {
		return new XpLabel();
	}

}
