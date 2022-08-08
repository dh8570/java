package test.main;

import test.pack.*;

public class MainClass06 {
	public static void main(String[] args) {
		MemberDto dto1 = new MemberDto(1, "a1", "aa1");
		MemberDto dto2 = new MemberDto(2, "a2", "aa2");
		MemberDto dto3 = new MemberDto(3, "a3", "aa3");
		
		MemberDto[] members = {dto1, dto2, dto3};
		for(int i=0; i<members.length; i++) {
			System.out.println("번호:"+members[i].getNum()
					+", 이름:"+members[i].getName()
					+", 주소:"+members[i].getAddr()+"\n");
		}
	}
}
