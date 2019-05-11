package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


@Document(collection = "Todo")
@Data
public class Todo {

	@Id
	private String id;
	
	@Field("user_id")
	private String userId = "ymshin";
	@Field("titld")
	private String title;
	@Field("date")
	private String date;
	@Field("desc")
	private String desc;
	@Field("tags")
	private List<String> tags;
	
	public Todo() {
		
	}
	public Todo(String userId, String title, String date, String desc, List<String> tags) {
		this.userId = userId;
		this.title = title;
		this.date = date;
		this.desc = desc;
		this.tags = tags;
	}


	public String getId() {
		return id;
	}


	public String getUserId() {
		return userId;
	}


	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public String getDesc() {
		return desc;
	}

	public List<String> getTags() {
		return tags;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
