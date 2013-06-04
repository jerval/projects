
public class Testt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Testt testt = new Testt();
		testt.param(3,"");
	}

	public void param(int i,String...strs){
		System.out.println(i);
		System.out.println(strs.length);
	}
}
