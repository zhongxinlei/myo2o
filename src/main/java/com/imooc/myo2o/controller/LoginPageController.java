package com.imooc.myo2o.controller;


import com.imooc.myo2o.entity.UserLogin;
import com.imooc.myo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    private static final Logger logger = LogManager.getLogger(LoginPageController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/LoginSuccess", method = RequestMethod.GET)
    public String LoginSuccess(Model model, UserLogin userLogin){
        //先查询看该用户名是否存在
        UserLogin userLogin1 = userService.queryByName(userLogin.getUsername());
        if(userLogin1 != null){ //  如果查询的用户不为空
            System.out.println(userLogin1.toString());
            return "success";
        }
        else{
            //返回到登录页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "login";
        }
    }
    //登录界面
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }
    @RequestMapping(value = "/RegisterSuccess", method = RequestMethod.GET)
    public String toRegisterSuccess(Model model,UserLogin userLogin){
        //将账号密码加入到数据库中
        int add = userService.inserUser(userLogin);
        logger.info("数据插入成功！");
        model.addAttribute("data","注册成功，请登录！");
        return "login";
    }

}

