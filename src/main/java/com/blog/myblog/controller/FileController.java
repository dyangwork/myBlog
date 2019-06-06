/** 
  *  myblog 
  *  com.blog.myblog.controller 
  *  FileController.java 
  *  1.0 
  *  2019年5月31日 上午8:54:09 
  */
package com.blog.myblog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog.myblog.common.ProcessResult;
import com.blog.myblog.service.FileService;
import com.blog.myblog.util.FileUploadUtils;
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
public class FileController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

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
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public ProcessResult<?> batchUploadFiles(@RequestParam("file") MultipartFile[] mutiFiles,
			HttpServletRequest request) {
		List<BlogFileVO> blogFileList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		for (MultipartFile file : mutiFiles) {
			String type = file.getOriginalFilename().split("\\.")[1];
			String newFileName = UUIDUtils.nextUUID() + "." + type;
			String path = FileUploadUtils.uploadFile(file, newFileName);
			if (StringUtils.isEmpty(newFileName)) {
				list.add(file.getOriginalFilename());
				continue;
			}
			BlogFileVO vo = new BlogFileVO();
			String fileId = UUIDUtils.nextUUID();
			vo.setFileId(fileId);
			vo.setFileName(newFileName);
			vo.setOriginName(file.getOriginalFilename());
			vo.setFileSize(String.valueOf(file.getSize()));
			vo.setFileSuffix(type);
			vo.setFilePath(path);
			vo.setUploadTime(new Date());
			vo.setUploader(getUserId(request));
			blogFileList.add(vo);
		}
		fileService.batchSaveFiles(blogFileList);
		return ProcessResult.success("上传成功", list);
	}

	/**
	 * @description 删除文件
	 * @methodName delFile
	 * @param
	 * @returnType ProcessResult<?>
	 * @throw
	 */
	@RequestMapping("delFile")
	@ResponseBody
	public ProcessResult<?> delFile(@RequestParam("fileId") String fileId) {
		try {
			BlogFileVO blogFileVo = fileService.queryFilebyId(fileId);
			fileService.deleteFileById(fileId);
			FileUploadUtils.deleteFile(blogFileVo.getFilePath());
			return ProcessResult.success("删除成功");
		} catch (Exception e) {
			logger.error("删除失败", e);
		}
		return ProcessResult.fail("删除失败");
	}

}
