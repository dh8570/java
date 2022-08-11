package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("a1");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("a2");
	}
}
