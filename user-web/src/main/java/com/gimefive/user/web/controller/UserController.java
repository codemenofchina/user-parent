package com.gimefive.user.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.gimefive.user.common.PropertiesCopyUtil;
import com.gimefive.user.entity.User;
import com.gimefive.user.service.UserService;
import com.gimefive.user.web.dto.BaseResult;
import com.gimefive.user.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserVO userVO){
        User user = new User();
        PropertiesCopyUtil.copyProperties(user, userVO);
        int result = userService.addUser(user);
        BaseResult<Object> baseResult;
        if(result == 1) {
            baseResult = new BaseResult<Object>(true, "注册成功");
        } else {
            baseResult = new BaseResult<Object>(false, "注册失败");
        }
        return JSONArray.toJSONString(baseResult);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserVO userVO){
        User user = new User();
        PropertiesCopyUtil.copyProperties(user, userVO);
        boolean result = userService.login(user);
        BaseResult<Object> baseResult;
        if(result){
            baseResult = new BaseResult<Object>(true, "登录成功");
        } else {
            baseResult = new BaseResult<Object>(false, "用户名或者密码错误");
        }
        return JSONArray.toJSONString(baseResult);
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public String getUserByUserName(@PathVariable("userName") String userName){
        User user = userService.queryUserByUserName(userName);
//        User user = new User();
//        PropertiesCopyUtil.copyProperties(user, userVO);
//        boolean result = userService.login(user);
//        BaseResult<Object> baseResult;
//        if(result){
//            baseResult = new BaseResult<Object>(true, "登录成功");
//        } else {
//            baseResult = new BaseResult<Object>(false, "用户名或者密码错误");
//        }
        return JSONArray.toJSONString(user);
    }

    @RequestMapping(value = "/users/{offset}/{limit}", method = RequestMethod.GET)
    public String users(@PathVariable("offset") int offset, @PathVariable("limit") int limit){
        List<User> users = userService.queryAll(offset, limit);
        System.out.println(users.size());
//        User user = new User();
//        PropertiesCopyUtil.copyProperties(user, userVO);
//        boolean result = userService.login(user);
//        BaseResult<Object> baseResult;
//        if(result){
//            baseResult = new BaseResult<Object>(true, "登录成功");
//        } else {
//            baseResult = new BaseResult<Object>(false, "用户名或者密码错误");
//        }
        return "" + users.size();
    }

    @RequestMapping(value = "/login/{userName}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable("userName") String userName, @PathVariable("password") String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (userService.login(user)) {
            return "ok";
        } else {
            return "false";
        }
    }
}
