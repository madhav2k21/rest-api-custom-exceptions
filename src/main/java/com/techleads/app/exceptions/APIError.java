package com.techleads.app.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value = Include.NON_NULL)
public class APIError {
	private String id;
	private String message;
	private String code;
	private String error;
	private String classType;
	
	
	public APIError() {
		super();
	}
	
	
	public APIError(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}


	public APIError(String id, String message, String code, String error, String classType) {
		super();
		this.id = id;
		this.message = message;
		this.code = code;
		this.error = error;
		this.classType = classType;
	}
	
	public APIError(String message, String code, String error) {
		super();
		this.message = message;
		this.code = code;
		this.error = error;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	@Override
	public String toString() {
		return "APIError [id=" + id + ", message=" + message + ", code=" + code + ", error=" + error + ", classType="
				+ classType + "]";
	}
	
	

}