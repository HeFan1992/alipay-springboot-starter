package com.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.mapper.RedMapper;
import com.alipay.pojo.Red;
import com.alipay.service.RedService;

@Service
public class RedServiceImpl implements RedService{
	
	@Autowired
	private RedMapper redMapper;

	@Override
	public void saveRed(Red record) throws Exception {
		redMapper.insert(record);
	}

}
