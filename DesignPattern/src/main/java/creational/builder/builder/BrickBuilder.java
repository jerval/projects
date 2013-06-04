package creational.builder.builder;

/**
 * @author Jerval
 * @date 2011-4-25
 */
public class BrickBuilder implements IBuilder {

	@Override
	public void createSpace() {
		System.out.print(" ");
	}

	@Override
	public void createWall() {
		System.out.print("|");
	}

	@Override
	public void createPillar() {
		System.out.print("I");
	}

	@Override
	public void nextFloor() {
		System.out.println();
	}

}
