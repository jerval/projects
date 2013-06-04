package creational.abstractfactory.components.vista;

import creational.abstractfactory.components.ILabel;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class VistaLabel implements ILabel {

	@Override
	public void drawLabel() {
		System.out.println("draw vista label...");
	}

}
