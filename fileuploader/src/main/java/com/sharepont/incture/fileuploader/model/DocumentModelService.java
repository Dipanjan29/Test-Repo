package com.sharepont.incture.fileuploader.model;

import java.io.File;


public interface DocumentModelService {

	ResponseDto getDocumentByID(String documentID);

	ResponseDto uploadDocument(File file);
	
	String getFolders();

	

}
