/** 
  *  myblog 
  *  com.blog.myblog.controller 
  *  BaseController.java 
  *  1.0 
  *  2019年6月5日 下午4:12:03 
  */
package com.blog.myblog.controller;

import javax.servlet.http.HttpServletRequest;

import com.blog.myblog.entity.BlogUser;
import com.blog.myblog.util.CookieUtils;

/**
 * @description TODO
 * @createTime 2019年6月5日 下午4:12:03
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
public abstract class BaseController {

	/**
	  * @description 获取当前登录用户信息 
	  * @methodName getUser 
	  * @param 
	  * @returnType BlogUser 
	  * @throw
	 */
	public static BlogUser getUser(HttpServletRequest request) {
		return CookieUtils.getLoginUser(request);
	}
	
	/**
	  * @description 获取当前登录用户的iD 
	  * @methodName getUserId 
	  * @param 
	  * @returnType String 
	  * @throw
	 */
	public static String getUserId(HttpServletRequest request) {
		BlogUser user =  CookieUtils.getLoginUser(request);
		if (user == null) {
			return null;
		}
		return user.getUserUuid();
	}

}
