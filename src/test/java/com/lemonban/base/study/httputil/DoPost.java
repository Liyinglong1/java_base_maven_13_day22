package com.lemonban.base.study.httputil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.sym.Name;
import com.lemonban.base.study.compareExcel.List;

public class DoPost {

	public static void main(String[] args) throws Exception {
		System.out.println(postRequest());
	}

	public static String postRequest() throws UnsupportedEncodingException, IOException, ClientProtocolException {
		ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
//		userName=liyinglong&password=111111&_spam=1576825876508
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userName", "liyinglong");
		map.put("password", "111111");
		map.put("_spam", "1576825876508");

		
		Iterator iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String name = (String) iter.next();
			String value = map.get(name);
			BasicNameValuePair nameValuePair = new BasicNameValuePair(name, value);
			list.add(nameValuePair);
		}
		

		CloseableHttpClient HttpClient=HttpClients.createDefault();//创建发包客户端
		HttpPost post = new HttpPost("http://mgt.myhwdztest.com/api/login");//创建一个请求
		post.setEntity(new UrlEncodedFormEntity(list));//设置请求体
	
		CloseableHttpResponse response = HttpClient.execute(post);
		String responseEnity = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		return responseEnity;
	}

}
 