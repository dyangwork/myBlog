package com.blog.myblog.controller;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.entity.BlogArticle;
import com.blog.myblog.entity.BlogUser;
import com.blog.myblog.service.ArticleService;
import com.blog.myblog.util.ConstantUtils;
import com.blog.myblog.util.CookieUtils;
import com.blog.myblog.util.UUIDUtils;
import com.blog.myblog.vo.BlogArticleVO;
import com.blog.myblog.vo.PaginationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author dongyang
 * @description TODO
 * @className ArticleController
 * @date 2019/5/15
 **/
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    public final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;


    @GetMapping("/new")
    public String newArticle(HttpServletRequest request){

        return  "admin/article/article_edit";
    }

    /**
     * 发布或者保存文章
     * @param blogArticle
     * @param request
     * @return
     */
    @PostMapping("/publishOrSaveArticle")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ProcessResult publishOrSaveArticle(BlogArticle blogArticle, HttpServletRequest request){
        logger.debug("request params:"+blogArticle.toString());
        //获取当前登录用户
        BlogUser user = CookieUtils.getLoginUser(request);
        blogArticle.setArticleId(UUIDUtils.nextUUID());
        blogArticle.setCreateTime(new Date());
        if(user!=null){
            blogArticle.setCreateUser(user.getUserUuid());
        }
        try{
            articleService.insertSelective(blogArticle);
        }catch (Exception e){
            logger.error("文章保存失败",e);
        }
        return ProcessResult.success();
    }



    @RequestMapping("/queryArticleList")
    @ResponseBody
    public ProcessResult<?>  queryArticleList(HttpServletRequest request,BlogArticleVO articleVO){
        PaginationResult<BlogArticleVO> paginationResult = null;
        try{
            paginationResult =  articleService.queryArticleList(articleVO);
            return ProcessResult.success("查询成功",paginationResult);
        }catch (Exception e){
            logger.error("query article content error",e);
        }
        return ProcessResult.fail("查询失败");
    }

    @RequestMapping("/manage")
    public String redictToPage(HttpServletRequest request){
        return "admin/article/articleManage";
    }

}
