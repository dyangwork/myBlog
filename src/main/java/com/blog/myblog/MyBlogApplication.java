package com.blog.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.pagehelper.PageHelper;

/**
 * @author dongyang
 * @description 启动类
 * @date 14:02 2019/5/13
 **/
@SpringBootApplication
@MapperScan("com.blog.myblog.dao")
public class MyBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

}
