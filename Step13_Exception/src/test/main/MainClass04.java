package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass04 {
		public static void main(String[] args) {
			File f = new File("C:/acorn202206/test/a.txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
