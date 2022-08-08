package test.pack;

public class Bike {
	public String name = null;
	
	public Bike(String name) {
		this.name = name;
	}
	
	public void ride() {
		System.out.println(this.name+" 바이크를 타고 달리는 중");
	}
}
