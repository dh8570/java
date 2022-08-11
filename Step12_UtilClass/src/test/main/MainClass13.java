package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.pack.*;

public class MainClass13 {
	public static void main(String[] args) {
		List<HashMap<String, Object>> list = new ArrayList<>();
		HashMap<String, Object> dict = new HashMap<>();
		Crawling craw = new Crawling();
		
		int len = craw.getNames().length;
		String[] names = craw.getNames();
		String[] arrs = craw.getAddrs();
		
		for(int i=0; i<len; i++) {
			dict.put("num", i);
			dict.put("name", names[i]);
			dict.put("addr", arrs[i]);
			list.add(dict);
		}
		
		System.out.println(list);
	}
}
