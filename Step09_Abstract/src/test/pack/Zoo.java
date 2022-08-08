package test.pack;

public class Zoo {
	public class Monkey {
		public void say() {
			System.out.println("원숭이");
		}
	}
	
	public class Tiger {
		public void say() {
			System.out.println("호랑이");
		}
	}
	
	public Monkey getMonkey() {
		return new Monkey();
	}
	
	public Tiger getTiger() {
		return new Tiger();
	}
}
