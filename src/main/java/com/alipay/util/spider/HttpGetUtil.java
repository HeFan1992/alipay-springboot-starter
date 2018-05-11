package com.alipay.util.spider;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetUtil {
	
	private static final Log log = LogFactory.getLog(HttpGet.class);
	
	/**
	 * 打开URL链接
	 * @param url
	 * @throws Exception
	 */
	public final static String getByString(String url) throws Exception{
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String redJson = "";
		try {
			HttpGet httpget = new HttpGet(url);
			log.info("执行请求	：" + httpget.getURI());
			
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				
				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					
					int status = response.getStatusLine().getStatusCode();
					if(status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity, "GBK") : null;
					}else {
						throw new ClientProtocolException("意外的返回状态	：" + status);
					}
				}
			};
			
			String responseBody = httpclient.execute(httpget, responseHandler);
			log.info("--------------------------------------------------");
			log.info("responseBody :" + responseBody);
			log.info("--------------------------------------------------");
			
			redJson = RarsePage.parseFromString(responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			httpclient.close();
		}
		return redJson;
	}

}
