package com.sharepont.incture.fileuploader.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDto {
	private boolean status;
	private Integer statusCode;
	private String message;
	private Object data;

}
