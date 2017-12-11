package com.gimefive.user.test.dao;


import com.gimefive.user.common.MD5Util;
import com.gimefive.user.dao.UserDao;
import com.gimefive.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
({"classpath:spring-dao.xml"}) //加载配置文件
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@Transactional
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//------------
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void queryAll() {
        List<User> users = userDao.queryAll(0, 5);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName("xiaobao");
        user.setRealName("小宝");
        user.setPassword(MD5Util.generate("123456"));
        System.out.println(userDao.addUser(user));
    }

    @Test
    public void login() {
        User user = userDao.queryUserByUserName("xiaobao");
        System.out.println(MD5Util.verify("123456", user.getPassword()));
    }
}
