package test.main;

import test.pack.MemberDto;

public class MainClass05 {
	public static void main(String[] args) {
		MemberDto dto = new MemberDto();
		
		dto.setNum(10);
		dto.setName("a1");
		dto.setAddr("aa");
		
		int num = dto.getNum();
		String name = dto.getName();
		String addr = dto.getAddr();
	}
}
