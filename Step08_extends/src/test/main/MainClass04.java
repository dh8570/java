package test.main;

import test.pack.*;

public class MainClass04 {
	public static void main(String[] args) {
		SmartPhone p2 = new SmartPhone();
		foldablePhone p1 = (foldablePhone) p2;
		p1.internet();
		
		
		foldablePhone p3 = (foldablePhone) p2;
	}
}
