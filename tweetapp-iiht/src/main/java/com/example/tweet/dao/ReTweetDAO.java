package com.example.tweet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tweet.model.Retweet;

@Repository
public interface ReTweetDAO extends JpaRepository<Retweet, String> {

	List<Retweet> findByParentTweetId(String parentTweetId);
	

}
