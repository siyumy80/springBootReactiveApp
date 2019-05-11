package com.example.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

	User findUserById(Long id);

	
}
