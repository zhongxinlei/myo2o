package com.imooc.myo2o.service;

import com.imooc.myo2o.entity.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        UserLogin user = new UserLogin();
        user.setUsername("Cat");
        user.setPassword("1234567");
        userService.inserUser(user);
    }


    @Test
    public void querryAllUser(){
        userService.querryAll();
    }

    public void querryByName(){
        userService.queryByName("Lane");
    }
}
