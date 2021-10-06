package com.imooc.myo2o.service;

import com.imooc.myo2o.entity.UserLogin;

import java.util.List;

public interface UserService {

    int inserUser(UserLogin userLogin);

    List<UserLogin> querryAll();

    UserLogin queryByName(String name);

}
