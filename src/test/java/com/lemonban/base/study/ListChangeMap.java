package com.lemonban.base.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListChangeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("apiId=api_reg");
		list.add("apiName=注册");
		System.out.println(list.toString());
		Map hasMap = new HashMap<String, String>();
		hasMap.put("1", "1");
		Iterator iter = hasMap.keySet().iterator();
	 	while(iter.hasNext()) {
		 	Object key = iter.next();
		 	Object val = hasMap.get(key);
		 	System.out.println(val);
			}
	}
}
