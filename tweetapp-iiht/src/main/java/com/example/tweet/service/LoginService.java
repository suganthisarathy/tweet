package com.example.tweet.service;

public interface LoginService {

	String verifyUserLogin(String email,String password);
	
	String forgotPassword(String email,String password);
	
	String logout(String email);
}
