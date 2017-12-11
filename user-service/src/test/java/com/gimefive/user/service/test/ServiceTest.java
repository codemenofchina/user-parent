package com.gimefive.user.service.test;

import com.gimefive.user.entity.User;
import com.gimefive.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath*:spring-service.xml", "classpath*:spring-dao.xml"})
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testAspect(){
        List<User> list = userService.queryAll(0, 10);
        System.out.println(list==null);
    }
}
