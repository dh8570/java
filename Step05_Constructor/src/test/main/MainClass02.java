package test.main;

import test.pack.*;

public class MainClass02 {
	public static void main(String[] args) {
		new Member();
		for(int i=1; i<4; i++) {
			Member mem1 = new Member(i, "a"+i, "aa"+i);
		}
	}
}
