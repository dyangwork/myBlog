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

    /**
     * 当前页
     */
    private Integer start;

    /**
     * 每页数据量
     */
    private Integer length;


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start+1;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
