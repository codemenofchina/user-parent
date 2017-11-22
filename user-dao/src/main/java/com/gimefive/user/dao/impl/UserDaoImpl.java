package com.gimefive.user.dao.impl;

import com.gimefive.user.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public String getUserInfo(String name) {
        return "用户信息是: " + name;
    }
}
