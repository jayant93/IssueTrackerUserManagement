package com.user.ResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@SuppressWarnings("rawtypes")
public class ResponseObject extends ResponseEntity{

	@SuppressWarnings("unchecked")
	public ResponseObject(Object body, MultiValueMap headers, HttpStatus status) {
		super(body, headers, status);
	}
	
}
