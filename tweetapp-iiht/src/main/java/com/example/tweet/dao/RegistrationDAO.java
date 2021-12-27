package com.example.tweet.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tweet.model.RegisterUser;

@Repository
public interface RegistrationDAO extends JpaRepository<RegisterUser, String>{

	List<RegisterUser> findByFirstName(String userName);

	RegisterUser findByEmailId(String email);
}
