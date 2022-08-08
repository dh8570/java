package test.pack;

public class MyObject {
	public void walk() {
		System.out.println("걷고 있어요");
	}
	
	public int getNumber() {
		return 10;
	}
	
	public String getGreeting() {
		return "aa";
	}
	
	public Car getCar() {
		return new Car();
	}
	
	public void setNum(int num) {
		System.out.println("num: "+num);
	}
	
	public void setName(String name) {
		System.out.println("name: "+name);
	}
	
	public void useRadio(Radio r) {
		r.listenMusic();
	}
	
	public void attack(Gun g, Arrow a) {
		System.out.println("총과 활로 공격");
	}
}
