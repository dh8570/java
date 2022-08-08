package test.main;

import test.pack.*;

public class MainClass03 {
	public static void main(String[] args) {
		Zoo z = new Zoo();
		
		Zoo.Monkey m1 = z.getMonkey();
		m1.say();
		
		Zoo.Tiger t1 = z.getTiger();
		t1.say();
		
		class Cat{
			public void say() {
				System.out.println("냐옹");
			}
		}
		
		Cat cat = new Cat();
		cat.say();
	}
}
