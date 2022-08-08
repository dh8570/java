package test.main;

import test.pack.*;

public class MainClass05 {
	public static void main(String[] args) {
		// 익명의 자식 클래스 정의
		// Weapon 클래스(부모 클래스)를 extends 받은 익명의 자식 클래스
		Weapon w1 = new Weapon() {
			@Override
			public int attack(int hp, int bullet) {
				return bullet;
			}
		};
		useWeapon(w1);
		
		
		useWeapon(new Weapon() {
			@Override
			public int attack(int hp, int bullet) {
				return bullet;
			}
		});
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare(1000);
		w.attack(1000, 10);
	}
}
