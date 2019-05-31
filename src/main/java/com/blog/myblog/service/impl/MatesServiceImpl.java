/** 
  *  myblog 
  *  com.blog.myblog.service.impl 
  *  MatesServiceImpl.java 
  *  1.0 
  *  2019年5月28日 下午2:54:42 
  */ 
package com.blog.myblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.myblog.dao.BlogMetaMapper;
import com.blog.myblog.entity.BlogMeta;
import com.blog.myblog.service.MatesService;
import com.blog.myblog.vo.BlogMetaVO;

/** 
  * @description TODO 
  * @createTime 2019年5月28日 下午2:54:42 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0 
  */
@Service("matesService")
public class MatesServiceImpl implements MatesService {

	
	@Autowired
	private BlogMetaMapper blogMetaMapper;
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int insert(BlogMetaVO blogMetaVo) throws Exception{
		BlogMeta blogMeta = voToEntity(blogMetaVo);
		return blogMetaMapper.insert(blogMeta);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int insertSelective(BlogMetaVO blogMetaVo) throws Exception {
		BlogMeta blogMeta = voToEntity(blogMetaVo);
		return blogMetaMapper.insertSelective(blogMeta);
	}

	@Override
	public List<BlogMeta> queryCategoryListByType(String type) {
		return blogMetaMapper.queryCategoryListByType(type);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int deleteCategoryById(String id) throws Exception{
		return blogMetaMapper.deleteCategoryById(id);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int updateCategoryById(BlogMetaVO blogMetaVo) throws Exception{
		BlogMeta blogMeta = voToEntity(blogMetaVo);
		return blogMetaMapper.updateCategoryById(blogMeta);
	}

	/**
	  * @description 转换vo to entity
	  * @methodName voToEntity 
	  * @param 
	  * @returnType BlogMeta 
	  * @throw
	 */
	public static BlogMeta voToEntity(BlogMetaVO blogMetaVo){
		BlogMeta blogMeta = new BlogMeta();
		blogMeta.setCid(blogMetaVo.getCid());
		blogMeta.setName(blogMetaVo.getName());
		blogMeta.setDescription(blogMetaVo.getDescription());
		blogMeta.setType(blogMetaVo.getType());
		blogMeta.setSort(0);
		return blogMeta;
	}
	
	/**
     * @description 批量添加metas
     * @methodName bathAddMetas 
     * @param 
     * @returnType int 
     * @throw
    */
	@Override
	public int bathAddMetas(List<BlogMeta> list) throws Exception {
			return blogMetaMapper.bacthAddMates(list);
	}
	
}

	