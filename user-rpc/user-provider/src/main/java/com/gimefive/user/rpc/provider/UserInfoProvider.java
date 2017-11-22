package com.gimefive.user.rpc.provider;

import com.gimefive.user.dao.UserDao;
import com.gimefive.user.rpc.api.UserInfoApi;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoProvider implements UserInfoApi {
    @Autowired
    UserDao userDao;
    @Override
    public String getUserInfo(String name) {
        return "dubbo " + userDao.getUserInfo(name);
    }
}
