/** 
  *  myblog 
  *  com.blog.myblog.service 
  *  MatesService.java 
  *  1.0 
  *  2019年5月28日 下午2:45:24 
  */ 
package com.blog.myblog.service;


import java.util.List;

import com.blog.myblog.entity.BlogMeta;
import com.blog.myblog.vo.BlogMetaVO;

/** 
  * @description 分类/标签service 
  * @createTime 2019年5月28日 下午2:45:24 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0 
  */
public interface MatesService {

	/**
	  * @description 插入操作 
	  * @methodName insert 
	  * @param BlogMeta
	  * @returnType int 
	  * @throw
	 */
	int insert(BlogMetaVO record) throws Exception;

	/**
	  * @description 选择性插入分类 or 标签 
	  * @methodName insertSelective 
	  * @param 
	  * @returnType int 
	  * @throw
	 */
    int insertSelective(BlogMetaVO record) throws Exception;
    
    /**
      * @description 根据类型查询分类 or 标签 
      * @methodName queryCategoryListByType 
      * @param 
      * @returnType BlogMeta 
      * @throw
     */
    List<BlogMeta> queryCategoryListByType(String type);
    
    /**
      * @description 根据id删除分类/标签 
      * @methodName deleteCategoryById 
      * @param id
      * @returnType int 
      * @throw
     */
    int deleteCategoryById(String id) throws Exception;
    
    /**
      * @description 根据id 更新分类/标签 
      * @methodName updateCategoryById 
      * @param id
      * @returnType int 
      * @throw
     */
    int updateCategoryById(BlogMetaVO blogMeta) throws Exception;
    
    /**
      * @description 批量添加metas
      * @methodName bathAddMetas 
      * @param 
      * @returnType int 
      * @throw
     */
    int bathAddMetas(List<BlogMeta> list) throws Exception;
}

	