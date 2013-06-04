package junit.test;

public class MainTest {

	public static void main(String[] args) {
		new MainTest().erro();
	}
	public void erro(){
		throw new RuntimeException("errrrrr");
	}

}
