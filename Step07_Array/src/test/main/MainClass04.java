package test.main;

import test.pack.*;

public class MainClass04 {
	public static void main(String[] args) {
		Bike[] bikes = new Bike[3];
		for(int i=0; i<bikes.length; i++) {
			bikes[i] = new Bike("BMW Bike"+(i+1));
			bikes[i].ride();
		}
	}
}
