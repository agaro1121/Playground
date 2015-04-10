package jdbc;

import java.sql.Connection;

public class Test1 {
	
	public Test1(){
		Connection connection = CM.getInstance().getConnection();
	}

}
