package com.test.cahces.service;

import java.util.List;

import com.test.cahces.data.User;

public interface IUserService {
	List<User> getList2();
	List<User> getList();
	
	User getDetail(Long id);
	
	User add(String name,Integer age);
	
	boolean upd(String name,Long id);
}
