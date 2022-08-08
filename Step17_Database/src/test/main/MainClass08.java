package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.db.DBConnect;


public class MainClass08 {
	public static void main(String[] args) {
		String name="맥북";
		String addr="미국";
		//추가할 회원 정보를 Map 객체에 담고
		Map<String, String> mem=new HashMap<>();
		mem.put("name", name);
		mem.put("addr", addr);
		//insert 메소드에 전달해서 DB에 저장되는 기능을 완성해 보세요.
		insert(mem);
	}
	
	//인자로 전달 받은 Map 객체에 있는 회원 정보를 DB 에 저장하는 메소드
	public static void insert(Map<String, String> map) {
		//MemberDto 객체에 담긴 회원 정보를 DB에 저장하는 작업을 해 보세요.(시퀀스 사용하기)
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql);
			//? 바인딩 할 게 있으면 바인딩한다.
			pstmt.setString(1, map.get("name"));
			pstmt.setString(2, map.get("addr"));
			//실행
			pstmt.executeUpdate();
	        System.out.println("회원정보를 저장했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {} //<-중요한 작업할 게 없으니 그냥 {}중괄호만 해도 된다.
		}
	}
}
