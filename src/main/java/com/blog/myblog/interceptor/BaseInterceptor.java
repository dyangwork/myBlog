package com.blog.myblog.interceptor;

import com.blog.myblog.common.AdminCommons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @description 拦截器配置
  * @createTime 2019年5月29日 下午3:04:15 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

	/**
	 * 登录页面url
	 */
	private static String LOGIN_URL = "/admin/login";
	
	/**
	 * 分类公共类
	 */
	@Autowired
	private AdminCommons adminCommons;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * String path = request.getRequestURI(); BlogUser user =
		 * CookieUtils.getLoginUser(request); if(user ==null &&
		 * !LOGIN_URL.equals(path)){ response.sendRedirect(LOGIN_URL); return
		 * false; }
		 */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("adminCommons", adminCommons);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}