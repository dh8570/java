package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File f = new File("C:/");
		File[] files = f.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				System.out.println("["+file.getName()+"]");
			} else {
				System.out.println(file.getName());
			}
		}
	}
}
