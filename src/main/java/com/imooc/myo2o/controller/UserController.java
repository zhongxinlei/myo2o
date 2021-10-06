package com.imooc.myo2o.controller;

import com.imooc.myo2o.entity.UserLogin;
import com.imooc.myo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public List<UserLogin> getUsers(){
        List<UserLogin> userLoginList = userService.querryAll();
        return userLoginList;
    }
}
