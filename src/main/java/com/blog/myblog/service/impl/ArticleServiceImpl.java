package com.blog.myblog.service.impl;

import com.blog.myblog.dao.BlogArticleMapper;
import com.blog.myblog.entity.BlogArticle;
import com.blog.myblog.service.ArticleService;
import com.blog.myblog.vo.BlogArticleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dongyang
 * @description TODO
 * @className ArticleServiceImpl
 * @date 2019/5/16
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource(name="blogArticleMapper")
    private BlogArticleMapper blogArticleMapper;

    @Override
    public int insert(BlogArticle record) {
        return 0;
    }

    @Override
    public int insertSelective(BlogArticle record) {
        return 0;
    }

    /**
     * 根据id查询文章
     *
     * @param articleId
     * @return
     */
    @Override
    public List<BlogArticleVO> queryArticleById(String articleId) {
        return null;
    }

    /**
     * 查询文章list
     *
     * @param vo
     * @return
     */
    @Override
    public List<BlogArticleVO> queryArticleList(BlogArticleVO vo) {
        return null;
    }

    /**
     * 根据文章id 更新文章
     *
     * @param vo
     */
    @Override
    public void updateArticleById(BlogArticleVO vo) {

    }

    /**
     * 根据文章id删除文章
     *
     * @param articleId
     */
    @Override
    public void deleteArticleById(String articleId) {

    }
}
