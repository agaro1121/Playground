package factory;

public class Factory_View {
	private static View view;

	private Factory_View(){

	}

	public static Factory_View getInstance(){
		Factory_View fv = new Factory_View();
		return fv;
	}
	
	public void setView(String type){
		try {	
			String path = "factory.";
			Class<? extends View> viewType = (Class<? extends View>) Class.forName(path+type);
			view = viewType.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static View getView(){
		return view;
	}
	
	
}
