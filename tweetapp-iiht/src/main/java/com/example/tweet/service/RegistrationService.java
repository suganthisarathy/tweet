package com.example.tweet.service;

import java.util.List;

import com.example.tweet.model.RegisterUser;

public interface RegistrationService {
 
	String registerNewUser(RegisterUser user);
	
	List<RegisterUser> fetchAllUsers();
	
	RegisterUser fetchMyDetails(String email);
	
	List<RegisterUser> searchUserByName(String userName);
}
