package com.gimefive.user.common;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chenqiang on 2017/9/12.
 */
public class PropertiesCopyUtil {

    /**
     *
     * @param dest  无属性对象
     * @param orig  有属性对象
     */
    public static void copyProperties(Object dest, Object orig){
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
