package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass15 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:/acorn202206/testFolder/7.jpg");
			fos = new FileOutputStream("C:/acorn202206/testFolder/test.jpg");
			byte[] buffer = new byte[1024];
			
			while(true) {
				int readedByte = fis.read(buffer);
				System.out.println(readedByte);
				if(readedByte==-1) {
					break;
				}
				fos.write(buffer, 0, readedByte);
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
