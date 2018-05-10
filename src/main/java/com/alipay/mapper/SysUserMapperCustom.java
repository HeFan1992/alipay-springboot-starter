package com.alipay.mapper;

import java.util.List;

import com.alipay.pojo.SysUser;

public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}