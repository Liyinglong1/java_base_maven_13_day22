package com.lemonban.base.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class IteratorGetValue {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "11");
		map.put("2", "22");
		map.put("3", "33");
		map.put("4", "44");
		
		Iterator<String> iter2 = map.keySet().iterator();
		while (iter2.hasNext()) {
			String key = iter2.next();
			String value = map.get(key);
			System.out.println(key+"---"+value);
		}
	}

}
