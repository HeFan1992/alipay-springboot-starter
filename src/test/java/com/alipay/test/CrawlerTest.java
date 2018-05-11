package com.alipay.test;

import org.junit.jupiter.api.Test;

import com.alipay.util.spider.HttpGetUtil;

class CrawlerTest {

	@Test
	void test() {
		try {
			//解析 URL 返回数据
			HttpGetUtil.getByString("http://datachart.500.com/ssq/history/history.shtml");
			//获取返回结果,插入数据库
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
