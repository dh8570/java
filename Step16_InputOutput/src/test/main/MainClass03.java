package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		InputStream ips = System.in;
		InputStreamReader ipr = new InputStreamReader(ips);
		BufferedReader bf = new BufferedReader(ipr);
		System.out.println("입력 : ");
		
		try {
			String text = bf.readLine();
			System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
