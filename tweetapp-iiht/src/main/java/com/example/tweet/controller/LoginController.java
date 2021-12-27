package com.example.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweet.model.LoginDetails;
import com.example.tweet.service.impl.LoginServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/tweets")
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDetails loginDetails) {
		return loginServiceImpl.verifyUserLogin(loginDetails.getEmail(), loginDetails.getPassword());

	}
	@PostMapping("/forgot")
	public String forgetPassword(@RequestBody LoginDetails loginDetails) {
		return loginServiceImpl.forgotPassword(loginDetails.getEmail(),loginDetails.getPassword());

	}
	@PostMapping("/logout/{email}")
	public String logout(@PathVariable String  email) {
		return loginServiceImpl.logout(email);

	}
}
