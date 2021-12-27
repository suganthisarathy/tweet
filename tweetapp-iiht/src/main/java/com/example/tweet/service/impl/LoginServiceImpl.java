package com.example.tweet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweet.dao.RegistrationDAO;
import com.example.tweet.model.RegisterUser;
import com.example.tweet.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {


@Autowired
	RegistrationDAO registrationDAO;

	@Override
	public String verifyUserLogin(String email, String password) {
		// TODO Auto-generated method stub
	RegisterUser dbuser=registrationDAO.findByEmailId(email); 

	
		if (dbuser!=null) {
			String dbPassword=dbuser.getPassword();
			if (dbPassword.equals(password)) {
				dbuser.setStatus(true);
				registrationDAO.save(dbuser);
				return dbuser.getEmailId();
			} else {
				return "password mismatch";
			}
		} else {
			return "no such user";
		}
	}

	@Override
	public String forgotPassword(String email, String password) {
		// TODO Auto-generated method stub
		RegisterUser dbuser=registrationDAO.findByEmailId(email); 

		if (dbuser!=null) {
			dbuser.setPassword(password);
			registrationDAO.save(dbuser);
			return "password has been reset successfully,please login to continue";
			
		} else {
			return "no such user";
		}
	}

	@Override
	public String logout(String email) {
		// TODO Auto-generated method stub
		RegisterUser dbuser = registrationDAO.findByEmailId(email);
		dbuser.setStatus(false);
		registrationDAO.save(dbuser);
		return "logged out  successfully";
	}

}
