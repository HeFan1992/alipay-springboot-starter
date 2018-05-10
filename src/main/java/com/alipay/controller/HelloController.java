package com.alipay.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.pojo.AlipayJsonResult;
import com.alipay.pojo.Resource;

@RestController
public class HelloController {
	
	@Autowired
    private Resource resource;

    @RequestMapping(value = "/hello")
    public Object hello(){
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/getResource")
    public AlipayJsonResult getResource(){

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);

        return AlipayJsonResult.ok(bean);
    }

}
