package com.blog.myblog.vo;

import java.util.Date;

/**
 * @author dongyang
 * @description TODO
 * @className BlogArticleVO
 * @date 2019/5/15
 **/
public class BlogArticleVO extends Pagination{

    /**
     *文章id
     * */
    private String articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 分类
     */
    private String category;

    /**
     * 标签 逗号分隔
     */
    private String tags;

    /**
     * url 文章
     */
    private String slug;

    /**
     * 文章 状态 （发布，草稿）
     */
    private String status;

    /**
     * 缩略图地址
     */
    private String thumbImg;


    /**
     * 允许评论
     */
    private String allowComments;

    /**
     * 允许图片
     */
    private String allowImgs;

    /**
     * 是否原创或者转载
     */
    private String type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 文章内容
     */
    private String contents;

    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 创建人
     */
    private String createUser;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setThumbImg(String thumbImg) {
        this.thumbImg = thumbImg;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbImg() {
        return thumbImg;
    }

    public void setThumbimg(String thumbImg) {
        this.thumbImg = thumbImg;
    }

    public String getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(String allowComments) {
        this.allowComments = allowComments;
    }

    public String getAllowImgs() {
        return allowImgs;
    }

    public void setAllowImgs(String allowImgs) {
        this.allowImgs = allowImgs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
