package com.example.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tweet.model.TweetLike;

@Repository
public interface TweetLikeDAO extends JpaRepository<TweetLike,String>{

	@Query("select likeData  from TweetLike likeData where likeData.tweetId = ?1 and likeData.emailId = ?2")
	TweetLike findTweetDetails(String tweetId,String emailId);

	@Query("select count(likeData)  from TweetLike likeData where likeData.tweetId = ?1 and likeData.liked = 1")
	int getLikeCount(String tweetId);

}
