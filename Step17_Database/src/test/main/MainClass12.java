package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.db.DBConnect;


public class MainClass12 {
	public static void main(String[] args) {
		boolean isSuccess = delete(2);
		
		if(isSuccess) {
			
		} else {
			
		}
	}
	
	//회원 한 명의 정보를 삭제하는 메소드
	public static boolean delete(int num) { //static 메소드 안 붙이면 main에서 에러남
		Connection conn=null;
		PreparedStatement pstmt=null;
		int updatedRowCount=0;
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체 얻어내기
			pstmt=conn.prepareStatement(sql);
			//? 바인딩 할 게 있으면 바인딩한다.
			pstmt.setInt(1, num);
			//실행
			updatedRowCount=pstmt.executeUpdate();
	        System.out.println("회원정보를 삭제했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {} //<-중요한 작업할 게 없으니 그냥 {}중괄호만 해도 된다.
		}
		if(updatedRowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
}
