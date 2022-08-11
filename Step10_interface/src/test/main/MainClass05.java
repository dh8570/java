package test.main;

import test.pack.*;

public class MainClass05 {
	int a1 = 10;
	int a2 = 20;
	Calc plus = (a1, a2) -> {
		return a1+a2;
	};
	
	Calc minus = (a1, a2) -> a1-a2;
	
	double result = plus.exec(a1, a2);
	double result2 = minus.exec(a1, a2);
}
