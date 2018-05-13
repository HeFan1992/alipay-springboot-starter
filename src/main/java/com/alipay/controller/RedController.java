package com.alipay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.pojo.Red;
import com.alipay.service.RedService;
import com.alipay.util.JsonUtils;
import com.alipay.util.spider.HttpGetUtil;

@RestController
public class RedController {
	
	@Autowired
	private RedService redService;
	
	@RequestMapping(name = "addRedMethod", method = RequestMethod.GET)
	public String addRedMethod() {
		try {
			//解析 URL 返回数据
			String redJson = HttpGetUtil.getByString("http://datachart.500.com/ssq/history/history.shtml");
			//获取返回结果,插入数据库
			List<Red> redList = JsonUtils.jsonToList(redJson, Red.class);
			if(redList != null) {
				for (Red red : redList) {
					redService.saveRed(red);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "红球添加成功！";
	}

}
