package com.techleads.app.exceptions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value = Include.NON_NULL)
public class APIError {
	private String id;
	private String message;
	private String code;
	private String error;
	private String allowedType;
	private List<String> allowedNames;
	
	
	public APIError() {
		super();
	}
	
	
	public APIError(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}


	public APIError(String message, String code, String error, String allowedType) {
		super();
		this.message = message;
		this.code = code;
		this.error = error;
		this.allowedType = allowedType;
	}
	
	public APIError(String message, String code, String error) {
		super();
		this.message = message;
		this.code = code;
		this.error = error;
	}


	public APIError(String message, String code, String error, List<String> allowedNames) {
		super();
		this.message = message;
		this.code = code;
		this.error = error;
		this.allowedNames = allowedNames;
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


	public String getAllowedType() {
		return allowedType;
	}


	public void setAllowedType(String allowedType) {
		this.allowedType = allowedType;
	}


	public List<String> getAllowedNames() {
		return allowedNames;
	}


	public void setAllowedNames(List<String> allowedNames) {
		this.allowedNames = allowedNames;
	}


	@Override
	public String toString() {
		return "APIError [id=" + id + ", message=" + message + ", code=" + code + ", error=" + error + ", allowedType="
				+ allowedType + ", allowedNames=" + allowedNames + "]";
	}


	
	
	
	

}