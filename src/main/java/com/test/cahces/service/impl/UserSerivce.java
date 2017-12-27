package com.test.cahces.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.cahces.data.User;
import com.test.cahces.repository.UserRepository;
import com.test.cahces.service.IUserService;
@CacheConfig(cacheNames = "users")
@Service("userService")
public class UserSerivce implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User add(String name, Integer age) {
		User u =new User();
		u.setName(name);
		u.setAge(age);
		return userRepository.save(u);
	}
	
	public User getDetail(Long id) {
		
		return userRepository.findOne(id);
	}
	
	@CacheEvict(key="'userList'",allEntries=false)
	public boolean upd(String name, Long id) {
		User u =new User();
		u.setName(name);
		u.setId(id);
		return userRepository.saveAndFlush(u) !=null ;
	}
	
	@Cacheable(key="'userList'",unless = "#result == null")
	public List<User> getList() {
		
		return userRepository.findAll();
	}
	
	@Cacheable(key="'userList2'",unless = "#result == null")
	public List<User> getList2() {
		
		return userRepository.findAll();
	}
}
