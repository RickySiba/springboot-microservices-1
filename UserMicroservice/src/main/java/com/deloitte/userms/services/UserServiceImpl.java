package com.deloitte.userms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.userms.dao.UserRepository;
import com.deloitte.userms.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User findByUserId(Integer userId) {
		User userFromDb = this.userRepository.findByUserId(userId);
		return userFromDb;
	}

	@Override
	public User addUser(User user) {
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public User deleteUser(Integer userId) {
		User userFromDb = this.userRepository.getById(userId);
		
		this.userRepository.delete(userFromDb);
		
		return userFromDb;
	}

}
