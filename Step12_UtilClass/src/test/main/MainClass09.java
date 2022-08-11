package test.main;

import java.util.HashMap;
import java.util.Scanner;

public class MainClass09 {
	public static void main(String[] args) {
		HashMap<String, String> dict = new HashMap<String, String>();
		
		dict.put("데이터", "data");
		dict.put("과학", "science");
		dict.put("house", "집");
		dict.put("phone", "전화기");
		dict.put("car", "자동차");
		
		System.out.println(dict.keySet());
		
		System.out.println(dict.values());
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 단어를 입력하세요 : ");
		String inputKey = sc.nextLine();
		
		if(!dict.containsKey(inputKey)) {
			System.out.println(inputKey+"은 목록에 없습니다.");
		} else {
			System.out.println(inputKey+"의 뜻은 "+dict.get(inputKey)+"입니다.");
		}
	}
}
