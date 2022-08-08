package test.main;

import test.dao.MemberDao;
import test.pack.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		String name = "상하이";
		String addr = "맥도날드";
		boolean isSuccess = true;
		
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto(0, name, addr);
		
		isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.println("회원정보를 추가했습니다.");
		} else {
			System.out.println("추가 실패");
		}
		
		MemberDto mem = dao.getData();
		System.out.println(mem.getNum()+" "+mem.getName()+" "+mem.getAddr());
	}
}
