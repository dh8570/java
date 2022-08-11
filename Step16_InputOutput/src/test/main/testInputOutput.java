package test.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class testInputOutput {
	public static void main(String[] args) {
		File f = new File("C:/acorn202206/testFolder/quiz.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String text = sc.nextLine();
		
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			writer = new FileWriter(f, true);
			bw = new BufferedWriter(writer);
			bw.write(text);
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
				if(writer!=null) writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
