package com.blog.myblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.blog.myblog.entity.BlogMeta;

/**
  * @description 分类/标签数据库持久层
  * @createTime 2019年5月30日 上午9:28:47 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0
 */
@Component("blogMetaMapper")
public interface BlogMetaMapper {
	
	/**
	  * @description mates单条全数据插入
	  * @methodName insert 
	  * @param 
	  * @returnType int 
	  * @throw
	 */
	int insert(BlogMeta record);

	/**
	  * @description metas单条数据选择性插入
	  * @methodName insertSelective 
	  * @param 
	  * @returnType int 
	  * @throw
	 */
	int insertSelective(BlogMeta record);

	/**
	  * @description metas分页查询 根据分类/标签类型
	  * @methodName queryCategoryListByType 
	  * @param 
	  * @returnType List<BlogMeta> 
	  * @throw
	 */
	List<BlogMeta> queryCategoryListByType(@Param("type") String type);

	/**
	  * @description 根据id 删除metas 
	  * @methodName deleteCategoryById 
	  * @param 
	  * @returnType int 
	  * @throw
	 */
	int deleteCategoryById(@Param("cid") String id);

	/**
	  * @description 根据id 更新metas 
	  * @methodName updateCategoryById 
	  * @param 
	  * @returnType int 
	  * @throw
	 */
	int updateCategoryById(BlogMeta meta);

	/**
	  * @description 批量添加metas 
	  * @methodName bacthAddMates 
	  * @returnType int 
	  * @throw
	 */
	int bacthAddMates(List<BlogMeta> list);
}