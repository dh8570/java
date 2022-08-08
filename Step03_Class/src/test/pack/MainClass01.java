package test.pack;
import test.pack.Calculater;

public class MainClass01 {
	public static void main(String[] args) {
		Calculater cal = new Calculater();
		cal.exec(10, 10, "*");
		
		cal.brand = "a1";
		String a = cal.brand;
	}
}
