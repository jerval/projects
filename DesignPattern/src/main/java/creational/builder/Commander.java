package creational.builder;

import creational.builder.builder.IBuilder;

/**
 * @author Jerval
 * @date 2011-4-25
 */
public class Commander {

	private IBuilder builder;
	private int[][] design;

	public void setBuilder(IBuilder builder) {
		this.builder = builder;
	}

	public void setDesign(int[][] design) {
		this.design = design;
	}

	public void build() {
		for (int i = 0; i < design.length; i++) {
			for (int j = 0; j < design[i].length; j++) {
				switch (design[i][j]) {
				case 0:
					builder.createSpace();
					break;
				case 1:
					builder.createWall();
					break;
				case 2:
					builder.createPillar();
					break;
				default:
					System.out.println("the value:" + design[i][j]
							+ " is undefined!");
					break;
				}
			}
			builder.nextFloor();
		}
	}
}
