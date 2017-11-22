package com.gimefive.user.web;

import com.gimefive.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/getUserInfo/{name}")
    public String getUserInfo(@PathVariable(value = "name") String name){
        return userService.getUserInfo(name);
    }

}