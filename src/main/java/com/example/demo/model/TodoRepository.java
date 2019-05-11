package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, Long>, TodoRepositoryCustom {

	List<Todo> findTodoByUserId(String userId);
	List<Todo> findTodoByDate(String date);
	Todo findTodoById(String id);
	

}
