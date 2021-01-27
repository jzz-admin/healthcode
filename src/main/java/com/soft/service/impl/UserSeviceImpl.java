package com.soft.service.impl;


import com.soft.entity.User;
import com.soft.mapper.UserMapper;
import com.soft.service.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserSeviceImpl implements UserSevices{

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);


    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userMapper.deleteById(id);
    }
}
