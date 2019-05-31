package com.blog.myblog.dao;

import com.blog.myblog.entity.BlogArticle;
import com.blog.myblog.vo.BlogArticleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("blogArticleMapper")
public interface BlogArticleMapper {

    /**
     * 添加文章
     * @param record
     * @return
     */
    int insert(BlogArticle record);

    /**
     * 动态添加文章
     * @param record
     * @return
     */
    int insertSelective(BlogArticle record);

    /**
     * 根据id查询文章
     * @param articleId
     * @return
     */
    List<BlogArticleVO> queryArticleById(@Param("articleId") String articleId);

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
    void deleteArticleById(@Param("articleId") String articleId);

    /**
     * 查询数据总条数
     * @param vo
     * @return
     */
    Integer queryCount(BlogArticleVO vo);
}