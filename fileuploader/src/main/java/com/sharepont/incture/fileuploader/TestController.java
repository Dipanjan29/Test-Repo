package com.sharepont.incture.fileuploader;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sharepoint.incture.fileuploader.controller.ServiceUtil;
import com.sharepont.incture.fileuploader.model.DocumentModelService;
import com.sharepont.incture.fileuploader.model.ResponseDto;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	DocumentModelService service;
	@PostMapping("/upload")
	public ResponseDto upload(@RequestParam("file") MultipartFile file) throws IOException{
		File fileToUpload = ServiceUtil.multipartToFile(file);
		return service.uploadDocument(fileToUpload);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseDto download(@PathVariable("fileName") String fileName){
		return service.getDocumentByID(fileName);
	}
	@GetMapping("get")
	public String get(){
		return service.getFolders();
	}
}
