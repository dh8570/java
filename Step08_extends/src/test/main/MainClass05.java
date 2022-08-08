package test.main;

import test.pack.*;

public class MainClass05 {
	public static void main(String[] args) {
		Phone p1 = new foldablePhone();
		foldablePhone p2 = (foldablePhone) p1;
		p2.internet();
	}
}
