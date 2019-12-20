package com.lemonban.base.study.httputil;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGet {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet get = new HttpGet("http://www.zuihaodaxue.cn/zuihaodaxuepaiming2016.html");
		CloseableHttpResponse response = httpClient.execute(get);
		
		System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));
	}

}
