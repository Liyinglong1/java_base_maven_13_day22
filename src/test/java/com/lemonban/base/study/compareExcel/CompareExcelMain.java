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
		compareExcel.compareExcel("E:\\风控授信列表 (21).xls", "E:\\风控授信列表 (20).xls");
//		"/case17/002.xlsx"
	}

}
