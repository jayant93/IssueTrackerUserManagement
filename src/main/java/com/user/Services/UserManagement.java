package com.user.Services;

import com.user.DAO.UserDAO;

public interface UserManagement {
	
	public Object create(UserDAO user);
	
	public Object update(UserDAO user);
	
	public boolean delete(String userId);
	
	public Object getUserInfo(String usrId);

}
