package com.medifeeds.register.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medifeeds.register.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {
	User insert(User user);
	User findByUseremail(String useremail);
	}
