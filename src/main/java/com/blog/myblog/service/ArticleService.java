package com.blog.myblog.service;

import com.blog.myblog.entity.BlogArticle;
import com.blog.myblog.vo.BlogArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dongyang
 * @description 文章service
 * @interfaceName ArticleService
 * @date 2019/5/16
 **/
public interface ArticleService {

    int insert(BlogArticle record);

    int insertSelective(BlogArticle record);

    /**
     * 根据id查询文章
     * @param articleId
     * @return
     */
    List<BlogArticleVO> queryArticleById(String articleId);

    /**
     * 查询文章list
     * @param vo
     * @return
     */
    List<BlogArticleVO> queryArticleList(BlogArticleVO vo);

    /**
     * 根据文章id 更新文章
     * @param vo
     */
    void updateArticleById(BlogArticleVO vo);

    /**
     * 根据文章id删除文章
     * @param articleId
     */
    void deleteArticleById(String articleId);

}
