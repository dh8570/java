package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		int[] a1 = {0, 1, 2};
		double[] a2 = {0.0, 1.0, 2.0};
		boolean[] a3 = {true, true, true};
		String[] a4 = {"0", "1", "2"};
		
		System.out.println(a1.length);
		
		int[] a5 = a1.clone();
		int[] a6 = a1;
	}
}
