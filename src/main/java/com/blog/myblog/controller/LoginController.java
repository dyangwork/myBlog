package com.blog.myblog.controller;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.entity.BlogUser;
import com.blog.myblog.service.UserService;
import com.blog.myblog.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@Transactional
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	public UserService userService;

	@GetMapping("/login")
	public String redictToLoginHtml(Map<String,Object> map){
		return "admin/login/login";
	}

	/**
	 * 用户登录
	 *
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public ProcessResult<BlogUser> login(HttpServletRequest request, HttpServletResponse response){

		//获取用户名密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String auto = request.getParameter("auto");
		BlogUser user =  userService.getUserByUserNameAndPassword(userName,password);

		HttpSession session  = request.getSession(true);

		// 设置session的值
		session.setAttribute(ConstantUtils.LOGIN_SESSION,user);

		//创建cookie
		Cookie cookie = new Cookie(ConstantUtils.LOGIN_COOKIE,user.getUserUuid());
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return ProcessResult.success("校验成功");
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request){
		HttpSession session = request.getSession();
		BlogUser user = (BlogUser) session.getAttribute("user");
		return "admin/home";
	}
}
