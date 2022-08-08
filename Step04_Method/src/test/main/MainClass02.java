package test.main;

import test.pack.Car;
import test.pack.MyObject;

public class MainClass02 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		Car car = obj.getCar();
//		car.info();
		car.drive();
	}
}
