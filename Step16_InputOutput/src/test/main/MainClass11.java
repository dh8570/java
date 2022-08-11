package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass11 {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/testFolder/test.txt");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter writer = new FileWriter(f, true);
			writer.write("a1");
			writer.write("\na2");
			writer.flush();
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
