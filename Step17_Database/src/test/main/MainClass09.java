package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.db.DBConnect;
import test.pack.MemberDto;


public class MainClass09 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num=1;
		String name="호빵";
		String addr="아현동";
		
		//아래의 update() 메소드를 활용해서 회원 정보를 수정할 수 있도록 해 보세요.
		MemberDto dto = new MemberDto(num, name, addr);
		update(dto);
		
		
	}
	public static void update(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="UPDATE member"
		               + " SET name=?,"
		               + " addr=?"
		               + " WHERE num=?";
			//PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql);
			//? 바인딩 할 게 있으면 바인딩한다.
			pstmt.setString(1, dto.getName());
	        pstmt.setString(2, dto.getAddr());
	        pstmt.setInt(3, dto.getNum());
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
