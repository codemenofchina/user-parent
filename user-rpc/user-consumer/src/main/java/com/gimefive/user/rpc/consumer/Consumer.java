package com.gimefive.user.rpc.consumer;

import com.gimefive.user.rpc.api.MathApi;
import com.gimefive.user.rpc.api.UserInfoApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        //测试常规服务
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        System.out.println("consumer start");
        UserInfoApi userService = context.getBean(UserInfoApi.class);
        MathApi mathService = context.getBean(MathApi.class);
        System.out.println("consumer");
        System.out.println(userService.getUserInfo("xiaoqiang"));
        System.out.println(mathService.square(22));
        System.in.read();
    }
}
