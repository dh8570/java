package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass12 {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/testFolder/test.txt");
		
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileReader reader = new FileReader(f);
			BufferedReader br = new BufferedReader(reader);
			while(br.ready()) {
				System.out.println(br.readLine());
			}
			br.close();
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
