package test.main;

import test.pack.*;

public class MainClass03 {
	public static void main(String[] args) {
		MacBook mac1 = new MacBook(new Cpu(), new Memory(), new HardDisk());
		mac1.doGame();
	}
}
