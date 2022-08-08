package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		int num=0;
		num++;
		num++;
		num++; // num 이 최종적으로 3이 된다.
		
		int num2=0;
		num2--;
		num2--;
		num2--;   // num2 가 최종적으로 -3이 된다.
		
		int num3=0;
		int result1 = num3++; // result1 에 0 이 대입되고 num3 가 1 증가한다.
		
		int num4=0;
		int result2 = ++num4; // num4 가 1 증가하고 result2 에 1 이 대입된다.
	}
}
