package com.blog.myblog.entity;

import java.util.Date;

/**
 * @description 文章表
 * @author dongyang
 * @date 2019/5/15
 */
public class BlogArticle {
    /**
     *文章id
     * */
    private String articleId;

    /**
     * 文章标题
     */
    private String articleTile;

    /**
     * 分类
     */
    private String category;

    /**
     * 标签 逗号分隔
     */
    private String tags;

    private Integer slug;

    private String status;

    private String thumbimg;

    private String allowComments;

    private String allowImgs;

    private String type;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private String contents;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTile() {
        return articleTile;
    }

    public void setArticleTile(String articleTile) {
        this.articleTile = articleTile == null ? null : articleTile.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getSlug() {
        return slug;
    }

    public void setSlug(Integer slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getThumbimg() {
        return thumbimg;
    }

    public void setThumbimg(String thumbimg) {
        this.thumbimg = thumbimg == null ? null : thumbimg.trim();
    }

    public String getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(String allowComments) {
        this.allowComments = allowComments == null ? null : allowComments.trim();
    }

    public String getAllowImgs() {
        return allowImgs;
    }

    public void setAllowImgs(String allowImgs) {
        this.allowImgs = allowImgs == null ? null : allowImgs.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}