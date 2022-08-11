package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<String>();
		str.add("a1");
		str.add("a2");
		str.add("a3");
		str.add("a4");
		str.add("a5");
		
		for(int i=0; i<str.size(); i++) {
			System.out.println(i+"번째 친구 : "+str.get(i));
		}
	}
}
