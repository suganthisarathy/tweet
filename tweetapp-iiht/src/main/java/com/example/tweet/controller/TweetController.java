package com.example.tweet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweet.model.Retweet;
import com.example.tweet.model.TweetDetails;
import com.example.tweet.service.impl.TweetServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetController {
	@Autowired
	TweetServiceImpl tweetServiceImpl;

	@PostMapping("/postNewTweet")
	public TweetDetails postTweet(@RequestBody TweetDetails tweet){
		return tweetServiceImpl.addTweet(tweet);
	}
	@PostMapping("/postReTweet")
	public Retweet postReTweet(@RequestBody Retweet retweet){
		return tweetServiceImpl.addReTweet(retweet);
	}
	
	@GetMapping("/allTweets")
	public List<TweetDetails> alltweets()
	{
		return tweetServiceImpl.getAllTweets();
	}
	@GetMapping("/myTweets/{email}")
	public List<TweetDetails> mytweets(@PathVariable String email)
	{
		
		return tweetServiceImpl.getMyTweets(email);
	}
	@GetMapping("/replyTweets/{id}")
	public List<String> replytweets(@PathVariable String id)
	{
		
		return tweetServiceImpl.replyTweets(id);
	}
	@PostMapping("/likeTweet/{id}/{emailId}")
	public void likeTweet(@PathVariable String id,@PathVariable String emailId){
		tweetServiceImpl.updateLikeCount(id,emailId);
	}
	
	@PostMapping("/updateTweet")
	public void updateTweet(@RequestBody TweetDetails tweet){
		tweetServiceImpl.updateTweet(tweet);
	}
	@DeleteMapping("/deleteTweet/{id}")
	public String deleteTweet(@PathVariable String id){
		return tweetServiceImpl.deleteTweet(id);
	}
}
