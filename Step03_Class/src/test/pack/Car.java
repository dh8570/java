package test.pack;

public class Car {
	public String name = "BMW M340i";
	public static int speed = 0;
	
	public void drive() {
		System.out.println("속도 UP");
		while(true) {
			speed++;
			System.out.println(speed);
			
			if(speed == 100) {
				stop();
				break;
			}
		}
	}
	
	public void stop() {
		System.out.println("속도 DOWN");
		while(speed != 0) {
			speed--;
			System.out.println(speed);
		}
	}
	
	
}
