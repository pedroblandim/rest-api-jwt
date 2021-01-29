package com.rest.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.model.User;
import com.rest.api.repository.UserRepository;
import com.rest.api.services.api.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Optional<User> insert(User user) {
		user.setEnabled(true);
		user.setRole(User.Role.USER);
		return Optional.of(repo.save(user));
	}

	@Override
	public Optional<User> find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<User> update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}
}
