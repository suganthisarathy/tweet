package com.example.tweet.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweet.dao.RegistrationDAO;
import com.example.tweet.model.RegisterUser;
import com.example.tweet.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	public String registerNewUser(RegisterUser uiUser) {
		System.out.println(uiUser);
		RegisterUser dbuser = registrationDAO.findByEmailId(uiUser.getEmailId());
		System.out.println(dbuser);
		if(dbuser==null)
		{
			registrationDAO.save(uiUser);
			return "success";
		}
		else {
			
			return "exsist";
		}
		
	}


	public List<RegisterUser> fetchAllUsers() {
		return registrationDAO.findAll();
	}

	public List<RegisterUser> searchUserByName(String userName) {
		return registrationDAO.findByFirstName(userName);
	}

	public RegisterUser fetchMyDetails(String email) {
		return registrationDAO.findByEmailId(email);
	}

}
