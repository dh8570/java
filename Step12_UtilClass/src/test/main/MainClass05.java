package test.main;

import java.util.ArrayList;

public class MainClass05 {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		for(Integer num:nums) {
			System.out.println(num);
		}
	}
}
