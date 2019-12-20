package com.lemonban.base.study.readExcel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.lemonban.base.study.compareExcel.CompareExcel;

public class Invoke {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CompareExcel compareExcel = new CompareExcel();
		//1
		Class clazz1 = compareExcel.getClass();
		//2
		Class clazz2 = CompareExcel.class;
		
		//3s
		
		
		Class clazz3 = Person.class;
		Constructor con = clazz3.getConstructor();
		Person com=(Person) con.newInstance();
		
		
		Field field = clazz3.getDeclaredField("age");
		field.setAccessible(true);
		field.set(com, "shima");
		
		Method method = clazz3.getMethod("method", String.class);
		method.invoke(com, "?");
		
		
		
	
		
		System.out.println(com);
	}

}
