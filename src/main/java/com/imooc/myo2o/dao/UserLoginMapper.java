package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    //查询
//    @Select("select * from userLogin")
    List<UserLogin> queryAll();
    //添加数据
    int add(UserLogin userLogin);
    //根据用户名查询数据
    UserLogin queryByName(String username);
}
