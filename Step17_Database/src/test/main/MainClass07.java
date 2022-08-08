package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.db.DBConnect;
import test.pack.MemberDto;


public class MainClass07 {
	public static void main(String[] args) {
		//member 테이블에 추가할 회원의 정보
		String name="덕기";
		String addr="남양주";
		
		//회원 한명의 정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//메소드를 호출하면서 MemberDto 객체를 전달한다.
		insert(dto);//Class07.(클래스명.)insert(dto);같은 공간에 있으니 생략 가능한 거
	}
	
	//회원 한명의 정보를 추가하는 메소드
	public static void insert(MemberDto dto) {
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
					pstmt.setString(1, dto.getName());
					pstmt.setString(2, dto.getAddr());
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
