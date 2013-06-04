package creational.abstractfactory;

import creational.abstractfactory.components.IButton;
import creational.abstractfactory.components.ILabel;
import creational.abstractfactory.factory.IStyleFactory;

/**
 * @author Jerval
 * @date 2011-4-23
 */
public class CustomMsgBox {

	private IButton button;
	private ILabel label;

	public CustomMsgBox(IStyleFactory styleFactory) {
		setStyleFactory(styleFactory);
	}

	// 客户端依赖于抽象工厂，更换工厂不需要改动客户端
	public void setStyleFactory(IStyleFactory styleFactory) {
		setButton(styleFactory.getButton());
		setLabel(styleFactory.getlILabel());
	}

	// 依赖抽象，改变了元件实例客户端代码也不用更改
	public void setButton(IButton button) {
		this.button = button;
	}

	public void setLabel(ILabel label) {
		this.label = label;
	}

	public void show() {
		drawCustomMsgBox();
		button.drawButton();
		label.drawLabel();
	}

	private void drawCustomMsgBox() {
		System.out.println("draw CustomMsgBox...");
	}
}
