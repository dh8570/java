package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		InputStream ips = System.in;
		InputStreamReader ipr = new InputStreamReader(ips);
		System.out.println("입력 : ");
		
		try {
			int num = ipr.read();
			System.out.println(num);
			char ch = (char)num;
			System.out.println(ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
