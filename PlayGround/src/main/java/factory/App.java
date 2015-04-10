package factory;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory_View.getInstance().setView("gui");

		test1 t1 = new test1();
		test2 t2 = new test2();
		
		System.out.println(App.class.getName());
		
	}

}
