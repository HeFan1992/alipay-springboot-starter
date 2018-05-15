package com.alipay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.mapper.RedMapper;
import com.alipay.mapper.RedMapperCustom;
import com.alipay.pojo.Red;
import com.alipay.service.RedService;

@Service
public class RedServiceImpl implements RedService{
	
	@Autowired
	private RedMapper redMapper;
	
	@Autowired
	private RedMapperCustom redMapperCustom;

	@Override
	public void saveRed(Red record) throws Exception {
		redMapper.insert(record);
	}

	@Override
	public boolean calculationSum() {
		boolean flag = false;
		int row = redMapperCustom.calculationSum();
		if(row > 0) {
			flag = true;
		}
		return flag;
	}

}
