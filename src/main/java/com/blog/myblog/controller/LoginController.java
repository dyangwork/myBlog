package com.blog.myblog.controller;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.entity.BlogUser;
import com.blog.myblog.service.UserService;
import com.blog.myblog.util.ConstantUtils;
import com.blog.myblog.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @author dongyang
 * @description 登录操作类
 * @date 14:43 2019/5/13
 **/
@Controller
@Transactional(rollbackFor = Exception.class)
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	public UserService userService;

	@GetMapping("/login")
	public String redictToLoginHtml(Map<String,Object> map){
		return "admin/login/login";
	}

	/**
	 * @author dongyang
	 * @description  登陆
	 * @date 14:13 2019/5/13
	 * @param request
	 * @param  response
	 * @return com.blog.myblog.common.ProcessResult<com.blog.myblog.entity.BlogUser>
	 **/
	@PostMapping("/login")
	@ResponseBody
	public ProcessResult<?> login(HttpServletRequest request, HttpServletResponse response){

		//获取用户名密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String auto = request.getParameter("auto");
		BlogUser user =  userService.getUserByUserNameAndPassword(userName,password);
		if(user==null){
			return ProcessResult.fail("用户名或密码不对");
		}
		//创建session
		CookieUtils.setSessionUser(request,user);
		//创建cookie
		CookieUtils.setCookie(response,user.getUserUuid());
		if("on".equals(auto)){

		}
		return ProcessResult.success("校验成功");
	}

	/**
	 * @author dongyang
	 * @description 登出操作
	 * @date 16:10 2019/5/14
	 * @param request
	 * @param response
	 * @return string
	 **/
	@RequestMapping("/logout")
	public String loginOut(HttpServletRequest request, HttpServletResponse response){
		//移除session
		request.getSession().removeAttribute(ConstantUtils.LOGIN_SESSION);
		//移除cookie
		CookieUtils.clearCookie(response);
		return "admin/login/login";

	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model){
		BlogUser user = CookieUtils.getLoginUser(request);
		model.addAttribute("user",user);
		return "admin/home";
	}
}
