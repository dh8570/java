package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		
		String inputNum = sc.nextLine();
		
		try {
			double num = Double.parseDouble(inputNum);
			double result = num+100;
			System.out.println(inputNum+" + 100 = "+result);
		} catch(NumberFormatException e) {
			System.out.println("문자열 입력됨");
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("aa");
		}
	}
}
