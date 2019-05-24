package com.blog.myblog.util;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

/**
 * @author dongyang
 * @description TODO
 * @className UUIDUtils
 * @date 2019/5/20
 **/
public class UUIDUtils {

    /**
     * 获取uuid
     * @return
     */
    public static String nextUUID(){
       String uuid =  UUID.randomUUID().toString();
       return uuid.replaceAll("-","");
    }

}
