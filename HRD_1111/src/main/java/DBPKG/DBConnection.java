package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection conn;
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "system";
		String pwd = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,id,pwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return conn;
	}
}
