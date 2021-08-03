package com.user.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.user.Beans.ModelMapperBean;
import com.user.DAO.UserDAO;
import com.user.Entities.UserDetails;
import com.user.Repositories.UserDetailsRepository;
import com.user.ResponseModel.UserCreated;

@Service
public class UserManagementService implements UserManagement {

	@Autowired
	UserDetailsRepository userRepo;

//	@Autowired
//	ModelMapperBean mapperBean;

	ModelMapper mapper = new ModelMapper();

	@Override
	public Object create(UserDAO user) {

		UserDetails userDetails = mapper.map(user, UserDetails.class);

		userDetails = userRepo.save(userDetails);

		UserCreated userResponseData = mapper.map(userDetails,UserCreated.class);
		
		return userResponseData;

	}

	@Override
	public Object update(UserDAO user) {

		UserDetails userDetails = mapper.map(user, UserDetails.class);

		userDetails = userRepo.save(userDetails);
		
		UserCreated userResponseData = mapper.map(userDetails,UserCreated.class);
			
		return userResponseData;
	}

	@Override
	public boolean delete(String userId) {

		try {
			userRepo.deleteById(userId);
		} catch (EmptyResultDataAccessException ae) {
			System.err.println("User with userId Doesn't Exist ");
			return false;
		}

		return true;
	}

	@Override
	public Object getUserInfo(String userId) {
		// TODO Auto-generated method stub
		UserDetails user =  userRepo.findById(userId).get();
		if(user == null)
			throw new EmptyResultDataAccessException(1);
			
		UserCreated userResponseData = mapper.map(user,UserCreated.class);
		
		return userResponseData;
	}

}
