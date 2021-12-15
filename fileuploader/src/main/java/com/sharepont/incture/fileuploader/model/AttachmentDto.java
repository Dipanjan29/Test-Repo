package com.sharepont.incture.fileuploader.model;

import lombok.Data;

@Data
public class AttachmentDto {

	private String entityId;

	private String entityType;

	private String documentId;

	private String documentName;

	private String fileContent;

	private String contentType;

	private byte[] content;

}
