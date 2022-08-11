package test.main;

import java.util.ArrayList;

import test.pack.*;

public class MainClass06 {
	public static void main(String[] args) {
		ArrayList<Car> cars = new ArrayList<Car>();
		
		Car car1 = new Car("BMW 3");
		Car car2 = new Car("BMW 5");
		Car car3 = new Car("BMW 7");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		for(Car car:cars) {
			car.drive();
		}
	}
}
