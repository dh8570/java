package test.main;

import test.dao.MemberDao;

public class MainClass16 {
	 public static void main(String[] args) {
		int num = 21;
		boolean isSuccess = false;
		
		isSuccess = new MemberDao().delete(num);
		
		if(isSuccess) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
