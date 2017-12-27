package com.test.cahces.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.cahces.data.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
		
}
