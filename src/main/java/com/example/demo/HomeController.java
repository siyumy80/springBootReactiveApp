package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.model.User;
import com.example.demo.service.TodoService;


@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	TodoService todoService;
	
	
	@GetMapping("/todo")
	List<Todo> todoList() {
		return todoService.getTodoList();
	}
	@GetMapping("/todo/{id}")
	Todo todoTodayList(@PathVariable("id")String id) {
		return todoService.getTodo(id);
	}
	@GetMapping("/todo/update/{id}")
	long updateTodo(@PathVariable("id")String id, @RequestBody Todo param) {
		
		return todoService.updatetTodo(param);
	}
	@PostMapping("/todo/add")
	Todo addTodo(@RequestBody Todo param) {
		return todoService.addTodo(param);
	}
	
	@PostMapping("/todo/delete")
	long deleteTodo(@RequestBody Todo param) {
		return todoService.deleteTodoById(param.getId());
	}
	
	@GetMapping("/user")
	List<User> userList() {
		return todoService.getUserList();
	}
	@GetMapping("/todo/search")
	List<Todo> searchTodo(@RequestParam("type") String type, @RequestParam("keywords") String  keywords) {
		return todoService.searchTodo(type, keywords);
	}
}
