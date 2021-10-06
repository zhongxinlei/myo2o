package com.imooc.myo2o.service.impl;

import com.imooc.myo2o.dao.UserLoginMapper;
import com.imooc.myo2o.entity.UserLogin;
import com.imooc.myo2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public int inserUser(UserLogin user) {
        logger.info("the newly added user is: {}", user.getUsername());
        userLoginMapper.add(user);
        if (user.getPassword().equals("123456")){
            throw new IllegalArgumentException("password is too easy!");
        }else{
            return 1;
        }
    }

    @Override
    public List<UserLogin> querryAll() {
        List<UserLogin> userList = userLoginMapper.queryAll();
        for (UserLogin user: userList) {
            logger.info("{} ------------------> {}", user.getUsername(), user.getPassword());
        }
        return userList;
    }

    @Override
    public UserLogin queryByName(String name) {
        UserLogin user = userLoginMapper.queryByName(name);
        logger.info("{} ========================> {}", user.getUsername(), user.getPassword());
        return user;
    }
}
