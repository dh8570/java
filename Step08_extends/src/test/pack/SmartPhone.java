package test.pack;

public class SmartPhone extends Phone {
	public SmartPhone() {
		super("a1");
		System.out.println("SmartPhone 생성자");
	}
	
	public void mobileCall() {
		System.out.println("Smart 전화하는 중");
	}
	
	public void takePicture() {
		System.out.println("aa");
	}
}
