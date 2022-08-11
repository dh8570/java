package test.main;

import java.io.File;
import java.util.Scanner;

public class MainClass10 {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/testFolder");
		
		f.mkdir();
		
		
		for(int i=0; i<1000; i++) {
			File testFile = new File("C:/acorn202206/testFolder/folder"+(i+1));
			if(testFile.exists()) {
				continue;
			} else {
				testFile.mkdir();
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("파일을 삭제하시겠습니까?\n[ 삭제 : 1, 유지 : 0 ]\n입력 : ");
		int isDelete = sc.nextInt();
		
		if(isDelete == 1) {
			new MainClass10().deleteFiles();
			System.out.print("삭제 후 시스템 종료");
		} else {
			System.out.print("생성 후 시스템 종료");
		}
	}
	
	public void deleteFiles() {
		for(int i=0; i<1000; i++) {
			File testFile = new File("C:/acorn202206/testFolder/folder"+(i+1));
			if(!(testFile.exists())) {
				continue;
			} else {
				testFile.delete();
			}
		}
	}
}
