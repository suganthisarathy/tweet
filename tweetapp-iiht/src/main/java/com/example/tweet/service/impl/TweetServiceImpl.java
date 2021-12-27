package com.example.tweet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tweet.dao.ReTweetDAO;
import com.example.tweet.dao.TweetDAO;
import com.example.tweet.dao.TweetLikeDAO;
import com.example.tweet.model.Retweet;
import com.example.tweet.model.TweetDetails;
import com.example.tweet.model.TweetLike;
import com.example.tweet.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	TweetDAO tweetDAO;
	@Autowired
	ReTweetDAO reTweetDAO;
	@Autowired
	TweetLikeDAO tweetLikeDAO;


	public TweetDetails addTweet(TweetDetails tweet) {
		TweetLike tweetLike=new TweetLike();
		tweetLike.setEmailId(tweet.getEmailId());
		tweetLike.setTweetId(tweet.getId());
		tweetLikeDAO.save(tweetLike);
		return tweetDAO.save(tweet);
	}

	public List<TweetDetails> getAllTweets() {
		return tweetDAO.findAll();
	}


	public List<TweetDetails> getMyTweets(String email) {
		return tweetDAO.findByEmailId(email);
	}


	public String deleteTweet(String tweetId) {
		tweetDAO.deleteById(tweetId);
		return "deleted";
	}
	
	@SuppressWarnings("null")
	public void updateLikeCount(String tweetId,String emailId) {
//		
//		TweetDetails tweet=tweetDAO.getById(id);
//		int dbLikeCount=tweet.getLikeCount();
//		tweet.setLikeCount(dbLikeCount+1);
//		tweetDAO.save(tweet);
//		return (dbLikeCount+1);
		System.out.println(tweetId+" "+emailId);
		TweetLike likeRecord=tweetLikeDAO.findTweetDetails(tweetId,emailId);
		if(likeRecord!=null) {
			//liking own tweet
			likeRecord.setLiked(true);
		}else{
		//liking another person tweet
			TweetLike newLikeRecord=new TweetLike();
			newLikeRecord.setTweetId(tweetId);
			newLikeRecord.setEmailId(emailId);
			newLikeRecord.setLiked(true);
			tweetLikeDAO.save(newLikeRecord);		
		}
		System.out.println(likeRecord);
		int likeCount=tweetLikeDAO.getLikeCount(tweetId);
		
		System.out.println(likeCount);
		TweetDetails likedTweet=tweetDAO.findByTweetId(tweetId);
		System.out.println("LikedTweet:"+likedTweet);
		if(likedTweet!=null) {
		likedTweet.setLikeCount(likeCount);
		tweetDAO.save(likedTweet);
		}
		//we have to update like column in tweet table where tweetId=tweetId
	}

	
	public List<String> replyTweets(String parentTweetId) {
		// TODO Auto-generated method stub
		List<Retweet> tweets = reTweetDAO.findByParentTweetId(parentTweetId);
		List<String> myTweets = tweets.stream().map(Retweet::getRetweet).collect(Collectors.toList());
		return myTweets;
	}


	public TweetDetails updateTweet(TweetDetails tweet) {
		tweetDAO.save(tweet);		
		return tweet;
	}


	public Retweet addReTweet(Retweet retweet) {
		return reTweetDAO.save(retweet);
	}

}
