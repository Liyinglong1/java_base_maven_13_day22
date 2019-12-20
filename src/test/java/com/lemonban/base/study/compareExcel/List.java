package com.lemonban.base.study.compareExcel;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

public class List {
	public static void main(String[] args) {
		ArrayList<ArrayList> list1 = new ArrayList<ArrayList>();
		ArrayList<ArrayList> list2 = new ArrayList<ArrayList>();
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<String> list4 = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			if (i%2==0) {
				ArrayList<String> iList= new ArrayList<String>();
				iList.add("1");
				iList.add("2");
				iList.add("3");
				list2.add(iList);
				
			}
		}
		list1.add(list2);
		
		
		System.out.println(list1.toString());
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).get(i));
		}
	}
}
