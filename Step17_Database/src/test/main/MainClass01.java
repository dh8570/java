package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass01 {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			// 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클 DB 주소 경로 지정
			// @ip주소:port번호:db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 계정, 비밀번호를 이용해 db 연결
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			System.out.println("DB 접속에 성공하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT empno, ename FROM EMP ORDER BY empno ASC";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("empno");
				String name = rs.getString("ename");
				System.out.println("사원번호 : "+num+",\t사원명 : "+name);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
