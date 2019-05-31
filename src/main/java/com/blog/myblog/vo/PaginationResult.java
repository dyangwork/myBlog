package com.blog.myblog.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author dongyang
 * @description TODO
 * @className PaginationResult
 * @date 2019/5/15
 **/
public class PaginationResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer total;

    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
