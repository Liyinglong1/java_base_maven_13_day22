package com.lemonban.base.study.compareExcel;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcel {

	public static void main(String[] args) throws Exception{
		ReadExcel readExcel = new ReadExcel();
		 ArrayList<List> list3 = readExcel.readExcel("E:\\风控授信列表 (20).xls",0); 
		 
		 ArrayList<String> titleNameList = new ArrayList<String>();
		 titleNameList.add("会员ID1");
		 titleNameList.add("会员名称");
		 titleNameList.add("信用评分");
		 titleNameList.add("信用评级");
		 titleNameList.add("服务费");
		 titleNameList.add("总额度（元）");
		 titleNameList.add("可用额度（元）");
		 titleNameList.add("已用额度（元）");
		 titleNameList.add("部门");
		 titleNameList.add("营销顾问");
		 titleNameList.add("创建时间");
		 HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
		 HSSFSheet sheet = hSSFWorkbook.createSheet("sheetName");
		 //添加表头
		 HSSFRow row = sheet.createRow(0);
		 for (int i = 0; i < titleNameList.size(); i++) {
			 row.createCell(i).setCellValue(titleNameList.get(i));
		}	 
		 for (int j = 1; j < list3.size(); j++) {
			 HSSFRow rowIndex = sheet.createRow(j);
			 
			 
			 for (int k = 0; k < list3.get(j).size(); k++) {  
				 System.out.println(j + "=====" + k);
				 rowIndex.createCell(k).setCellValue((String) list3.get(j).get(k));
			}
			 
		}		 
		 //创建一个文件输出流
		 FileOutputStream stream =  new FileOutputStream("E:\\\\1.xls");
		 hSSFWorkbook.write(stream);
		 stream.close();
	}
		 
		 
}


