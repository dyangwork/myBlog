/** 
  *  myblog 
  *  com.blog.myblog.service 
  *  FileService.java 
  *  1.0 
  *  2019年5月30日 下午3:49:04 
  */
package com.blog.myblog.service;

import java.util.List;

import com.blog.myblog.entity.BlogFile;
import com.blog.myblog.vo.BlogFileVO;
import com.github.pagehelper.PageInfo;

/**
 * @description 附件service
 * @createTime 2019年5月30日 下午3:49:04
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
public interface FileService {

	void insert(BlogFile record) throws Exception;

	void insertSelective(BlogFile record) throws Exception;

	BlogFileVO queryFilebyId(String fileId);

	PageInfo<BlogFileVO> queryFileList(Integer pageNum, Integer pageSize);

	BlogFileVO countFileByMd5(BlogFileVO blogFileVo);

	void deleteFileById(String fileId) throws Exception;

	void batchSaveFiles(List<BlogFileVO> blogFileList);
}
