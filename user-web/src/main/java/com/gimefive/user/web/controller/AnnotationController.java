package com.gimefive.user.web.controller;

import com.gimefive.user.web.myannotation.Auth;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试的Controller
 *
 * @author
 * @create 2018-01-16 下午1:46
 **/
@RestController
@RequestMapping(value = "/annotation")
public class AnnotationController {

    @Auth(verifyLogin = true, verifyUrl = true)
    @RequestMapping(value = "/testAnnotation/{value}", method = RequestMethod.GET)
    public void testAnnotation(@PathVariable("value") String value){
        System.out.println("AnnotationTest");
    }
}
