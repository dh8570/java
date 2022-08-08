package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.pack.MemberDto;

public class MainClass17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 회원 정보를 입력\n(종료 : q)");
			String str = sc.nextLine();
			
			if(str.equals("q")) {
				break;
			}
			
			int num = 0;
			
			try {
				num = Integer.parseInt(str);
				System.out.println(num+"번 회원의 정보 조회 중..");
				MemberDao dao = new MemberDao();
				MemberDto mem = dao.getData(num);
				
				if(mem!=null) {
					System.out.println("이름 => "+mem.getName()+",\t주소 => "+mem.getAddr()+"\n");
				} else {
					System.out.println(num+"번 회원은 존재하지 않습니다.\n");
				}
			} catch(Exception e) {
				System.out.println("숫자를 입력하세요!");
			}
		}
	}
}
