package com.rest.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rest.api.model.User;

@Repository
public class UserRepository {
	
	private static Map<Long, User> users = new HashMap<Long, User>();
	
	public User save(User user) {
		long id = 1;
		
		if(!users.isEmpty()) {
			id = Collections.max(users.keySet())+ 1;
		}
		user.setId(id);
		users.put(id, user);
		
		return user;
	}
	
	public List<User> findAll() {
		return new ArrayList<User>(users.values());
	}
}
