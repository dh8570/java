package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.db.DBConnect;
import test.pack.MemberDto;

public class MainClass01 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDto mem = null;
		
		try {
			conn = new DBConnect().getConn();
			String query = "SELECT num, name, address FROM member ORDER BY num ASC";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			mem = new MemberDto();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("address");
				
				mem.setNum(num);
				mem.setName(name);
				mem.setAddr(addr);
				System.out.println(mem.getNum());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
