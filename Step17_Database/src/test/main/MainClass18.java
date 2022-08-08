package test.main;

import java.util.ArrayList;
import java.util.List;

import test.dao.MemberDao;
import test.pack.MemberDto;

public class MainClass18 {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		List<MemberDto> memList = new ArrayList<MemberDto>();
		MemberDto mem = new MemberDto();
		
		memList = dao.getAllData();
		for(int i=0; i<memList.size(); i++) {
			mem = memList.get(i);
			System.out.println("번호 => "+mem.getNum()+",\t이름 => "+mem.getName()+"\t주소 => "+mem.getAddr());
		}
	}
}
