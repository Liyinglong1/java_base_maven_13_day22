package com.lemonban.base.study.compareExcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareExcel {
	public String aString = "nihao";
	public static void compareExcel(String firstExcelPath,String secondExcelPath) throws Exception {
		ReadExcel readExcel = new ReadExcel();
		ArrayList<List> list1 = readExcel.readExcel(firstExcelPath, 0);
		ArrayList<List> list2 = readExcel.readExcel(secondExcelPath, 0);
		
		if (list1.size() > list2.size()) {
			System.out.println("第一个excel大于第二个excel");
		}else if (list1.size() < list2.size()) {
			System.out.println("第一个excel大于第二个excel");
		}else {
			for (int i = 0; i < list1.size(); i++) {
				for (int j = 0; j < list1.get(i).size(); j++) {
					if (!list1.get(i).get(j).equals(list2.get(i).get(j))) {
						System.out.println("第"+(i+1)+"行---第"+(j+1)+"列，不一样");
					}
				}
			}
		}
	}

}
