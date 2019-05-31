/** 
  *  myblog 
  *  com.blog.myblog.util 
  *  FileUploadUtils.java 
  *  1.0 
  *  2019年5月31日 下午3:57:15 
  */
package com.blog.myblog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description TODO
 * @createTime 2019年5月31日 下午3:57:15
 * @modifyTime
 * @author dyangwork@126.com
 * @version 1.0
 */
public class FileUploadUtils {

	private static final String PATH = "D:\\www";

	public static String uploadFile(MultipartFile mutiFile) throws IOException{
		
		String dir = DateUtils.dateToString(new Date(), "yyyy-MM-dd");
		String originName = mutiFile.getOriginalFilename();
		String type = originName.split(".")[1];
		String newFileName = UUIDUtils.nextUUID()+"."+type;
		String path = PATH +"\\upload\\"+dir+"\\"+newFileName; 
		
		InputStream in = null;
		FileOutputStream out = null;
		in = mutiFile.getInputStream();
		
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
		out = new FileOutputStream(file);
		int byteCount = 0;
		int byteReader = -1;
		
		byte[] buffer = new byte[4096];
		while((byteReader = in.read(buffer))!=-1){
			out.write(buffer,0,byteReader);
			byteCount += byteReader;
		}
		out.flush();
		return newFileName;
	}

}
