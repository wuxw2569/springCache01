package com.test.cahces.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.cahces.data.User;
import com.test.cahces.repository.UserRepository;
import com.test.cahces.service.IUserService2;
@CacheConfig(cacheNames = "users2")
@Service("userService2")
public class UserService2 implements IUserService2 {
	
	@Autowired
	UserRepository userRepository;
	
	@Cacheable(key="'userList'",unless = "#result == null")
	public List<User> getList() {
		
		return userRepository.findAll();
	}
}
