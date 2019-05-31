/** 
  *  myblog 
  *  com.blog.myblog.controller 
  *  FileController.java 
  *  1.0 
  *  2019年5月31日 上午8:54:09 
  */
package com.blog.myblog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.service.FileService;
import com.blog.myblog.util.UUIDUtils;
import com.blog.myblog.vo.BlogFileVO;
import com.github.pagehelper.PageInfo;

/**
 * @description TODO
 * @createTime 2019年5月31日 上午8:54:09
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/file")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * @description 附件管理查询列表
	 * @methodName fileManage
	 * @param page
	 * @param pageSize
	 * @param request
	 * @returnType String
	 * @throw
	 */
	@RequestMapping("")
	public String fileManage(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", defaultValue = "12") Integer pageSize, HttpServletRequest request) {
		PageInfo<BlogFileVO> pageInfo = fileService.queryFileList(page, pageSize);
		request.setAttribute("attachs", pageInfo);
		return "/admin/file/fileManage";
	}

	/**
	 * @description 批量上传附件
	 * @methodName batchUploadFiles
	 * @param
	 * @returnType ProcessResult<?>
	 * @throw
	 */
	@RequestMapping("/uploadFiles")
	@ResponseBody
	public ProcessResult<?> batchUploadFiles(@RequestParam("file") MultipartFile[] mutiFiles,
			HttpServletRequest request) {
		List<BlogFileVO> blogFileList = new ArrayList<>();
		for (MultipartFile file : mutiFiles) {
			BlogFileVO vo = new BlogFileVO();
			String fileId = UUIDUtils.nextUUID();
			vo.setFileId(fileId);
			vo.setFileName(fileId);
			vo.setOriginName(file.getOriginalFilename());
			vo.setFileSize(String.valueOf(file.getSize()));
			
			
			System.out.println("fileName:" + file.getName());
			System.out.println("originName:" + file.getOriginalFilename());
			System.out.println("size" + file.getSize());
			System.out.println("contentType:" + file.getContentType());
			System.out.println("resource:fileName:" + file.getResource().getFilename());
			System.out.println("description:" + file.getResource().getDescription());
		}

		return ProcessResult.success("上传成功");

	}

}
