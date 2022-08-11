package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass14 {
	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("a1");
		names.add("a2");
		names.add("a3");
		names.add("a4");
		names.add("a5");
		
		System.out.println(names);
		
		Iterator<String> iter = names.iterator();
		
		while(iter.hasNext()) {
			String item = iter.next();
			System.out.println(item);
		}
	}
}
