package com.alipay.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.pojo.AlipayJsonResult;

@ControllerAdvice
public class AlipayExceptionHandler {

	public static final String ALIPAY_ERROR_VIEW = "error";
	
	@ExceptionHandler(value = Exception.class)
	public Object errorHandler(HttpServletRequest request,
			HttpServletResponse response,Exception e) throws Exception {
		
		e.printStackTrace();
		
		if(isAjax(request)) {
			return AlipayJsonResult.errException(e.getMessage());
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", request.getRequestURL());
			mav.setViewName(ALIPAY_ERROR_VIEW);
			return mav;
		}
		
	}
	
	/**
	 * 
	 * @Title: IMoocExceptionHandler.java
	 * @Package com.imooc.exception
	 * @Description: 判断是否是ajax请求
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年12月3日 下午1:40:39
	 * @version V1.0
	 */
	private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null) && ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) ;
    }
    
}