package test.main;

import test.pack.*;

public class MainClass02 {
	public static void main(String[] args) {
		SmartPhone p1 = new SmartPhone();
		Phone p2 = new SmartPhone();
		Object p3 = new SmartPhone();
		
		p1.mobileCall();
		p2.call();
		p3.toString();
	}
}
