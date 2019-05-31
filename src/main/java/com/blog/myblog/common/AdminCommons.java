/** 
  *  myblog 
  *  com.blog.myblog.common 
  *  AdminCommons.java 
  *  1.0 
  *  2019年5月29日 下午2:40:19 
  */ 
package com.blog.myblog.common;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.blog.myblog.entity.BlogMeta;
import com.github.pagehelper.PageInfo;

/** 
  * @description 分类/标签操作类 
  * @createTime 2019年5月29日 下午2:40:19 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0 
  */
@Component
public class AdminCommons {

	/**
	 * 颜色列表
	 */
	private static final String[] COLORS={"jantent", "primary", "success", "info", "warning", "danger", "inverse", "purple", "pink"};
	
	/**
	 * 随机数
	 */
	private static final Random rand = new Random();
	
	/**
	  * @description 获取随机颜色
	  * @methodName nextColor 
	  * @param 
	  * @returnType String 
	  * @throw
	 */
	public static String nextColor(){
		int index = rand.nextInt(COLORS.length-1);
		return COLORS[index];
	}
	
	/**
	  * @description 判断category中是否包含blogMeta分类 
	  * @methodName existCategory 
	  * @param 
	  * @returnType boolean 
	  * @throw
	 */
	public static boolean existCategory(BlogMeta blogMeta,String categorys){
		if(StringUtils.isEmpty(categorys)){
			return false;
		}
		String[] categoryArray = categorys.split(",");
		for(String category:categoryArray){
			if(category.equals(blogMeta.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	  * @description html 用于判断pageInfo是否包含数据 
	  * @methodName isNotEmpty 
	  * @param pageInfo
	  * @returnType boolean 
	  * @throw
	 */
	public static <T> boolean isNotEmpty(PageInfo<T> pageInfo){
		if(pageInfo ==null || CollectionUtils.isEmpty(pageInfo.getList())){
			return false;
		}
		return true;
	}
	
		
}

	