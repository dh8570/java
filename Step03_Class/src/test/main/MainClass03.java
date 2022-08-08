package test.main;

import java.io.PrintStream;

import test.pack.Member;

public class MainClass03 {
	public static void main(String[] args) {
		Member mem = new Member(10, "a", "의왕시");
		
		mem.id = 10;
		mem.name = "a1";
		mem.addr = "의왕시";
		
		Member mem2 = new Member(100, "a2", "aa");
		
		mem.id = 200;
		
		System.out.println(mem2.id);
//		mem.info();
//		mem2.info();
	}
}
