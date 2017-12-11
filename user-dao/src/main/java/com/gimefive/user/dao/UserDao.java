package com.gimefive.user.dao;

import com.gimefive.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);


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
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return
     */
    User queryUserByUserName(@Param("userName") String userName);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);
}
