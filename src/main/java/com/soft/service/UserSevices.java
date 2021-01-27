package com.soft.service;

import com.soft.entity.User;

import java.util.List;

public interface UserSevices {
    List<User> selectAllUser();
    int insertUser(User user);
    int updateUser(User user);
    boolean deleteById(int id);
}
