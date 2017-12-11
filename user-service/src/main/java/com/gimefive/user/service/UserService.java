package com.gimefive.user.service;

import com.gimefive.user.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(int offset, int limit);


    /**
     * 添加用户
     * @param user
     */
    int addUser(User user);


    /**
     * 修改用户
     * @param user
     */
    int updateUser(User user);

    /**
     * 用户登录验证
     * @param user
     */
    boolean login(User user);

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User queryUserByUserName(String userName);
}
