package test.main;

import java.util.Random;

public class MainClass07 {
	public static void main(String[] args) {
		Random ran = new Random();
		int ranNum = ran.nextInt(0, 10);
		System.out.println(ranNum);
	}
}
