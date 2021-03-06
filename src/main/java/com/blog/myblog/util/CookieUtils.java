package com.blog.myblog.util;

import com.blog.myblog.entity.BlogUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author dongyang
 * @description session and cookie utils
 */
public class CookieUtils {

    /**
     * 获取session信息
     * @param request
     * @return
     */
    public static BlogUser getLoginUser(HttpServletRequest request){
        HttpSession session =  request.getSession();
        if(session==null){
            return null;
        }
        BlogUser user = (BlogUser)session.getAttribute(ConstantUtils.LOGIN_SESSION);
        return user;
    }

    /**
     * 设置session信息
     * @param request
     * @param user
     */
    public static void setSessionUser(HttpServletRequest request,BlogUser user){
        HttpSession session = request.getSession(ConstantUtils.TRUE);
        session.setAttribute(ConstantUtils.LOGIN_SESSION,user);
    }

    /**
     * 设置登录cookie
     * @param response
     * @param uuid
     */
    public static void setCookie(HttpServletResponse response,String uuid){
        Cookie cookie = new Cookie(ConstantUtils.LOGIN_COOKIE,uuid);
        cookie.setPath("/");
        cookie.setSecure(false);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }

    /**
     * @author dongyang
     * @description 设置自动登录的cookie
     * @date 14:36 2019/5/13
     * @param response, user
     * @return void
     **/
    public static void setAutoCookie(HttpServletResponse response,BlogUser user){

        Cookie cookie = new Cookie(ConstantUtils.AUTO_LOGIN_COOKIE,"");
        cookie.setPath("/");
        cookie.setSecure(false);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }

    /**
     * @description 清除cookie
     * @author dongyang
     * @date 14:36 2019/5/14
     * @param response
     */
    public static void clearCookie(HttpServletResponse response){
        Cookie cookie = new Cookie(ConstantUtils.LOGIN_COOKIE,"");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
