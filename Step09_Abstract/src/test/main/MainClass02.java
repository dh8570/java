package test.main;

import java.util.Scanner;
import test.pack.*;


public class MainClass02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hp = 1000;
		System.out.println("시작 hp : "+hp);
		
		while(hp != 0) {
			System.out.print("권총 장전 : ");
			int attakAmount = sc.nextInt();
			hp = MainClass02.useWeapon(new Gun(), hp, attakAmount);
		}
	}
	
	public static int useWeapon(Weapon w, int hp, int bullet) {
		w.prepare(bullet);
		hp = w.attack(hp, bullet);
		System.out.println("\n");
		
		return hp;
	}
}
