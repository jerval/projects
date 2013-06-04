package creational.builder.builder;

/**
 * @author Jerval
 * @date 2011-4-25
 */
public interface IBuilder {

	public void createSpace();
	public void createWall();
	public void createPillar();
	public void nextFloor();
}
