package test.main;

import test.pack.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		obj.walk();
		int a1 = obj.getNumber();
		String a2 = obj.getGreeting();
	}
}
