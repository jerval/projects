package creational.abstractfactory;

import creational.abstractfactory.factory.VistaStyleFactory;
import creational.abstractfactory.factory.XpStyleFactory;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class MainClass {

	public static void main(String[] args) {
		//show xp style msgBox
		CustomMsgBox xpStyleMsgBox = new CustomMsgBox(new XpStyleFactory());
		xpStyleMsgBox.show();
		//show vista style msgBox
		CustomMsgBox vistaStyleMsgBox = new CustomMsgBox(new VistaStyleFactory());
		vistaStyleMsgBox.show();
	}
}
