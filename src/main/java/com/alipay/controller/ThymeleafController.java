package com.alipay.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.pojo.User;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name","thymeleaf-alipay");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(ModelMap map){
        return "thymeleaf/center/center";
    }

    @RequestMapping(value = "/test")
    public String test(ModelMap map){
        User user = new User();
        user.setName("superadmin");
        user.setBirthday(new Date());
        user.setPassword("123456");
        user.setAge(17);
        user.setDesc("<font color='green'<b>hello</b></font>");

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("alipay1");
        user1.setBirthday(new Date());
        user1.setPassword("123456");
        user1.setAge(18);
        user1.setDesc("<font color='green'<b>hello</b></font>");

        User user2 = new User();
        user2.setName("alipay2");
        user2.setBirthday(new Date());
        user2.setPassword("123456");
        user2.setAge(26);
        user2.setDesc("<font color='green'<b>hello</b></font>");

        User user3 = new User();
        user3.setName("alipay3");
        user3.setBirthday(new Date());
        user3.setPassword("123456");
        user3.setAge(18);
        user3.setDesc("<font color='green'<b>hello</b></font>");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);


        map.addAttribute("user",user);
        map.addAttribute("userList",userList);
        return "thymeleaf/test";
    }

    @RequestMapping(value = "postform")
    public String postform(User user){

        System.out.println("姓名："+user.getName());
        System.out.println("年龄："+user.getAge());

        return "redirect:/th/test";
    }

}
