package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		String[] names = new String[3];
		
		names[0] = "a1";
		names[1] = "a2";
		names[2] = "a3";
		
		for(int i=0; i<names.length; i++) {
			System.out.println("이름 : "+names[i]);
		}
	}
}
