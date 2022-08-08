package test.pack;

public class Calculater {
	private static int x1, x2 = 0;
	public String brand = "aa";
	
	private static double plus() {
		System.out.println(x1+x2);
		return x1+x2;
	}
	
	private static double minus() {
		System.out.println(x1-x2);
		return x1-x2;
	}
	
	private static double product() {
		System.out.println(x1*x2);
		return x1*x2;
	}
	
	private static double division() {
		System.out.println(x1/x2);
		return x1/x2;
	}
	
	public void exec(int a1, int a2, String which) {
		System.out.println("계산해요!");
		x1 = a1;
		x2 = a2;
		System.out.printf(x1 + which + x2 + "=");
		switch(which) {
		case "+":
			plus();
			break;
		case "-":
			minus();
			break;
		case "*":
			product();
			break;
		case "/":
			division();
			break;
		default:
			break;
		}
	}
}
