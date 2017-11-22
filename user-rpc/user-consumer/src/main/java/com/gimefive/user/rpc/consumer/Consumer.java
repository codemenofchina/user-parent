package com.gimefive.user.rpc.consumer;

import com.gimefive.user.rpc.api.UserInfoApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        System.out.println("consumer start");
        UserInfoApi userInfoService = context.getBean(UserInfoApi.class);
        System.out.println("consumer");
        System.out.println(userInfoService.getUserInfo("bendan xiaobao"));
    }
}
