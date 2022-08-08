package test.pack;

public class Remocon2 implements Remocon {
	@Override
	public void turnOn() {
		System.out.println("켜짐");
	}
	
	@Override
	public void turnOff() {
		System.out.println("꺼짐");
	}
	
	@Override
	public void up() {
		System.out.println("위로 이동");
	}
	
	@Override
	public void down() {
		System.out.println("아래로 이동");
	}
}
