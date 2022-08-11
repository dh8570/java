package test.main;

import test.pack.*;

public class MainClass01 {
	public static void main(String[] args) {
		FruitBox<Apple> apple = new FruitBox<Apple>();
		apple.setItem(new Apple());
		apple.getItem();
		
		FruitBox<Banana> banana = new FruitBox<Banana>();
		banana.setItem(new Banana());
		banana.getItem();
	}
}
