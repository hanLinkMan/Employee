package com.atguigu.springboot04restfulweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author hlq
 * @create 2020-07-02 20:27
 */
@Controller
public class LoginController {
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        HttpSession session,
                        Map<String,Object> map){
        if(!StringUtils.isEmpty(userName) && "000000".equals(passWord)){
            //登录成功
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
