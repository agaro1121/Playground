package jdbc;

import java.sql.Connection;

public class Test2 {

	public Test2(){
		Connection connection = CM.getInstance().getConnection();
	}
}
