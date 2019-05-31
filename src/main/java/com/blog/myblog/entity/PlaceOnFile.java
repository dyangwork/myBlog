package com.blog.myblog.entity;

/**
 * @description 归类表
 * @author dongyang
 * @date 2019/5/15
 */
public class PlaceOnFile {
    private String fid;

    private String name;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}