package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {
	public static void main(String[] args) {
		InputStream ips = System.in;
		System.out.println("입력 : ");
		try {
			int num = ips.read();
			System.out.println(num);
			char ch = (char)num;
			System.out.println(ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
