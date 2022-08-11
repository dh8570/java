package test.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass14 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:/acorn202206/testFolder/7.jpg");
			fos = new FileOutputStream("C:/acorn202206/testFolder/test.jpg");
			while(true) {
				int data = fis.read();
				System.out.println(data);
				if(data==-1) {
					break;
				}
				fos.write(data);
				fos.flush();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) fos.close();
				if(fis!=null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
