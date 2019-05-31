/** 
  *  myblog 
  *  com.blog.myblog.controller 
  *  MatesController.java 
  *  1.0 
  *  2019年5月28日 下午3:09:13 
  */
package com.blog.myblog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.entity.BlogMeta;
import com.blog.myblog.service.MatesService;
import com.blog.myblog.util.UUIDUtils;
import com.blog.myblog.vo.BlogMetaVO;

/**
 * @description 分类/标签控制器
 * @createTime 2019年5月28日 下午3:09:13
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/metas")
public class MatesController {

	private static Logger logger = LoggerFactory.getLogger(MatesController.class);

	@Autowired
	private MatesService matesService;

	/**
	 * @description 跳转分类管理页，并查询分类/标签信息
	 * @methodName queryMatesList
	 * @param
	 * @returnType String
	 * @throw
	 */
	@RequestMapping("")
	public String queryMatesList(HttpServletRequest request, Model model) {
		List<BlogMeta> categoryList = matesService.queryCategoryListByType("category");
		List<BlogMeta> tagsList = matesService.queryCategoryListByType("tags");
		model.addAttribute("categorys", categoryList);
		model.addAttribute("tags", tagsList);
		return "admin/category/category";
	}

	/**
	 * @description 保存或者更新分类/标签信息
	 * @methodName saveOrUpdateMates
	 * @param
	 * @returnType ProcessResult<?>
	 * @throw
	 */
	@RequestMapping("/saveOrUpdateMates")
	@ResponseBody
	public ProcessResult<?> saveOrUpdateMates(HttpServletRequest request, BlogMetaVO blogMetaVo) {
		String id = blogMetaVo.getCid();
		try {
			if (StringUtils.isEmpty(id)) {
				id = UUIDUtils.nextUUID();
				blogMetaVo.setCid(id);
				matesService.insertSelective(blogMetaVo);
				return ProcessResult.success("save success");
			}
			matesService.updateCategoryById(blogMetaVo);
			return ProcessResult.success("update success");
		} catch (Exception e) {
			logger.error("save metas error:", e);
			return ProcessResult.fail("saveOrUpdate metas error");
		}
	}

	
	/**
	  * @description 根据id 删除分类/标签信息
	  * @methodName deleteMates 
	  * @param 
	  * @returnType ProcessResult<?> 
	  * @throw
	 */
	@RequestMapping("/deleteMetas")
	@ResponseBody
	public ProcessResult<?> deleteMates(@RequestParam("cid") String cid) {
		if (StringUtils.isEmpty(cid)) {
			return ProcessResult.fail("未取到该分类/标签id");
		}
		try {
			matesService.deleteCategoryById(cid);
			return ProcessResult.success("delete success");
		} catch (Exception e) {
			logger.error("delete metas error:", e);
			return ProcessResult.fail("delete metas error");
		}
	}
}
