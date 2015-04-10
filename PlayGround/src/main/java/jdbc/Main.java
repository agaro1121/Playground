package jdbc;

import java.sql.Connection;


public class Main {

	
	public static void main(String[] args) {

//		Test2 t2 = new Test2();
//		Test1 t1 = new Test1();
		
		Connection cn = CM.getInstance().getConnection();
		
		CM.disconnect();
		CM.disconnect();
		CM.disconnect();
		CM.disconnect();
		CM.disconnect();
		CM.disconnect();
		
	}

}
