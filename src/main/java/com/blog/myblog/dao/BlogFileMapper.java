package com.blog.myblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.blog.myblog.entity.BlogFile;
import com.blog.myblog.vo.BlogFileVO;

@Component("blogFileMapper")
public interface BlogFileMapper {
	int insert(BlogFile record);

	int insertSelective(BlogFile record);

	List<BlogFileVO> queryFilebyId(@Param("id") String id);

	List<BlogFileVO> queryFileList();

	List<BlogFileVO> countFileByMd5(BlogFileVO blogFileVo);

	int deleteFileById(@Param("id") String id);
	
	int batchAddFile(List<BlogFileVO> list);
}