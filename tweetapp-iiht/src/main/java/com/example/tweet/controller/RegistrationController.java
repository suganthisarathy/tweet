package com.example.tweet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweet.model.RegisterUser;
import com.example.tweet.service.impl.RegistrationServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1.0/tweets")
public class RegistrationController {
	
	@Autowired
	 RegistrationServiceImpl registrationServiceImpl;
	
	@PostMapping("/register")
	public String registerNewUser(@RequestBody RegisterUser user)
	{
		System.out.println(user);
		return registrationServiceImpl.registerNewUser(user);
	}
    
	@GetMapping("users/all")
	public List<RegisterUser> fetchAllUsers(){
		return registrationServiceImpl.fetchAllUsers();
	}
	@GetMapping("users/{email}")
	public RegisterUser fetchMyDetails(@PathVariable String email){
		return registrationServiceImpl.fetchMyDetails(email);
	}
	
	@GetMapping("user/search/{userName}")
	public List<RegisterUser> searchUserByName(@PathVariable String  userName)
	{
		return registrationServiceImpl.searchUserByName(userName);
	}
}
