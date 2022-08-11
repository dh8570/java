package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		File f = new File("C:/");
		String[] fileNames = f.list();
		for(String file:fileNames) {
			System.out.println(file);
		}
	}
}
