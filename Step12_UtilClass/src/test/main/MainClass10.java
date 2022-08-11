package test.main;

import java.util.HashMap;

public class MainClass10 {
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("num", 1);
		map.put("name", "a1");
		map.put("addr", "강남");
		
		int num = (int) map.get("num");
		String name = (String) map.get("name");
		String addr = (String) map.get("addr");
	}
}
