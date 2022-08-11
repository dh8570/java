package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MainClass16 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		
		Random ran = new Random();
		
		while(set.size() != 6) {
			set.add(ran.nextInt(1, 46));
		}
		
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}
	}
}
