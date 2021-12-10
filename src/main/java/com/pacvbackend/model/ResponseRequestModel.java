package com.pacvbackend.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRequestModel {

	private Object result;
	private Integer status;
	private String message;
	
	public ResponseRequestModel(Object result, Integer status) {
		this.result = result;
		this.status = status;
	}
	
	public ResponseRequestModel(Object result, Integer status, String message) {
		this.result = result;
		this.status = status;
		this.message = message;
	}
	
	public ResponseRequestModel() {
		this.result = "";
		this.status = HttpStatus.OK.value();
	}
}
