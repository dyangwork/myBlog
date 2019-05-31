/** 
  *  myblog 
  *  com.blog.myblog.vo 
  *  BlogFileVO.java 
  *  1.0 
  *  2019年5月30日 上午10:18:35 
  */
package com.blog.myblog.vo;

import java.util.Date;

/**
 * @description 文件vo
 * @createTime 2019年5月30日 上午10:18:35
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
public class BlogFileVO {

	/**
	 * 文件id
	 */
	private String fileId;

	/**
	 * 服务器存储的文件名
	 */
	private String fileName;

	/**
	 * 源文件名
	 */
	private String originName;

	/**
	 * 文件存储路径
	 */
	private String filePath;

	/**
	 * 文件类型，拓展名
	 */
	private String fileSuffix;

	/**
	 * 文件大小
	 */
	private String fileSize;

	/**
	 * 文件加密md5
	 */
	private String fileMd5;

	/**
	 * 上传者
	 */
	private String uploader;

	/**
	 * 上传时间
	 */
	private Date uploadTime;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileMd5() {
		return fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	

}
