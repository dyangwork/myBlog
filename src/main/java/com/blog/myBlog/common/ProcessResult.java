package com.blog.myBlog.common;

import com.blog.myBlog.util.ConstantUtils;

/**
 * 返回结果集
 */
public class ProcessResult<T> {


    //返回数据
    private T data;

    //返回信息
    private String msg;

    //状态码
    private String code;

    //响应时间
    private long timestamp;


    public ProcessResult(){
        this.timestamp = System.currentTimeMillis()/1000;
    }

    public ProcessResult(String code){
        this.timestamp = System.currentTimeMillis()/1000;
        this.code = code;
    }

    public ProcessResult(String code,T data){
        this.timestamp = System.currentTimeMillis()/1000;
        this.code = code;
        this.data = data;
    }

    public ProcessResult(String code,String msg,T data){
        this.timestamp = System.currentTimeMillis()/1000;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }



    public static <T> ProcessResult fail(){
        return new ProcessResult(ConstantUtils.FAIL);
    }

    public static <T> ProcessResult fail(String msg){
        return new ProcessResult(ConstantUtils.FAIL, msg,null);
    }

    public static <T> ProcessResult fail(T data,String msg){
        return new ProcessResult(ConstantUtils.FAIL,msg,data);
    }

    public static <T> ProcessResult success(){
        return new ProcessResult(ConstantUtils.SUCCESS);
    }

    public static <T> ProcessResult success(String msg){
        return new ProcessResult(ConstantUtils.SUCCESS,msg,null);
    }

    public static <T> ProcessResult success(String msg,T data){
        return new ProcessResult(ConstantUtils.SUCCESS,msg,data);
    }

}
