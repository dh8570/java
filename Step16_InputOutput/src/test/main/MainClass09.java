package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass09 {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/test.txt");
		
		if(f.exists()) {
			f.delete();
			System.out.println("파일을 삭제하였습니다.");
		} else {
			try {
				f.createNewFile();
				System.out.println("파일을 생성하였습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
