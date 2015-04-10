package factory;

public class test1 {
	View v;
	
	
	public test1(){
	v =	Factory_View.getInstance().getView();
	v.display();
	}
	
	
}
