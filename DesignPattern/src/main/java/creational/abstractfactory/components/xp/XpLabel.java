package creational.abstractfactory.components.xp;

import creational.abstractfactory.components.ILabel;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class XpLabel implements ILabel {

	@Override
	public void drawLabel() {
		System.out.println("draw xp label...");
	}

}
