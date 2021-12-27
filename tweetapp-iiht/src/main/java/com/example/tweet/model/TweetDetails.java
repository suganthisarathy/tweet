package com.example.tweet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tweet")
public class TweetDetails {
	@Id
	private String id;
	private int likeCount;
	private String emailId;
	private String userName;
    private String tweet;
	
}
