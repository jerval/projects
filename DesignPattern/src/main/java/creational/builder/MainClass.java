package creational.builder;

import creational.builder.builder.BrickBuilder;
import creational.builder.builder.StoneBuilder;

/**
 * @author Jerval
 * @date 2011-4-25
 */
public class MainClass {

	public static void main(String[] args) {
		int design[][] = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 2, 1 },
				{ 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 2, 1, 0, 1, 1 },
				{ 1, 1, 0, 1, 0, 1, 1 }, { 1, 0, 0, 2, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 } };
		Commander commander = new Commander();
		commander.setDesign(design);
		commander.setBuilder(new StoneBuilder());
		commander.build();
		System.out.println("=========================");
		commander.setBuilder(new BrickBuilder());
		commander.build();
	}
}
