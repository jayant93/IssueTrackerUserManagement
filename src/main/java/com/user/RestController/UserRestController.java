package com.user.RestController;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.user.DAO.UserDAO;
import com.user.RequestModel.User;
import com.user.ResponseModel.ResponseObject;
import com.user.Services.UserManagement;
import org.springframework.http.HttpHeaders;

@RestController("/User")
public class UserRestController {

	@Autowired
	UserManagement service;
	
//	@Autowired
//	ModelMapperBean mapperBean;

	ModelMapper mapper = new ModelMapper();
	
	
	@GetMapping("/Get")
	public ResponseObject getUserInfo(@RequestParam String userId) {
		
		Object responseBody = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			responseBody = service.getUserInfo(userId);
		}
		catch(EmptyResultDataAccessException ae) {
			
			headers.add("Request Status", "Failure");
			return new ResponseObject(responseBody, headers, HttpStatus.NOT_FOUND);
			
		}
		
		headers.add("Request Status", "Success");
		return new ResponseObject(responseBody, headers, HttpStatus.OK);
		
	}
	
	@PostMapping("/Create")
	public ResponseObject createUser(@RequestBody User user) {
	
		UserDAO dao = mapper.map(user, UserDAO.class);
		Object responseBody = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			responseBody = service.create(dao);
		} catch (Exception e) {
			headers.add("Request Status", "Failure");
			return new ResponseObject(responseBody, headers, HttpStatus.NOT_FOUND);
		}
		
		headers.add("Request Status", "Success");
		return new ResponseObject(responseBody, headers, HttpStatus.OK);
	}
	
	@PutMapping("/Update")
	public ResponseObject updateUser(@RequestBody User user,@RequestParam String userId) {
	
		UserDAO dao = mapper.map(user, UserDAO.class);
		Object responseBody = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			responseBody = service.update(dao);
		} catch (Exception e) {
			headers.add("Request Status", "Failure");
			return new ResponseObject(responseBody, headers, HttpStatus.NOT_FOUND);
		}
		
		headers.add("Request Status", "Success");
		return new ResponseObject(responseBody, headers, HttpStatus.OK);
	}
	
	@DeleteMapping("/Delete")
	public ResponseObject deleteUser(@RequestParam String userId) {
		
		Boolean response = false;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			response = service.delete(userId);
		}
		catch(EmptyResultDataAccessException ae) {
			
			headers.add("Request Status", "Failure");
			return new ResponseObject(null, headers, HttpStatus.NOT_FOUND);
			
		}
		
		if(response) {
			headers.add("Request Status", "Success");
			return new ResponseObject(null, headers, HttpStatus.OK);
			
		}else {
			headers.add("Request Status", "Failure");
			return new ResponseObject(null, headers, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
