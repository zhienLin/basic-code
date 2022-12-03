package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @author zzy
 * @date 2022-11-09 15:30
 */
public interface userMapper {
 List<User> selectAll();
 User selectById(int id);

}
