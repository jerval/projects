package creational.abstractfactory.components.xp;

import creational.abstractfactory.components.IButton;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class XpButton implements IButton {

	@Override
	public void drawButton() {
		System.out.println("draw xp button....");
	}

}
