package com.wisely.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	// 接受多个文件上传使用@RequestParam("file") MultipartFile[] files
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file) {

		try {
			FileUtils.writeByteArrayToFile(
					new File("d:/" + file.getOriginalFilename()),
					file.getBytes());
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}

	}

}