/** 
  *  myblog 
  *  com.blog.myblog.util 
  *  FileUploadUtils.java 
  *  1.0 
  *  2019年5月31日 下午3:57:15 
  */
package com.blog.myblog.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description TODO
 * @createTime 2019年5月31日 下午3:57:15
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
public class FileUploadUtils {

	public static Logger logger = LoggerFactory.getLogger("FileUploadUtils");

	private static final String PATH = "D:\\www";

	/**
	 * @description 文件上传
	 * @methodName uploadFile
	 * @param
	 * @returnType String
	 * @throw
	 */
	public static String uploadFile(MultipartFile mutiFile, String newFileName) {

		String dir = DateUtils.dateToString(new Date(), "yyyy-MM-dd");
		String commonPath = "\\upload\\" + dir;
		String path = commonPath + "\\" + newFileName;

		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = mutiFile.getInputStream();
			File file = new File(PATH + commonPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(PATH + path);
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			int byteReader = -1;
			byte[] buffer = new byte[4096];
			while ((byteReader = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteReader);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			logger.error("file not found:", e);
			path = null;
		} catch (IOException e) {
			logger.error("文件上传error:", e);
			path = null;
		} finally {
			ioClose(in, out);
		}
		return path;
	}

	/**
	 * @description 删除文件
	 * @methodName deleteFile
	 * @param
	 * @returnType void
	 * @throw
	 */
	public static void deleteFile(String path) {
		path = PATH + path;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * @description 关闭流
	 * @methodName ioClose
	 * @param in
	 * @param out
	 * @returnType void
	 * @throw
	 */
	public static void ioClose(InputStream in, OutputStream out) {
		try {
			in.close();
		} catch (IOException e) {
			logger.error("inputStream close error:", e);
		}
		try {
			out.close();
		} catch (IOException e) {
			logger.error("outputStream close error:", e);
		}

	}

}
