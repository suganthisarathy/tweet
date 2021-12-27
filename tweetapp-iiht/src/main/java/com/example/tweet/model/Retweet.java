package com.example.tweet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="retweet")
public class Retweet {
	@Id
	private String reTweetId;
	private String parentTweetId;
	private String retweet;
	private int reTweetLikeCount;
	
}
