package com.example.tweet.service;

import java.util.List;
import java.util.Optional;

import com.example.tweet.model.Retweet;
import com.example.tweet.model.TweetDetails;
import com.example.tweet.model.TweetLike;

public interface TweetService {
 
	TweetDetails addTweet(TweetDetails tweet);
	
	Retweet addReTweet(Retweet retweet);
	
	TweetDetails updateTweet(TweetDetails tweet);
	
	List<TweetDetails> getAllTweets();
	
	List<TweetDetails> getMyTweets(String email);
	
	List<String> replyTweets(String parentTweetId);
	
	String deleteTweet(String id);
	
	void updateLikeCount(String id,String emailId);
}
