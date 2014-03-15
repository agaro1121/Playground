package factory;

public class test2 {
	View v;
	
	
	public test2(){
		v = Factory_View.getInstance().getView();
		v.display();
	}

}
