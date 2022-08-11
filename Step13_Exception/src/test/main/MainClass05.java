package test.main;

import java.util.Random;

import test.pack.SleepyException;

public class MainClass05 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		for(int i=0; i<100; i++) {
			int ranNum = ran.nextInt(10);
			System.out.println(i+1+"번째 작업 중");
			if(ranNum==5) {
				throw new SleepyException("num=5");
			}
		}
	}
}
