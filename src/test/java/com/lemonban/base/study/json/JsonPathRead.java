package com.lemonban.base.study.json;

import com.alibaba.fastjson.JSONPath;

public class JsonPathRead {

	public static void main(String[] args) {
		String str1="[{\"data\":{\"code\":\"4003\",\"message\":\"登录接口异常!\",\"targetUrl\":\"\"},\"mess\":\"登录接口异常!\",\"result\":\"登录接口异常!\",\"code\":4003,\"timeStamp\":1577327338016}]";
		System.out.println(JSONPath.read(str1, "$.data.code"));
		System.out.println(JSONPath.read(str1, "$.data.message"));
	}

}
