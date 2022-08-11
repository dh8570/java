package test.main;

import java.util.Random;

public class MainClass15 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		int num = ran.nextInt();
		
		int num2 = ran.nextInt(0, 10);
		
		System.out.println(num);
		System.out.println(num2);
	}
}
