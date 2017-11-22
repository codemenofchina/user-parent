package com.gimefive.user.service.impl;

import com.gimefive.user.dao.UserDao;
import com.gimefive.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public String getUserInfo(String name) {
        return userDao.getUserInfo(name);
    }
}
