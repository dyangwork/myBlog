/** 
  *  myblog 
  *  com.blog.myblog.util 
  *  DateUtils.java 
  *  1.0 
  *  2019年5月31日 下午4:11:37 
  */ 
package com.blog.myblog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
  * @description TODO 
  * @createTime 2019年5月31日 下午4:11:37 
  * @modifyTime 
  * @author dyangwork@126.com 
  * @version 1.0 
  */
public class DateUtils {

	public static final SimpleDateFormat sdf = new SimpleDateFormat();
	
	
	/**
	  * @description  时间转换成
	  * @methodName dateToString 
	  * @param date
	  * @param pattern
	  * @returnType String 
	  * @throw
	 */
	public static String dateToString(Date date,String pattern){
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	
}

	