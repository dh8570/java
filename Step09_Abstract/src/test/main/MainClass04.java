package test.main;

import test.pack.Weapon;

public class MainClass04 {
	public static void main(String[] args) {
		Weapon w = new Gun();
		MainClass04.useWeapon(w);
		
		class Missile extends Weapon {
			@Override
			public int attack(int hp, int bullet) {
				System.out.println("Missile공격");
				return 0;
			}
		}
		
		Weapon w2 = new Missile();
		useWeapon(w2);
		
		useWeapon(new Missile());
	}
	
	
	public static class Gun extends Weapon {
		@Override
		public int attack(int hp, int bullet) {
			System.out.println("공격");
			return 0;
		}
	}
	
	
	public static void useWeapon(Weapon w) {
		w.prepare(10);
		w.attack(1000, 10);
	}
}
