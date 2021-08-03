package com.user.RequestModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message = "Name Should Not be Null")
	private String name;

	@Email(message = "Email format incorrect")
	private String email;

	@Size(min = 10,max = 10,message = "phone number should be of 10 digits only")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNumber;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
