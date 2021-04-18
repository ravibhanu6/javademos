package ola.com.booking;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConectionManager {

	public static Connection conn; 
	
	public static Connection getConnection() {
	String url = "jdbc:mysql://localhost:3306/demo";
	String username = "ravi";
	String password = "ravi";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	}

}
