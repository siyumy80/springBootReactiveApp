package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoRepository;

@SpringBootApplication
public class SpringBootReactiveAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveAppApplication.class, args);
	}
	
	/*
	 * @Bean CommandLineRunner init(TodoRepository todoRepository) { return args ->
	 * { todoRepository.deleteAll(); List<Todo> todoTestList = new
	 * ArrayList<Todo>(); Todo todo1 = new Todo("ymshin",
	 * "test1","2019-05-11",null,null); Todo todo2 = new Todo("ymshin",
	 * "test1","2019-05-11",null,Arrays.asList("vueJs","Javascript","FrameWork"));
	 * todoTestList.add(todo1); todoTestList.add(todo2);
	 * 
	 * todoRepository.saveAll(todoTestList); };
	 * 
	 * }
	 */
	
}
