package test.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConn() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB 연결 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
