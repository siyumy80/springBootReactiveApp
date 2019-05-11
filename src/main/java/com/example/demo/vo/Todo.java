package com.example.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class Todo {
	private String id;
	
	private String userId;
	private String title;
	private String date;
	private String desc;
	private List<String> tags;
}
