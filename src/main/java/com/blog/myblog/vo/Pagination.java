package com.blog.myblog.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author dongyang
 * @description TODO
 * @className Pagination
 * @date 2019/5/15
 **/
public class Pagination implements  Serializable{

    private static final long serialVersionUID = 1L;

    private Integer curPageNo;

    private Integer pageSize;

    public Integer getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(Integer curPageNo) {
        this.curPageNo = curPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
