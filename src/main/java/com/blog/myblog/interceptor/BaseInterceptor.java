package com.blog.myblog.interceptor;

import com.blog.myblog.entity.BlogUser;
import com.blog.myblog.util.CookieUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dongyang
 * @description 配置拦截器
 * @date 11:19 2019/5/13
 **/
@Component
public class BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        BlogUser user = CookieUtils.getLoginUser(request);
        if(user ==null && !"/admin/login".equals(path)){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
