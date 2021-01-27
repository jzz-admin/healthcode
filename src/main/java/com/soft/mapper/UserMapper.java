package com.soft.mapper;

import com.soft.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> selectAllUser();
    int insertUser(User user);
    int updateUser(User user);
    boolean deleteById(int id);
}
