package com.lemonban.base.study.compareExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.lemonban.base.utils.ExcelUtils;

public class ReadExcel {
	
	 public static void main(String[] args) throws Exception {
		 ArrayList<List> list3 = readExcel("/case17/test_case_01.xlsx",0); 
		 for (int i = 0; i <list3.size(); i++) {
			 System.out.println(list3.get(i)); 
			 } 
		 }
	 

	public static  ArrayList<List> readExcel(String excelPath,int SheetNum) throws Exception {
		ArrayList<List> list = new ArrayList<List>();
		InputStream inputStream = new FileInputStream(excelPath);
		
//		inputStream = ReadExcel.class.getResourceAsStream(excelPath);
		// 获得一个工作簿对象
		Workbook workbook = null;
		workbook = WorkbookFactory.create(inputStream);
		// 获取指定的表单
		Sheet sheet  = workbook.getSheetAt(SheetNum);
		
		
		int rowNum = sheet.getLastRowNum()+1;//获取当前表有多少行
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("此表有"+rowNum+"行"+"---"+"有"+cellNum+"列");
		
		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i);
			
			ArrayList<String> rowList = new ArrayList<String>();
			
			for (int j = 0; j <cellNum; j++) {
				if (row.getCell(j)==null) {
					rowList.add("null");
				}else {
					String cell = row.getCell(j) +"";
					rowList.add(cell);
				}
			}
			list.add(rowList);
		}
		//打印list集合 
//		 for (int i = 0; i < list.size(); i++){
//			 System.out.println(list.get(i)); 
//		 }
		 
		 return list;
	}
}
