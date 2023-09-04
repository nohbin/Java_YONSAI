package dbpkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbMgr {
	static Connection conn;
	public static Connection dbConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE" , "system","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
