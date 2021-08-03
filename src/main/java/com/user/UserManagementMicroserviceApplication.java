package com.user;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.user.Utility.FinalVariables;

@SpringBootApplication
public class UserManagementMicroserviceApplication {

	
	public static void main(String[] args) {
		
	    Logger log = LoggerFactory.getLogger(UserManagementMicroserviceApplication.class);
		log.debug(FinalVariables.TAG+" User ManagerMent Microservice started ....");
		SpringApplication.run(UserManagementMicroserviceApplication.class, args);
	}

}
