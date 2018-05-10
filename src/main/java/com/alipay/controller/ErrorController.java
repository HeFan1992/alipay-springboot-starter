package com.alipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("err")
public class ErrorController {
	
	@RequestMapping("/error")
	public String error() {
		
		//暂时注释
		//int a = 1 / 0;
		
		return "error";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		
		return "ajaxerror";
	}

}
