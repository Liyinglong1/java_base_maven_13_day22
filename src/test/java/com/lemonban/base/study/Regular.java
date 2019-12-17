package com.lemonban.base.study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.impl.auth.NTLMEngineException;

import com.alibaba.fastjson.JSONObject;
import com.lemonban.base.utils.ParamUtils;

import bsh.This;

public class Regular {

	private static HashMap<String, String> allHashMap = new HashMap<String, String>();

	public String getAllHashMap(String name) {
		return allHashMap.get(name);
	}

	public static void setAllHashMap(String name, String value) {
		allHashMap.put(name, value);
	}

	public static void main(String[] args) {
		setAllHashMap("mobile_phone", "13888888889");
		setAllHashMap("pwd", "12345678");
		setAllHashMap("reg_name", "happy");

		String reg = "\"\\$\\{(.*?)\\}\"";
		String str = "{\"mobile_phone\":\"${mobile_phone}\",\"pwd\":\"${pwd}\",\"reg_name\":\"${reg_name}\"}";
		String a= regReplace(reg, str);
		System.out.println(a);
	}

	public static String regReplace(String reg,String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String totalStr = matcher.group();
			String paramName = matcher.group(1); 
			str = str.replace(totalStr, "\"" + allHashMap.get(paramName) + "\"");
			}
//		System.out.println(str);
		return str;
	}
}
