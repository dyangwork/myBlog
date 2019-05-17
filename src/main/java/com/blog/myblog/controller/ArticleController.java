package com.blog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author dongyang
 * @description TODO
 * @className ArticleController
 * @date 2019/5/15
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {


    @RequestMapping("/queryArticleList")
    public void  queryArticleList(HttpServletRequest request){
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()){
            String paramName = enumeration.nextElement();
            String[] values = request.getParameterValues(paramName);
            for(int  i=0;i<values.length;i++){
                System.out.println("["+i+"]   "+paramName+"  "+values[i]);
            }
        }
    }

    @RequestMapping("/page")
    public String redictToPage(HttpServletRequest request){
        return "admin/article/articleManage";
    }

}
