/** 
  *  myblog 
  *  com.blog.myblog.service.impl 
  *  FileServiceImpl.java 
  *  1.0 
  *  2019年5月30日 下午3:56:48 
  */ 
package com.blog.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.myblog.dao.BlogFileMapper;
import com.blog.myblog.entity.BlogFile;
import com.blog.myblog.service.FileService;
import com.blog.myblog.vo.BlogFileVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
  * @description 附件service
  * @createTime 2019年5月30日 下午3:56:48 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0 
  */
@Service("fileService")
public class FileServiceImpl implements FileService{
	
	@Autowired
	private BlogFileMapper blogFileMapper;

	/**
	  * @description 单条附件数据全插入
	  * @methodName insert 
	  * @param record
	  * @returnType int 
	  * @throw
	 */
	@Override
	public void insert(BlogFile record) throws Exception{
		blogFileMapper.insert(record);
	}

	/**
	  * @description 附件数据非null值插入 
	  * @methodName insertSelective 
	  * @param record
	  * @returnType int 
	  * @throw
	 */
	@Override
	public void insertSelective(BlogFile record)  throws Exception{
		blogFileMapper.insertSelective(record);
	}

	/**
	  * @description 根据fileId查询附件 
	  * @methodName queryFilebyId 
	  * @param id
	  * @returnType BlogFileVO 
	  * @throw
	 */
	@Override
	public BlogFileVO queryFilebyId(String fileId) {
		List<BlogFileVO> blogFileList = blogFileMapper.queryFilebyId(fileId);
		if(blogFileList.size()>0){
			return blogFileList.get(0);
		}
		return null;
	}

	/**
	  * @description 分页查询附件 
	  * @methodName queryFileList 
	  * @param 
	  * @returnType List<BlogFileVO> 
	  * @throw
	 */
	@Override
	public PageInfo<BlogFileVO> queryFileList(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BlogFileVO> blogFileList = blogFileMapper.queryFileList();
		return new PageInfo<>(blogFileList);
	}
	
	/**
	  * @description  是否存在相同附件
	  * @methodName countFileByMd5 
	  * @param BlogFileVO
	  * @returnType BlogFileVO 
	  * @throw
	 */
	@Override
	public BlogFileVO countFileByMd5(BlogFileVO blogFileVo) {
		List<BlogFileVO> blogFileList = blogFileMapper.countFileByMd5(blogFileVo);
		 if(blogFileList !=null && blogFileList.size()>0){
			 return blogFileList.get(0);
		 }
		 return null;
	}

	/**
	  * @description  根据fileId 删除附件
	  * @methodName deleteFileById 
	  * @param fileId
	  * @returnType int 
	  * @throw
	 */
	@Override
	public void deleteFileById(String fileId)  throws Exception{
		blogFileMapper.deleteFileById(fileId);
	}
	
	/**
	  * @description 批量保存附件 
	  * @methodName batchSaveFiles 
	  * @param 
	  * @returnType void 
	  * @throw
	 */
	@Override
	public void batchSaveFiles(List<BlogFileVO> blogFileList) {
		blogFileMapper.batchAddFile(blogFileList);
	}

}

	