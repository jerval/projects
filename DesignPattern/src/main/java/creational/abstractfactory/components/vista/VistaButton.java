package creational.abstractfactory.components.vista;

import creational.abstractfactory.components.IButton;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class VistaButton implements IButton {

	@Override
	public void drawButton() {
		System.out.println("draw vista button....");
	}

}
