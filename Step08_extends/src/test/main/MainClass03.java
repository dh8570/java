package test.main;

import test.pack.*;

public class MainClass03 {
	public static void main(String[] args) {
		SmartPhone p1 = new SmartPhone();
		
		Phone p2 = p1;
		
		Object p3 = p1;
	}
}
