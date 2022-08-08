package test.main;

import test.dao.MemberDao;
import test.pack.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
		int num = 3;
		String name = "라면";
		String addr = "농심";
		boolean isSuccess = false;
		
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto(num, name, addr);
		isSuccess = dao.update(dto);
		
		if(isSuccess) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
}
