package test.main;

import test.pack.Car;

public class MainClass02 {
	public static void main(String[] args) {
		Car car = new Car();
//		System.out.println(car.name);
//		car.drive();
		
		car.speed = 10;
		System.out.println("car : " + car.speed);
		
		Car car2 = new Car();
		System.out.println("car2 : " + car2.speed);
	}
}
