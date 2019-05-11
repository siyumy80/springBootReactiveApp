package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "User")
public class User {

	@Id
	private Long id;
	
	@Indexed(unique = true)
	@Field ("user_id")
	private String userId;
	@Field ("user_password")
	private String userPassword;
	
	public User(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	
	
}
