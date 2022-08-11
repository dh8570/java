package test.main;

import test.pack.*;
import java.util.ArrayList;
import java.util.List;

public class MainClass07 {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<Member>();
		
		Member[] mems = {
			new Member(1, "a1", "강남"),
			new Member(2, "a2", "서초"),
			new Member(3, "a3", "역삼")
		};
		
		for(Member mem:mems) {
			members.add(mem);
		}
		
		for(Member member:members) {
			System.out.print("번호 : "+member.num+", ");
			System.out.print("이름 : "+member.name+", ");
			System.out.println("주소 : "+member.addr);
		}
	}
}
