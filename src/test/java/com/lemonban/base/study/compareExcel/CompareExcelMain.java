package com.lemonban.base.study.compareExcel;

import java.util.Scanner;

public class CompareExcelMain {

	public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//		String firstExcelPath = scanner.next();
//		String secondExcelPath = scanner.next();
//		
		CompareExcel compareExcel = new CompareExcel();
//		compareExcel.compareExcel(firstExcelPath, secondExcelPath);
		compareExcel.compareExcel("E:\\ideaCode\\java_base_maven_13_day22\\src\\test\\resources\\case17\\001.xlsx", "E:\\ideaCode\\java_base_maven_13_day22\\src\\test\\resources\\case17\\002.xlsx");
//		"/case17/002.xlsx"
	}

}
