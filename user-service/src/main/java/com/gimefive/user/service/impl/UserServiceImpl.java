package com.gimefive.user.service.impl;

import com.gimefive.user.common.MD5Util;
import com.gimefive.user.dao.UserDao;
import com.gimefive.user.entity.User;
import com.gimefive.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    public List<User> queryAll(int offset, int limit) {
        return userDao.queryAll(offset,limit);
    }

    public int addUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        String password = user.getPassword();
        password = MD5Util.generate(password);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    public int updateUser(User user) {
        String password = user.getPassword();
        password = MD5Util.generate(password);
        user.setPassword(password);
        return userDao.updateUser(user);
    }

    public boolean login(User user) {
        User userPO = userDao.queryUserByUserName(user.getUserName());
        if(userPO != null){
            if(MD5Util.verify(user.getPassword(), userPO.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public User queryUserByUserName(String userName) {
        User user = userDao.queryUserByUserName(userName);
        System.out.println(user.toString());
        return user;
    }
}
