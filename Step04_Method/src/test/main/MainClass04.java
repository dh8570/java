package test.main;

import test.pack.MyObject;
import test.pack.*;


public class MainClass04 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		obj.useRadio(new Radio());
		
		obj.attack(new Gun(), new Arrow());
	}
}
