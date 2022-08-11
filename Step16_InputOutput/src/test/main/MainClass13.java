package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/testFolder/test.txt");
		FileReader reader = null;
		BufferedReader br = null
				;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			reader = new FileReader(f);
			br = new BufferedReader(reader);
			while(br.ready()) {
				System.out.println(br.readLine());
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(reader!=null) reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
