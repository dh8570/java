package test.main;

import test.pack.*;

public class MainClass03 {
	public static void main(String[] args) {
		Remocon r1 = new Remocon() {
			@Override
			public void turnOn() {
				System.out.println("켜짐");
			}
			
			@Override
			public void turnOff() {
				System.out.println("꺼짐");
			}
			
			@Override
			public void up() {
				System.out.println("위로 이동");
			}
			
			@Override
			public void down() {
				System.out.println("아래로 이동");
			}
		};
		
		useRemocon(new Remocon() {
			@Override
			public void turnOn() {
				System.out.println("켜짐");
			}
			
			@Override
			public void turnOff() {
				System.out.println("꺼짐");
			}
			
			@Override
			public void up() {
				System.out.println("위로 이동");
			}
			
			@Override
			public void down() {
				System.out.println("아래로 이동");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.turnOff();
	}
}
