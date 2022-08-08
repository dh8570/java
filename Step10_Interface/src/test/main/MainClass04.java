package test.main;

import org.w3c.dom.UserDataHandler;

import test.pack.*;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void fix() {
				System.out.println("고친다");
			}
		});
	}
	
	public static void useDrill(Drill d) {
		d.fix();
	}
}
