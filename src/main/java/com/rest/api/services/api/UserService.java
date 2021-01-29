package com.rest.api.services.api;

import java.util.List;
import java.util.Optional;

import com.rest.api.model.User;

public interface UserService {

	Optional<User> find(long id);
	
	Optional<User> insert(User user);
	
	Optional<User> update(User user);
	
	Optional<User> delete(long id);
	
	List<User> findAll();
}
