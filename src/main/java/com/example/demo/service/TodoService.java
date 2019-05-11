package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoRepository;
import com.example.demo.model.TodoRepositoryCustom;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Service
public class TodoService implements TodoRepositoryCustom{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Resource
	private TodoRepository todoRepository; 
	
	@Resource
	private UserRepository userRepository;

	public List<Todo> getTodoList() {
		return todoRepository.findAll();
	}

	public List<User> getUserList() {
		return userRepository.findAll();
	}

	public Todo addTodo(Todo param) {
		return todoRepository.save(param);
	}

	public List<Todo> getTodayTodoList(String date) {
		return todoRepository.findTodoByDate(date);
	}
	@Override
	public long deleteTodoById(String id) {
		DeleteResult result = mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Todo.class);
		return result.getDeletedCount();
	}

	public Todo getTodo(String id) {
		// TODO Auto-generated method stub
		return todoRepository.findTodoById(id);
	}

	public List<Todo> searchTodo(String type, String keywords) {
		List<Todo> result = null;
		if(type.equals("T")) {
			result = mongoTemplate.find(new Query(Criteria.where("title").regex(keywords)), Todo.class);
		} else {
			result = mongoTemplate.find(new Query(Criteria.where("tags").regex(keywords)), Todo.class);
		}
		
		return result;
	}

	public long updatetTodo(Todo param) {
		Update update = new Update().addToSet("title", param.getTitle())
				.addToSet("date", param.getDate())
				.addToSet("tags", param.getTags())
				.addToSet("desc", param.getDesc());
		UpdateResult result =  mongoTemplate.updateFirst(new Query(Criteria.where("id").is(param.getId())),update, Todo.class);
		return result.getModifiedCount();
	}
	
}
