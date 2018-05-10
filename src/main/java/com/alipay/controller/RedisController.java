package com.alipay.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.pojo.AlipayJsonResult;
import com.alipay.pojo.SysUser;
import com.alipay.pojo.User;
import com.alipay.util.JsonUtils;
import com.alipay.util.RedisOperator;

@RestController
@RequestMapping("redis")
public class RedisController {

	/*@Autowired
	private StringRedisTemplate strRedisTemplate;*/
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public AlipayJsonResult test() {
		
		//strRedisTemplate.opsForValue().set("alipay-cache", "hello ~~~");
		redis.set("alipay-cache", "hello ~~~");
		
		SysUser user = new SysUser();
		user.setId("123456");
		user.setNickname("alipay");
		user.setAge(18);
		
		redis.set("json:user", JsonUtils.objectToJson(user));
		
		SysUser sysUser = JsonUtils.jsonToPojo(redis.get("json:user"), SysUser.class);
		
		System.out.println(sysUser.toString());
		
		return AlipayJsonResult.ok(redis.get("alipay-cache"));
	}
	
	@RequestMapping("/getJsonList")
	public AlipayJsonResult getJsonList() {
		
		User user = new User();
		user.setAge(18);
		user.setName("慕课网");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("hello imooc");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = redis.get("json:info:userlist");
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		return AlipayJsonResult.ok(userListBorn);
	}
	
}
