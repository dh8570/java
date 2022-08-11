package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<String>();
		str.add("a1");
		str.add("a2");
		str.add("a3");
		
		String item = str.get(0);
		
		str.remove(0);
		
		str.set(0, "a0");
		
		int size = str.size();
		
		str.clear();
	}
}
