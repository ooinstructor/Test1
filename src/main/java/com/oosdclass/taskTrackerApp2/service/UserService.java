package com.oosdclass.taskTrackerApp2.service;

import com.oosdclass.taskTrackerApp2.model.User;

public interface UserService {
	
	//checks to see if the 
	public boolean isUserValid(User user);

	boolean doesUserExist(User user);

	boolean isUserAdmin(User user);

}
