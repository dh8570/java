package test.main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i=0; i<3; i++) {
			System.out.print("사용자 입력 : ");
			names.add(sc.nextLine());
		}
		
		for(String tmp:names) {
			System.out.println(tmp);
		}
	}
}
