package com.sharepont.incture.fileuploader.model;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class DocumentModelServiceImpl implements DocumentModelService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SharePointService sharePointService;

	@Override
	public ResponseDto uploadDocument(File file) {
		ResponseDto responseDto = new ResponseDto();

		try {
			responseDto.setStatus(Boolean.TRUE);
			responseDto.setStatusCode(200);

			// String fileName = file.getOriginalFilename().trim().replace(" ",
			// "");
			String fileName = file.getName();

			// /https://incturet.sharepoint.com/:f:/r/sites/Test742/Shared%20Documents/GDT-DEV?csf=1&web=1&e=Yi4vA1
			sharePointService.attachFile("https://incturet.sharepoint.com/sites/"
					+ "Test742" // GroupName
					+ "/_api/web/"
					+ "GetFolderByServerRelativeUrl(%27Shared%20Documents/"
					+ "123Test"// folder name
					+ "%27)/files/add(url=%27" + fileName
					+ "%27,overwrite=false)", FileUtils.readFileToByteArray(file));

			responseDto.setMessage("File uploaded successfully !");

		} catch (Exception e) {
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}

	@Override
	public ResponseDto getDocumentByID(String documentID) {
		ResponseDto responseDto = new ResponseDto();

		try {
			responseDto.setStatus(Boolean.TRUE);
			responseDto.setStatusCode(200);

			byte[] originalDoc = sharePointService.performHttpRequest(HttpMethod.GET,
					"https://incturet.sharepoint.com/sites/" + "Test742/Shared%20Documents/123Test/" + documentID);
			byte[] encoded = Base64.getEncoder().encode(originalDoc);
			responseDto.setMessage(new String(encoded));
		} catch (Exception e) {
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());
		}
		return responseDto;
	}
	@Override
	public String getFolders() {

		try {
			
			return sharePointService.performHttpRequestString(HttpMethod.GET,
					"https://incturet.sharepoint.com/sites/" + "Test742/Shared%20Documents");
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
