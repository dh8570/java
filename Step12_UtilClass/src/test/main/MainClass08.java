package test.main;

import java.util.ArrayList;
import java.util.List;
import test.pack.*;

public class MainClass08 {
	public static void main(String[] args) {
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		
		MemberDTO mem1 = new MemberDTO(1, "a1", "강남");
		MemberDTO mem2 = new MemberDTO();
		mem2.setNum(2);
		mem2.setName("a2");
		mem2.setAddr("서초");
		MemberDTO mem3 = new MemberDTO(3, "a3", "역삼");
		
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		
		for(MemberDTO mem:members) {
			System.out.println("번호 : "+mem.getNum()+", 이름 : "+mem.getName()+", 주소 : "+mem.getAddr());
		}
	}
}
