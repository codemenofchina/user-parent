package com.gimefive.user.web.myannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface Auth {

    public boolean verifyLogin() default true;

    public boolean verifyUrl() default true;
}
